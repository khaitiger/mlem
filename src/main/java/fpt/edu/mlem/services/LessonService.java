package fpt.edu.mlem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Chapter;
import fpt.edu.mlem.entities.Lesson;
import fpt.edu.mlem.repositories.AccountRepository;
import fpt.edu.mlem.repositories.ChapterRepository;
import fpt.edu.mlem.repositories.LessonRepository;

@Service
public class LessonService {
	
	@Autowired
	LessonRepository lessonRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ChapterRepository chapterRepository;
	
	public Lesson createLession(Lesson lesson ,int teacherId,int chapterId) {
		Account account  = accountRepository.findById(teacherId).get();
		
		Chapter chapter = chapterRepository.getById(chapterId);
		
		chapter.setTeacher(account);
		lesson.setChapter(chapter);
		
		return lessonRepository.save(lesson);
		
	}
	
	public Lesson getById(int id) {
		return lessonRepository.getById(id);
	}
}
