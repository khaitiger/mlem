package fpt.edu.mlem.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
