package fpt.edu.mlem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import fpt.edu.mlem.entities.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>  {

}
