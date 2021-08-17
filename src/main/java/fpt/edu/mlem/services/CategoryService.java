package fpt.edu.mlem.services;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.edu.mlem.entities.Category;
import fpt.edu.mlem.repositories.CategoryRepository;




@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoriesRepository;
	
	public ArrayList<Category> getAllCategories() {
		return (ArrayList<Category>) categoriesRepository.findAll();
	}

	
	public Category saveCategories(Category categories) {
		return categoriesRepository.save(categories);  
	}

	
	public void deleteCategories(int id) {
		categoriesRepository.deleteById(id);
	}

	
	public Category findCategoriesById(int id) {
		return categoriesRepository.findById(id).get();
	}
}
