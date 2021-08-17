package fpt.edu.mlem.entities;
 

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String title;	
	private String urlVideo;	
	private String urlFile;	
	private String des_lesson;	
	private Date date_lesson;	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Chapter chapter;
	
	
	
}
