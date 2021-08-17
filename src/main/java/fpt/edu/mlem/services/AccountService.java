package fpt.edu.mlem.services;






import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Provider;
import fpt.edu.mlem.repositories.AccountRepository;
import fpt.edu.mlem.repositories.RoleRepository;
import fpt.edu.mlem.utils.UtilsWish;






@Service

public class AccountService {
	
	@Autowired
	AccountRepository repo;
	
	@Autowired
	RoleRepository rRepo;
	
	@Autowired
	UtilsWish utilsWish;
	
	public void processOAuthPostLogin(Account account) {
		Account existAccount = repo.getUserByEmail(account.getEmail(), account.getProvider());
		//System.out.print("find user" + existAccount);

		if (existAccount == null) {

			repo.save(account);

		}

	}
	public void updateEnable(int id) {
		repo.updateEnable(id);
	}
	public Account getUserByEmailAndProvider(String email,Provider provider) {
		return repo.getUserByEmail(email, provider);
	}
	public Optional<Account> getUseById(int id) {
		return repo.findById(id);
	}

	public void deleteAccount(int id) {
		repo.deleteById(id);
	}

	public Account updateEnableAccount(int id,boolean enable) {
		Account account = repo.findById(id).get();
		account.setEnable(enable);
		return repo.save(account);
	}

	public Account updateRoleUser(int id,int roleId) {
		Account account = repo.findById(id).get();
		account.setRole(rRepo.findById(roleId).get());
		return repo.save(account);
	}
	public void updateProfile(int id, String fullName , String phone , String dob , String gender , String about,String linkFace , String linkYoutube) {
		repo.updateProfile(id, fullName, phone, dob, gender, about, linkFace, linkYoutube);
	}
	public List<Account> listAll(){
		return repo.findAll();
	}
	public List<Account> getUserByRole(int idRole){
		return repo.getUserByRole(idRole);
	}
	public List<Account> getUserByEnable(Boolean enable){
		return repo.getUserByEnable(enable);
	}
//	public void saveUpdate(Account account) {
//		repo.save(account);
//	}
//	public Account getUpdateAccount(int id) {
//		return repo.findById(id).get();
//	}
	public Account getAccount(String userCookie) {
		if(userCookie.equals("defaultCookieValue")) {
			
			return null;
			
		} 
		else {
			Account user = utilsWish.getMyAccountCookie(userCookie);
			Account user1 = repo.getUserByEmail(user.getEmail(), user.getProvider());
			user.setFullName(user.getFullName().replace('+', ' '));
			return user1;
		}
		
	}
}
