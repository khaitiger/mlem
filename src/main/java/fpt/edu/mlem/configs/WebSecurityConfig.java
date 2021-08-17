package fpt.edu.mlem.configs;





import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Provider;
import fpt.edu.mlem.entities.Role;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.CustomOAuth2UserService;
import fpt.edu.mlem.utils.UtilsWish;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			.and()			
			.csrf().disable()
			//public page
			.authorizeRequests()
			.antMatchers("/*",
					"/upload",
					"/login",
					"/oauth/**",
					"/css/**",
					"/images/**",
					"/js/**",
					"/vendor/**").permitAll()
			//page must login by user role
			.antMatchers("/view")
			.access("hasAnyRole('ROLE_USER')")
			
			//page must login by admin role
			.antMatchers("/admin/**")
			.access("hasRole('ROLE_ADMIN')")
			//page must login by teach role
			.antMatchers("/teacher/**")
			.access("hasRole('ROLE_TEACHER')")
			
			//page must login by manager categories role
			.antMatchers("/manager_categories/**")
			.access("hasRole('ROLE_MANAGER_CATEGORIES')")
			
			//page must login by manager course role
			.antMatchers("/manager/**")
			.access("hasRole('ROLE_MANAGER_COURSE')")
			
			.anyRequest().authenticated()
//			.formLogin().permitAll()
//				.loginPage("/login")
//				.usernameParameter("email")
//				.passwordParameter("pass")
//				.defaultSuccessUrl("/list")
			
			.and()
//			.requestMatcher(withoutCookieToken())
			.oauth2Login()
				.loginPage("/login")
			//.loginProcessingUrl("/processlogin")
				.userInfoEndpoint()
					.userService(oauthUserService)
				.and()
				.successHandler(new AuthenticationSuccessHandler() {
					
					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						System.out.println("AuthenticationSuccessHandler invoked");
						System.out.println("Authentication name: " + authentication);
						DefaultOAuth2User oauthUser = (DefaultOAuth2User) authentication.getPrincipal();
						Account newUser = new Account();
						newUser.setEmail(oauthUser.getAttribute("email"));
						newUser.setFullName(oauthUser.getAttribute("name"));
					    newUser.setRole(new Role(5,null));
					    
					    if (oauthUser.getAttribute("sub")!=null) {
					    	    newUser.setProvider(Provider.GOOGLE);
							    newUser.setAvatar(oauthUser.getAttribute("picture"));
							    newUser.setEnable(oauthUser.getAttribute("email_verified"));
						} else {
							 newUser.setProvider(Provider.FACEBOOK);
							 newUser.setEnable(true);
						}
						//save user into database
					    accountService.processOAuthPostLogin(newUser);							
						
						//add new user into session
						//request.getSession(true).setAttribute("MY_USER", newUser);
						
						
						//set my user cookie
					    utilsWish.setMyAccountCookie(newUser, response);
				
						response.sendRedirect("/");
					}
				})
				
			.and()
			.logout()		
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.deleteCookies("MY_USER")
			.invalidateHttpSession(true)
			.logoutSuccessUrl("/").permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403")
			;
	}
	
	


	@Autowired
	private CustomOAuth2UserService oauthUserService;
	
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	UtilsWish utilsWish;

	
//	private RequestMatcher withoutCookieToken() {
//		  return request -> request.getCookies() == null || Arrays.stream(request.getCookies()).noneMatch(cookie -> cookie.getName().equals("MY_USER"));
//		}
	
	
	
	
}
