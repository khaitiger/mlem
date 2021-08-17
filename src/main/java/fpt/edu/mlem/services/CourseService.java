package fpt.edu.mlem.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Category;
import fpt.edu.mlem.entities.Course;
import fpt.edu.mlem.entities.Level;
import fpt.edu.mlem.repositories.CategoryRepository;
import fpt.edu.mlem.repositories.CourseRepository;


@Service
public class CourseService {
	@Autowired
	private CourseRepository generalCourseRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	public void setSale(int id, int sale ,String startSale , String endSale) {
		generalCourseRepository.setSaleCourse(id, sale, startSale, endSale);;
	}
	public List<Course> listAllCourse(){
		return generalCourseRepository.findAll();
	}
	public Page<Course> getGeneralCoursePage(int page,int quantity) {
		return  generalCourseRepository.findAll(PageRequest.of(page, quantity));
	}
	public List<Course> getCourseByStatus(String status){
		return generalCourseRepository.getCoursebyStatus(status);
	}
	public Course getCourseById(int id) {
		return generalCourseRepository.getById(id);
	}
	public Course saveGeneralCourse(Course generalCourse,int[] cateIdArray,Level levelCourse,Account manager) {
		
		// add categories
		
		
			for (int i = 0; i < cateIdArray.length; i++) {
				int id = cateIdArray[i];
				Category category = categoryRepository.findById(id).get();
				generalCourse.addRole(category);
				
			}
		// set Categories of generalCourse

		//set manager
		generalCourse.setManager(manager);
		
		// set LevelCourse of generalCourse
		generalCourse.setLevel(levelCourse);
		
		generalCourse.setCreateDate(new Date());
		generalCourse.setStatus("Đang xử lý");;
		
		return generalCourseRepository.save(generalCourse);  
	}

	public void deleteGeneralCourse(int id) {
		generalCourseRepository.deleteById(id);
	}
	
//	public List<Course> GetGSbyLevel(int lvid ) {
//		return  generalCourseRepository.getCoursebyLevel(lvid);
//	}
//	
	public Course findGeneralCourseById(int id) {
		return generalCourseRepository.findById(id).get();
	}

}
