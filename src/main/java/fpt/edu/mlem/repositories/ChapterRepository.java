package fpt.edu.mlem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import fpt.edu.mlem.entities.Chapter;




@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
	@Query("SELECT c FROM Chapter c WHERE c.course.id = ?1")
	public List<Chapter> getChapterByCourse(int course_id);
}
