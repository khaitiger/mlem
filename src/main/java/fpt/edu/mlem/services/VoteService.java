package fpt.edu.mlem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import fpt.edu.mlem.entities.Vote;
import fpt.edu.mlem.repositories.VoteRepository;
@Service
public class VoteService {
@Autowired
private VoteRepository voterepo;
 public void saveVote(Vote vote) {
	  voterepo.save(vote);
 }
	public List<Vote> getVoteByCourse(int courseId){
		return voterepo.getVoteByCourse(courseId);
	}
	public List<Vote> getAllVote(){
		return (List<Vote>) voterepo.findAll();
	}
	public List<Vote> getVoteByNumber(int numVote,int courseId){
		return voterepo.getVoteByNumberVote(numVote,courseId);
	}
	public List<Vote> getVoteByStudent(int id){
		return voterepo.getVoteByStudent(id);
	}
	
}


