package fpt.edu.mlem.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Course;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.entities.Order;
import fpt.edu.mlem.entities.courseAcountKey;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.CourseService;
import fpt.edu.mlem.services.ListStudentService;

import fpt.edu.mlem.services.PaypalService;



@Controller
public class PaypalController {
	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";
	public static final String HOST =//"https://team-do-an-2020.herokuapp.com/"
			"http://localhost:8080/";

	
	@Autowired
	ListStudentService ls;
	@Autowired
	CourseService gs;
	@Autowired
	PaypalService service;

	@Autowired
	AccountService userService;

	@RequestMapping(value = "/paypal", method = RequestMethod.POST)
	public String Home(int id,
			Model model) {
			Course genC = gs.findGeneralCourseById(id);
			model.addAttribute("genC", genC);
	 return "paypal";
	}

	@RequestMapping(value = "/pay")
	public String payment(@ModelAttribute("order") Order order) {
		try {

			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), HOST + CANCEL_URL,
					HOST + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "cancel";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
				Model model) {
	        try {
	        	if(userCookie.equals("defaultCookieValue")) {
	    			
	    			
	    			model.addAttribute("user", null);
	    		} 
	    		else {
	    		  	Account user = userService.getAccount(userCookie);
	    		  	Account user1 = userService.getUserByEmailAndProvider(user.getEmail(),user.getProvider());
	    			user.setFullName(user.getFullName().replace('+', ' '));
	    			model.addAttribute("user", user1);
	    			Payment payment1 = new Payment();
	    	        model.addAttribute("payment", payment1);
	    			 Payment payment = service.executePayment(paymentId, payerId);
	 	            System.out.println(payment.toJSON());
	 	            if (payment.getState().equals("approved")) {
	 	            	Transaction transaction = payment.getTransactions().get(0);
	 	            	int courseID = Integer.parseInt(transaction.getDescription());
//	 	            	payment1.setA (user1.getId());
//	 	            	payment1.setGeneralCourseId(courseID);
//	 	            	payment1.setPaymentDate(new Date());
//	 	            	payS.save(payment1);
	 	            	ListStudent listStudent =  new ListStudent();
	 	            	listStudent.setCourse(gs.findGeneralCourseById(courseID));
	 	            	listStudent.setStudent(user1);
	 	            	listStudent.setJoinDate(new Date());
	 	            	courseAcountKey key = new courseAcountKey();
	 	            	key.setStudentId(user1.getId());
	 	            	key.setCourseId(courseID);
	 	            	listStudent.setId(key);
	 	            	ls.createListStudent(listStudent);
	 	            	System.out.println("Test*******"+transaction.getDescription());
	 	                return "redirect:/MyCourse";
	    		}
	           
	            }
	        } catch (PayPalRESTException e) {
	         e.printStackTrace();
	        }
	        return "redirect:/";
	    }
	    
	 }
