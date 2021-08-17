package fpt.edu.mlem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.edu.mlem.entities.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
//	@Query("Select role_name from RoleUser where role_id = :roleId")
//	String getRoleName(@Param("roleId") int roleId);
}
