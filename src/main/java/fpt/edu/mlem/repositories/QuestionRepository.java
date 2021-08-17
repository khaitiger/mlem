package fpt.edu.mlem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Question;
import fpt.edu.mlem.entities.Test;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
	
	List<Question> findByTest(Test test);
	@Modifying
	@Query(value = "INSERT INTO question_answer("
			+ "content, correct, question_id)"
			+ "	VALUES (?1, ?2, ?3)",nativeQuery = true)
	void insertAnswer(String content,boolean correct,int questionId);
}
