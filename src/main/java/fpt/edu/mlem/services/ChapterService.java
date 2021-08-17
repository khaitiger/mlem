package fpt.edu.mlem.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Chapter;
import fpt.edu.mlem.entities.Course;
import fpt.edu.mlem.repositories.ChapterRepository;
import fpt.edu.mlem.repositories.CourseRepository;


@Service
public class ChapterService {

	@Autowired
	ChapterRepository chapterRepository;
	
	@Autowired
	CourseRepository generalCourseRepository;
	
	public Chapter createChapter(Chapter chapter,int generalCourseId) {
		Course generalCourse = generalCourseRepository.getById(generalCourseId);
		chapter.setCourse(generalCourse);
		chapter.setCreatDate(new Date());
		return chapterRepository.save(chapter);
	}
	public List<Chapter> getByCourse(int courseId){
		return chapterRepository.getChapterByCourse(courseId);
	}
	public List<Chapter> listAllChapter(){
		return chapterRepository.findAll();
	}
	
}
