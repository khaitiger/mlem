package fpt.edu.mlem.controllers;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Category;
import fpt.edu.mlem.entities.Chapter;
import fpt.edu.mlem.entities.Course;
import fpt.edu.mlem.entities.Level;
import fpt.edu.mlem.entities.ListStudent;
import fpt.edu.mlem.entities.ListTeacher;
import fpt.edu.mlem.entities.chapterAcountKey;
import fpt.edu.mlem.requests.CreateGeneralCourseRequest;
import fpt.edu.mlem.services.AccountService;
import fpt.edu.mlem.services.CategoryService;
import fpt.edu.mlem.services.ChapterService;
import fpt.edu.mlem.services.CourseService;
import fpt.edu.mlem.services.LevelService;
import fpt.edu.mlem.services.ListStudentService;
import fpt.edu.mlem.services.ListTeacherService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AccountService accountService;
	@Autowired
	ListStudentService studentService;
	@Autowired
	ListTeacherService listTeacherService;
	@Autowired
	private AccountService userService;
	@RequestMapping("/analyics")
	public String Analyics(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model) {
		if (userCookie.equals("defaultCookieValue")) {
			model.addAttribute("user", null);
			System.out.print("defaultCookieValue");
		} else {
			Account user = accountService.getAccount(userCookie);
			model.addAttribute("user", user);
			Date d = new Date();
			int month = d.getMonth() + 1;
			int year = d.getYear() + 1900;
//			 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c6 = Calendar.getInstance();
			Calendar c5 = Calendar.getInstance();
			Calendar c4 = Calendar.getInstance();
			Calendar c3 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			Calendar c1 = Calendar.getInstance();
			c6.setTime(d);
			c5.setTime(d);
			c4.setTime(d);
			c3.setTime(d);
			c2.setTime(d);
			c1.setTime(d);			
			c6.add(Calendar.DATE, -1);
			c5.add(Calendar.DATE, -2);
			c4.add(Calendar.DATE, -3);
			c3.add(Calendar.DATE, -4);
			c2.add(Calendar.DATE, -5);
			c1.add(Calendar.DATE, -6);
			int day = d.getDate();
			int day6 = c6.getTime().getDate();
			int day5 = c5.getTime().getDate();
			int day4 = c4.getTime().getDate();
			int day3 = c3.getTime().getDate();
			int day2 = c2.getTime().getDate();
			int day1 = c1.getTime().getDate();

			int month6 = c6.getTime().getMonth()+1;
			int month5 = c5.getTime().getMonth()+1;
			int month4 = c4.getTime().getMonth()+1;
			int month3 = c3.getTime().getMonth()+1;
			int month2 = c2.getTime().getMonth()+1;
			int month1 = c1.getTime().getMonth()+1;
			int year6 = c6.getTime().getYear()+1900;
			int year5 = c5.getTime().getYear()+1900;
			int year4 = c4.getTime().getYear()+1900;
			int year3 = c3.getTime().getYear()+1900;
			int year2 = c2.getTime().getYear()+1900;
			int year1 = c1.getTime().getYear()+1900;
	
		List<ListStudent> ls7 = studentService.GetStudentbyDay(year, month, day);
		List<ListStudent> ls6 = studentService.GetStudentbyDay(year6, month6, day6);
		List<ListStudent> ls5 = studentService.GetStudentbyDay(year5, month5, day5);
		List<ListStudent> ls4 = studentService.GetStudentbyDay(year4, month4, day4);
		List<ListStudent> ls3 = studentService.GetStudentbyDay(year3, month3, day3);
		List<ListStudent> ls2 = studentService.GetStudentbyDay(year2, month2, day2);
		List<ListStudent> ls1 = studentService.GetStudentbyDay(year1, month1, day1);
		model.addAttribute("ls7", ls7.size());
		model.addAttribute("ls6", ls6.size());
		model.addAttribute("ls5", ls5.size());
		model.addAttribute("ls4", ls4.size());
		model.addAttribute("ls3", ls3.size());
		model.addAttribute("ls2", ls2.size());
		model.addAttribute("ls1", ls1.size());
		int totalStudentOfWeek = ls7.size() + ls6.size() + ls5.size() + ls4.size() + ls3.size() + ls2.size()
				+ ls1.size();
		model.addAttribute("totalStudentOfWeek", totalStudentOfWeek);
		int priceOfDay7 = 0;
		for (ListStudent l7 : ls7) {
			priceOfDay7= priceOfDay7+ l7.getCourse().getPrice();
		}
		int priceOfDay6 = 0;
		for (ListStudent l6 : ls6) {
			priceOfDay6= priceOfDay6+ l6.getCourse().getPrice();
		}
		int priceOfDay5 = 0;
		for (ListStudent l5 : ls5) {
			priceOfDay5= priceOfDay5+ l5.getCourse().getPrice();
		}
		int priceOfDay4 = 0;
		for (ListStudent l4 : ls4) {
			priceOfDay4= priceOfDay4+ l4.getCourse().getPrice();
		}
		int priceOfDay3 = 0;
		for (ListStudent l3 : ls3) {
			priceOfDay3= priceOfDay3+ l3.getCourse().getPrice();
		}
		int priceOfDay2 = 0;
		for (ListStudent l2 : ls2) {
			priceOfDay2= priceOfDay2+ l2.getCourse().getPrice();
		}
		int priceOfDay1 = 0;
		for (ListStudent l1 : ls1) {
			priceOfDay1= priceOfDay1+ l1.getCourse().getPrice();
		}
		int priceOfWeek= priceOfDay1+priceOfDay2+priceOfDay3+priceOfDay4+priceOfDay5+priceOfDay6+priceOfDay7;
		model.addAttribute("priceOfDay1", priceOfDay1);
		model.addAttribute("priceOfDay2", priceOfDay2);
		model.addAttribute("priceOfDay3", priceOfDay3);
		model.addAttribute("priceOfDay4", priceOfDay4);
		model.addAttribute("priceOfDay5",priceOfDay5);
		model.addAttribute("priceOfDay6", priceOfDay6);
		model.addAttribute("priceOfDay7", priceOfDay7);
		model.addAttribute("priceOfWeek", priceOfWeek);
		System.out.println(day);
			List<ListStudent> listStudent1 = studentService.GetStudentbyDate(year, 01);
			List<ListStudent> listStudent2 = studentService.GetStudentbyDate(year, 02);
			List<ListStudent> listStudent3 = studentService.GetStudentbyDate(year, 03);
			List<ListStudent> listStudent4 = studentService.GetStudentbyDate(year, 04);
			List<ListStudent> listStudent5 = studentService.GetStudentbyDate(year, 05);
			List<ListStudent> listStudent6 = studentService.GetStudentbyDate(year, 06);
			List<ListStudent> listStudent7 = studentService.GetStudentbyDate(year, 07);
			List<ListStudent> listStudent8 = studentService.GetStudentbyDate(year, 8);
			List<ListStudent> listStudent9 = studentService.GetStudentbyDate(year, 9);
			List<ListStudent> listStudent10 = studentService.GetStudentbyDate(year, 10);
			List<ListStudent> listStudent11 = studentService.GetStudentbyDate(year, 11);
			List<ListStudent> listStudent12 = studentService.GetStudentbyDate(year, 12);

			int totalStudentOfYear = listStudent1.size() + listStudent2.size() + listStudent3.size()
					+ listStudent4.size() + listStudent5.size() + listStudent6.size() + listStudent7.size()
					+ listStudent8.size() + listStudent9.size() + listStudent10.size() + listStudent11.size()
					+ listStudent12.size();
			model.addAttribute("listStudent1", listStudent1.size());
			model.addAttribute("listStudent2", listStudent2.size());
			model.addAttribute("listStudent3", listStudent3.size());
			model.addAttribute("listStudent4", listStudent4.size());
			model.addAttribute("listStudent5", listStudent5.size());
			model.addAttribute("listStudent6", listStudent6.size());
			model.addAttribute("listStudent7", listStudent7.size());
			model.addAttribute("listStudent8", listStudent8.size());
			model.addAttribute("listStudent9", listStudent9.size());
			model.addAttribute("listStudent10", listStudent10.size());
			model.addAttribute("listStudent11", listStudent11.size());
			model.addAttribute("listStudent12", listStudent12.size());
			model.addAttribute("totalStudentOfYear", totalStudentOfYear);
			int saleofMonth1 = 0;
			for (ListStudent list : listStudent1) {
				saleofMonth1 = saleofMonth1+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth1", saleofMonth1);
			int saleofMonth2 = 0;
			for (ListStudent list : listStudent2) {
				saleofMonth2 = saleofMonth2+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth2", saleofMonth2);
			int saleofMonth3 = 0;
			for (ListStudent list : listStudent3) {
				saleofMonth3 = saleofMonth3+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth3", saleofMonth3);
			int saleofMonth4 = 0;
			for (ListStudent list : listStudent4) {
				saleofMonth4 = saleofMonth4+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth4", saleofMonth4);
			int saleofMonth5 = 0;
			for (ListStudent list : listStudent5) {
				saleofMonth5 = saleofMonth5+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth5", saleofMonth5);
			int saleofMonth6 = 0;
			for (ListStudent list : listStudent6) {
				saleofMonth6 = saleofMonth6+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth6", saleofMonth6);
			int saleofMonth7 = 0;
			for (ListStudent list : listStudent7) {
				saleofMonth7 = saleofMonth7+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth7", saleofMonth7);
			int saleofMonth8 = 0;
			for (ListStudent list : listStudent8) {
				saleofMonth8 = saleofMonth8+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth8", saleofMonth8);
			int saleofMonth9 = 0;
			for (ListStudent list : listStudent9) {
				saleofMonth9 = saleofMonth9+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth9", saleofMonth9);
			int saleofMonth10 = 0;
			for (ListStudent list : listStudent10) {
				saleofMonth10 = saleofMonth10+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth10", saleofMonth10);
			int saleofMonth11 = 0;
			for (ListStudent list : listStudent11) {
				saleofMonth11 = saleofMonth11+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth11", saleofMonth11);
			int saleofMonth12 = 0;
			for (ListStudent list : listStudent12) {
				saleofMonth12 = saleofMonth12+ list.getCourse().getPrice();
			}
			model.addAttribute("saleofMonth12", saleofMonth12);
			model.addAttribute("saleofYear", saleofMonth1+saleofMonth2+saleofMonth3+
					saleofMonth4+saleofMonth5+saleofMonth6+saleofMonth7+saleofMonth8+saleofMonth9+
					saleofMonth10+saleofMonth11+saleofMonth12);
			
		}

		return "instructor_analyics";
	}
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private LevelService levelService;
	@Autowired
	private CourseService generalCourseService;

	@Autowired
	ChapterService chapterservice;
	@Autowired
	CourseService couSer;
	@RequestMapping(value = "/generalCourse/create", method = RequestMethod.GET)
	public String createPage(
			@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie, Model model) {
		ArrayList<Category> cateName = (ArrayList<Category>) categoryService.getAllCategories();
		ArrayList<Level> levelName = (ArrayList<Level>) levelService.getAllLevelCourse();
		model.addAttribute("levelName",levelName);
		model.addAttribute("cateName",cateName);
		model.addAttribute("user", accountService.getAccount(userCookie));
		return "create_new_course";
	}
	@RequestMapping(value = "/generalCourse/create", method = RequestMethod.POST)
	@ResponseBody
	public Course create(@RequestBody CreateGeneralCourseRequest request,
			@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie) {
		
		// get cateId Array
		int[] cateIdArray = request.getCateIdArray();
		//get GeneralCourse
		Course gc = request.getGeneralCourse();
		// get level course by id
		Level levelCourse = levelService.findLevelCourseById(request.getLvId());
		
		//get account
		Account manager = accountService.getAccount(userCookie);
		
		return generalCourseService.saveGeneralCourse(gc,cateIdArray,levelCourse,manager);
		//request.setGeneralCourse(generalCourseService.saveGeneralCourse(request.getGeneralCourse()));
		
	}
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String ManagerAcc(
			 Model model) {
		List<Account> listAll = accountService.listAll();
		List<Account> listUser = accountService.getUserByRole(5);
		List<Account> listTearcher = accountService.getUserByRole(2);
		List<Account> listBlocked = accountService.getUserByEnable(false);
		model.addAttribute("listAll", listAll);
		model.addAttribute("All", listAll.size());
		model.addAttribute("listUser", listUser.size());
		model.addAttribute("listTearcher", listTearcher.size());
		model.addAttribute("listBlocked", listBlocked.size());
	
		return "instructor_member";
	}
	@RequestMapping(value = "/saveblock", method = RequestMethod.POST)
	public String SaveBlock(Model model,@RequestParam("id") int id
			) {
		accountService.updateEnable(id);
		return "redirect:/admin/account";
	}
	@RequestMapping(value = "/verification", method = RequestMethod.GET)
	public String Verification(
			 Model model) {
		
		return "instructor_verification";
	}
	@RequestMapping(value = "/saveverification", method = RequestMethod.POST)
	public String SaveVerification(
			Model model,@RequestParam("id") int id,
			@RequestParam("roleId") int roleId) {
			accountService.updateRoleUser(id, roleId);
		return "redirect:/admin/account";
	}
	@RequestMapping(value = "/saveaddteacher", method = RequestMethod.POST)
	public String SaveAddTeacher(
			Model model,@RequestParam("idTeacher") int idTeacher,
			@RequestParam("idCourse") int idCourse) {
			ListTeacher listTeacher = new ListTeacher();

			chapterAcountKey chapterAcountKey = new chapterAcountKey();
			
			chapterAcountKey.setCourseId(idCourse);
			chapterAcountKey.setTeacherId(idTeacher);
			listTeacher.setId(chapterAcountKey);
			listTeacher.setJoinDate(new Date());
			listTeacherService.createListTeacher(listTeacher);
		return "redirect:/admin/account";
	}
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public String ViewManagerCourse(
			 Model model) {
		List<Course> listAllCourse = couSer.listAllCourse();
		List<Chapter> listAll = chapterservice.listAllChapter();
		List<Course> liActive = couSer.getCourseByStatus("Đang hoạt động");
		List<Course> liProcessing = couSer.getCourseByStatus("Đang xử lý");
		List<Course> liPause = couSer.getCourseByStatus("Tạm Dừng");
		List<Account> listTearcher = accountService.getUserByRole(2);
		model.addAttribute("liActive", liActive);
		model.addAttribute("listTearcher", listTearcher);
		model.addAttribute("liProcessing", liProcessing);
		model.addAttribute("liPause", liPause);
		model.addAttribute("listAll", listAll);
		model.addAttribute("listAllCourse", listAllCourse);
		return "course_edit_view";
	}
	@RequestMapping(value = "/savesale", method = RequestMethod.POST)
	public String SaveSale(@CookieValue(value = "MY_USER", defaultValue = "defaultCookieValue") String userCookie,
			Model model,@RequestParam("id") int id,
			@RequestParam("sale") int sale,
			@RequestParam("startSale") String startSale,
			@RequestParam("endSale") String endSale) {
		if(userCookie.equals("defaultCookieValue")) {
			
			
			model.addAttribute("user", null);
		} 
		else {
			Account user = accountService.getAccount(userCookie);
			model.addAttribute("user", user);
			couSer.setSale(id, sale, startSale, endSale);
		}
			
		return "redirect:/admin/course";
	}
	
	
}
