package fpt.edu.mlem.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.Level;
import fpt.edu.mlem.entities.Course;


@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query("SELECT c FROM Course c WHERE c.status = ?1")
	public List<Course> getCoursebyStatus(@Param("status") String status);

	 @Modifying
	@Query("UPDATE  Course c SET c.sale = ?2 , c.startSale= ?3 , c.endSale= ?4 WHERE c.id = ?1")
	public void setSaleCourse(int id, int sale , String startSale , String endSale);


}
