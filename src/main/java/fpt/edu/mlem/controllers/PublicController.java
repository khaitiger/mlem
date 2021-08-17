package fpt.edu.mlem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Course;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.entities.Vote;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.CourseService;
import fpt.edu.mlem.services.ListStudentService;
import fpt.edu.mlem.services.VoteService;


@Controller
public class PublicController {

	@RequestMapping("/")
	public String Home(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {	
			model.addAttribute("user", null);
			System.out.print("defaultCookieValue");
		} 
		else {
			Account user = userService.getAccount(userCookie);
	
			model.addAttribute("user", user);
			System.out.print(user);
			List<ListStudent> listStudent = studentService.GetBotMail(user);
			model.addAttribute("listStudent", listStudent);
		}
		
	 return "index";
	}
//	@RequestMapping("KhoaHocCoBan")
//	public String LevelCoBan(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
//			Model model) {
//		if(userCookie.equals("defaultCookieValue")) {
//			
//			
//			model.addAttribute("user", null);
//		} 
//		else {
//			Account user = userService.getAccount(userCookie);
//			
//			model.addAttribute("user", user);
////			Optional<LevelCourse> CoBan =  levelCourseService.findLevelCourseById(1);
////			model.addAttribute("CoBan",CoBan);
//			List<Course> CoBan = generalCourseService.GetGSbyLevel(1);
//				
//		        model.addAttribute("CoBan", CoBan);
//		}
//			
//		return "KhoaHocCoBan";
//	}
//	@RequestMapping("KhoaHocTrungCap")
//	public String LevelTrungCap(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
//			Model model) {
//		if(userCookie.equals("defaultCookieValue")) {
//			
//			
//			model.addAttribute("user", null);
//		} 
//		else {
//	Account user = userService.getAccount(userCookie);
//			
//			model.addAttribute("user", user);
////			Optional<LevelCourse> CoBan =  levelCourseService.findLevelCourseById(1);
////			model.addAttribute("CoBan",CoBan);
//			List<Course> TrungCap = generalCourseService.GetGSbyLevel(2);
//				
//		        model.addAttribute("TrungCap", TrungCap);
//		}
//			
//		return "KhoaHocTrungCap";
//	}
//	@RequestMapping("KhoaHocCaoCap")
//	public String LevelCaoCap(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
//			Model model) {
//		if(userCookie.equals("defaultCookieValue")) {
//			
//			
//			model.addAttribute("user", null);
//		} 
//		else {
//	Account user = userService.getAccount(userCookie);
//			
//			model.addAttribute("user", user);
////			Optional<LevelCourse> CoBan =  levelCourseService.findLevelCourseById(1);
////			model.addAttribute("CoBan",CoBan);
//			List<Course> CaoCap = generalCourseService.GetGSbyLevel(2);
//				
//		        model.addAttribute("CaoCap", CaoCap);
//		}
//			
//		return "KhoaHocCaoCap";
//	}
	@RequestMapping("/header")
	public String Header(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {	
			model.addAttribute("user", null);
			System.out.print("defaultCookieValue");
		} 
		else {
			Account user = userService.getAccount(userCookie);
	
			model.addAttribute("user", user);
			System.out.print(user);
			List<ListStudent> listStudent = studentService.GetBotMail(user);
			model.addAttribute("listStudent", listStudent);
		}
		
	 return "header";
	}
	@RequestMapping("/chatbox")
	public String ChatBot(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {	
			model.addAttribute("user", null);
			System.out.print("defaultCookieValue");
		} 
		else {
			Account user = userService.getAccount(userCookie);
	
			model.addAttribute("user", user);
			System.out.print(user);
			List<ListStudent> listStudent = studentService.GetBotMail(user);
			model.addAttribute("listStudent", listStudent);
		}
		
	 return "chatbox";
	}
	@RequestMapping("/menu_user")
	public String Menu(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {	
			model.addAttribute("user", null);
			System.out.print("defaultCookieValue");
		} 
		else {
			Account user = userService.getAccount(userCookie);
	
			model.addAttribute("user", user);
			System.out.print(user);
			List<ListStudent> listStudent = studentService.GetBotMail(user);
			model.addAttribute("listStudent", listStudent);
		}
		
	 return "menu_user";
	}

