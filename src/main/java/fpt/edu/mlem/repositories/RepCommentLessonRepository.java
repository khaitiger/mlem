package fpt.edu.mlem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.RepCommentLesson;

@Repository
public interface RepCommentLessonRepository extends JpaRepository<RepCommentLesson, Integer> {

}
