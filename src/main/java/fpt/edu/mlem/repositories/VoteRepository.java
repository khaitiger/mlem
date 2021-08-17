package fpt.edu.mlem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Vote;
@Repository
public interface VoteRepository extends CrudRepository<Vote, Integer>{
	@Query("SELECT v FROM Vote v WHERE v.course.id = ?1")
	public List<Vote> getVoteByCourse(int course_id);
	@Query("SELECT v FROM Vote v WHERE v.numVote = ?1 AND v.course.id = ?2")
	public List<Vote> getVoteByNumberVote(int numVote, int course_id);
	@Query("SELECT v FROM Vote v WHERE v.student.id = ?1")
	public List<Vote> getVoteByStudent(int id);

}
