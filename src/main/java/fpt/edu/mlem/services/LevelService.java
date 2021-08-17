package fpt.edu.mlem.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Level;
import fpt.edu.mlem.repositories.LevelCourseRepository;

@Service
public class LevelService {
	@Autowired
	private LevelCourseRepository levelCourseRepositpry;
	
	public ArrayList<Level> getAllLevelCourse() {
		return (ArrayList<Level>) levelCourseRepositpry.findAll();
	}
		
	public Level saveLevel(Level level) {
		return levelCourseRepositpry.save(level);  
	}

	
	public void deleteLevelCourse(int id) {
		levelCourseRepositpry.deleteById(id);
	}

	
	public Level findLevelCourseById(int id) {
		return levelCourseRepositpry.findById(id).get();
	}

}
