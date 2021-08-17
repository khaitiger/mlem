package fpt.edu.mlem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String fullName;
	private String gender;
	private String phone;
	private String linkFace;
	private String linkYoutube;
	private String about;
	private String dob;
	private Date dateCreate;
	private boolean enable;
	private String avatar;
	@Column(name = "auth_provider")
	private Provider provider;
	
	@ManyToOne
	private Role role;
	
	
	
}
