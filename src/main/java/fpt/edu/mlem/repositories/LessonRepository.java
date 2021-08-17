package fpt.edu.mlem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Lesson;



@Repository

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
