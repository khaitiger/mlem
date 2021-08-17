package fpt.edu.mlem.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fpt.edu.mlem.entities.CommentLesson;
import fpt.edu.mlem.repositories.CommentLessonRepository;

@Service
public class CommentLessonService {
	@Autowired
	CommentLessonRepository commentLessonRepository;
	
	public CommentLesson createCommentLesson(CommentLesson cmtLesson) {
		cmtLesson.setCommentDate(new Date());
		return commentLessonRepository.save(cmtLesson);
	}
	
	public CommentLesson getById(int id) {
		return commentLessonRepository.getById(id);
	}
	

}
