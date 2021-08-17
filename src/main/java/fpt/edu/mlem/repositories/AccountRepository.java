package fpt.edu.mlem.repositories;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Provider;





@Transactional

public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("SELECT u FROM Account u WHERE u.email = :email AND u.provider = :auth_provider")
	public Account getUserByEmail(@Param("email") String email,
			                   @Param("auth_provider") Provider provider);
	@Query("SELECT u FROM Account u WHERE u.role.id = ?1")
	public List<Account> getUserByRole(int idRole);
	@Query("SELECT u FROM Account u WHERE u.enable = ?1")
	public List<Account> getUserByEnable(Boolean enable);
	@Modifying
	@Query("UPDATE  Account a SET a.enable = false WHERE a.id = ?1")
	public void updateEnable(int id);

	@Modifying
	@Query("UPDATE  Account a SET a.fullName = ?2 , a.phone= ?3 , a.dob= ?4 , a.gender= ?5 , a.about= ?6 , a.linkFace= ?7 , a.linkYoutube= ?8 WHERE a.id = ?1")
	public void updateProfile(int id, String fullName , String phone , String dob , String gender , String about,String linkFace ,String linkYoutube);
}