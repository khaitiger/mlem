package fpt.edu.mlem.utils;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import fpt.edu.mlem.entities.Account;



@Component
public class UtilsWish {
	public Account getMyAccountCookie(String userCookie) {
		Account user =null;
		try {
			 Gson gson = new Gson();
			 user  = gson.fromJson(userCookie, Account.class);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return user;
		}

	public void setMyAccountCookie(Account newUser, HttpServletResponse response) throws UnsupportedEncodingException {
		Gson gson = new Gson();	
		//User object to string
		String string = gson.toJson(newUser);
		Cookie newCookie = new Cookie("MY_USER", URLEncoder.encode(string, "utf-8"));					
        newCookie.setMaxAge(24 * 60 * 60);
        newCookie.setPath("/");
        response.addCookie(newCookie);
		
	}
}
