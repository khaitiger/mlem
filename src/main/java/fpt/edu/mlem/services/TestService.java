package fpt.edu.mlem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Test;
import fpt.edu.mlem.repositories.TestRepository;


@Service
public class TestService {
	@Autowired
	private TestRepository testRepo;
	
	public void save(Test test) {
		testRepo.save(test);
	}
	
	
	public List<Test> getTest(int id){
		//return testRepo.findByTestId(id);
		return null;
	}
	
	
	public Page<Test> getTest(int page, int size){
		return testRepo.findAll(PageRequest.of(page, size));
		
	}
	
	
	public List<Test>getAllTest(){
		return testRepo.findAll();
	}
	public List<Test> getTestbyCourse(int idCourse){
		return testRepo.getTestbyCourse(idCourse);
	}
	
	public void delete(int id) {
		testRepo.deleteById(id);
	}
	



}
