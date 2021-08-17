package fpt.edu.mlem.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.ListTeacher;

@Repository
@Transactional
public interface ListTeacherRepository extends JpaRepository<ListTeacher, Integer> {
	@Query("SELECT u FROM ListTeacher u WHERE u.teacher.id = ?1")
	public List<ListTeacher> getCoursebyTeacher(int idTeacher);
}
