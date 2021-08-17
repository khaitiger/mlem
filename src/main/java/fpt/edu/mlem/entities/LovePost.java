package fpt.edu.mlem.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class LovePost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	private Date loveDate;	
	private boolean status;
	@ManyToOne(fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Post post;
	@OneToOne
	private Account lover;
}
