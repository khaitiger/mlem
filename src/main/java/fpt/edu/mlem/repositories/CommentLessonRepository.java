package fpt.edu.mlem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.CommentLesson;

@Repository
public interface CommentLessonRepository extends JpaRepository<CommentLesson,Integer> {
	
	List<CommentLesson> findByCommenterOrderByCommentDateDesc(Account commenter);
}
