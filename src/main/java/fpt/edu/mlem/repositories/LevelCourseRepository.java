package fpt.edu.mlem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Level;



@Repository
public interface LevelCourseRepository extends JpaRepository<Level, Integer> {

}
