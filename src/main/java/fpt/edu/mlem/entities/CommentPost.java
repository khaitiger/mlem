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
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class CommentPost {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id; 
		private Date commentDate;	
		private String content;
		@ManyToOne(fetch = FetchType.LAZY)
		@EqualsAndHashCode.Exclude
		@JsonIgnore
		private Post post;
		
		@ManyToOne
		@EqualsAndHashCode.Exclude
		private Account commenter;
	}