	@RequestMapping("/menu_mana")
	public String MenuManager(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {	
			model.addAttribute("user", null);
			System.out.print("defaultCookieValue");
		} 
		else {
			Account user = userService.getAccount(userCookie);
	
			model.addAttribute("user", user);
			System.out.print(user);
			List<ListStudent> listStudent = studentService.GetBotMail(user);
			model.addAttribute("listStudent", listStudent);
		}
		
	 return "menu_mana";
	}
	@RequestMapping("listcourse")
	public String Listcourse(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Page<Course> list = generalCourseService.getGeneralCoursePage(0, 8);
				
		        model.addAttribute("list", list);
		      
			Account user = accountService.getAccount(userCookie);
			model.addAttribute("user", user);
			
	}
		return "listcourse";

	}
	@RequestMapping("/lockCourse")
	public String Lockcourse(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
		
			Account user = accountService.getAccount(userCookie);
			model.addAttribute("user", user);
			
	}
		return "course_study_lock";

	}
	@RequestMapping("course_detail_view/{id}")
	public String Course_detail_view(@PathVariable(name = "id") int id,@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			Vote vote = new Vote();
			List<Vote> votetotal = voteSer.getVoteByCourse(id);
			List<Vote> vote1Star = voteSer.getVoteByNumber(1,id);
			List<Vote> vote2Star = voteSer.getVoteByNumber(2,id);
			List<Vote> vote3Star = voteSer.getVoteByNumber(3,id);
			List<Vote> vote4Star = voteSer.getVoteByNumber(4,id);
			List<Vote> vote5Star = voteSer.getVoteByNumber(5,id);
			int totalStar = votetotal.size();
			int vote1 = vote1Star.size(); 
			float vote1Percent = (float)vote1/totalStar*100;
			model.addAttribute("vote1Percent", vote1Percent); 
			int vote2 = vote2Star.size();
			float vote2Percent = (float)vote2/totalStar*100;
			model.addAttribute("vote2Percent", vote2Percent); 
			int vote3 = vote3Star.size();
			float vote3Percent = (float)vote3/totalStar*100;
			model.addAttribute("vote3Percent", vote3Percent); 
			int vote4 = vote4Star.size();
			float vote4Percent = (float)vote4/totalStar*100;
			model.addAttribute("vote4Percent", vote4Percent); 
			int vote5 = vote5Star.size();
			float vote5Percent = (float)vote5/totalStar*100;
			model.addAttribute("vote5Percent", vote5Percent); 
			float averageStar = (float)(vote1*1+vote2*2+vote3*3+vote4*4+vote5*5)/totalStar;
			model.addAttribute("totalStar", totalStar); 
			model.addAttribute("averageStar", averageStar); 
			model.addAttribute("user", user);
			Course generalC = generalCourseService.findGeneralCourseById(id);
			model.addAttribute("generalC", generalC);
			vote.setCourse(generalC);
			model.addAttribute("vote", vote);
			List<Vote> voteCourse = voteSer.getVoteByCourse(id);
			model.addAttribute("voteCourse", voteCourse);
			List<ListStudent> list = studentService.GetBotMail(user);
			boolean check = false;
			for (ListStudent listStudent : list) {
				if(listStudent.getCourse().getId()==generalC.getId()) {
					check=true;
					
					break;
				}
			}
			model.addAttribute("check", check);
		}
			
		return "course_detail_view";
	}

	@RequestMapping("MyCourse")
	public String MyCourse(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
		
			model.addAttribute("user", user);
			List<ListStudent> list = studentService.GetBotMail(user);
			model.addAttribute("list", list);
		}
			
		return "KhoaHocCuaToi";
	}

	@RequestMapping("/news")
	public String News(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
		
			model.addAttribute("user", user);

		}
			
		return "post_view";
	}
	@RequestMapping("/profileAccount")
	public String Profile(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			List<Vote> votStudent =  voteSer.getVoteByStudent(user.getId());
			model.addAttribute("votStudent" , votStudent);
			model.addAttribute("user", user);
		
		}
			
		return "my_instructor_profile_view";
	}
	@RequestMapping("/editprofile")
	public String SetingProfile(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
		
			model.addAttribute("user", user);

		}
			
		return "setting";
	}
	@RequestMapping(value = "/saveprofile", method = RequestMethod.POST)
	public String SaveProfile(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model,@RequestParam("fullName") String fullName,
			@RequestParam("phone") String phone,
			@RequestParam("dob") String dob,
			@RequestParam("gender") String gender,
			@RequestParam("about") String about,
			@RequestParam("linkFace") String linkFace,
			@RequestParam("linkYoutube") String linkYoutube) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = userService.getAccount(userCookie);
			int id = user.getId();
			model.addAttribute("user", user);
			userService.updateProfile(id, fullName, phone, dob, gender, about, "http://facebook.com/"+linkFace, "http://www.youtube.com/"+linkYoutube);
			System.out.println("-------------====="+fullName);
		}
			
		return "redirect:/profileAccount";
	}

	@Autowired
	private AccountService userService;
	@Autowired
	private ListStudentService studentService;
	@Autowired
	private CourseService generalCourseService;
	@Autowired
	AccountService accountService;
	@Autowired
	VoteService voteSer;
}
