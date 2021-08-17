package fpt.edu.mlem.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class CommentLesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private Date commentDate;	
	private String content;
	
	@OneToMany(
			mappedBy = "commentLesson"
			)
	private Set<RepCommentLesson> RepommentLessonList = new HashSet<>() ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Lesson lesson;
	
	@ManyToOne
	@EqualsAndHashCode.Exclude
	private Account commenter;
}
