package fpt.edu.mlem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.ListTeacher;
import fpt.edu.mlem.repositories.ListTeacherRepository;
import java.util.List;
@Service
public class ListTeacherService {
@Autowired
ListTeacherRepository listTeacherRepository;
 public List<ListTeacher> getCoursebyTeacher(int idTeacher){
	 return listTeacherRepository.getCoursebyTeacher(idTeacher);
 }
}
