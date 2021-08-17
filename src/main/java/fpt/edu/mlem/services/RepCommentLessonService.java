package fpt.edu.mlem.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.CommentLesson;
import fpt.edu.mlem.entities.RepCommentLesson;
import fpt.edu.mlem.repositories.CommentLessonRepository;
import fpt.edu.mlem.repositories.RepCommentLessonRepository;

@Service
public class RepCommentLessonService {
	@Autowired
	RepCommentLessonRepository RepCommentLessonRepository;
	@Autowired
	CommentLessonRepository commentLessonRepository;
	
	public RepCommentLesson createCommentLesson(RepCommentLesson rep) {
		rep.setRepCmtDate(new Date());
		return RepCommentLessonRepository.save(rep);
	}
	
	
	public List<RepCommentLesson> getRepCommentLessonByCommenter(Account commenter) {
		List<RepCommentLesson> listRep = new ArrayList<>();
		List<CommentLesson> listCmt = commentLessonRepository.findByCommenterOrderByCommentDateDesc(commenter);
		for (CommentLesson commentLesson : listCmt) {
			for (RepCommentLesson rep : commentLesson.getRepommentLessonList()) {
			if(!rep.getRepCommenter().equals(commenter)) {
				listRep.add(rep);
			}	
			}
		}
		return listRep; 
	}
}
