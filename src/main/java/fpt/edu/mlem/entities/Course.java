package fpt.edu.mlem.entities;




import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int price;
	private int sale;
	private Date createDate;
	private Date endDate;
	private String content;
	private String image;
	private String urlVideoCourse;
	private String urlYoutubeCourse;
	private String status;
	private String startSale;
	private String endSale;
	@ManyToOne
	private Level level;

	@ManyToMany
	private Set<Category> categories = new HashSet<Category>();
	
	@ManyToOne
	private Account manager;
	
	
	public void addRole(Category c) {
		this.categories.add(c);
	}
}
