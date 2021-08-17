package fpt.edu.mlem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>  {
	@Query("SELECT c FROM Test c WHERE c.course.id = ?1")
	public List<Test> getTestbyCourse(int idCourse);

}
