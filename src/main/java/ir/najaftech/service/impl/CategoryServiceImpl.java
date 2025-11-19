package ir.najaftech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import ir.najaftech.dto.response.CategoryResponse;
import ir.najaftech.model.Category;
import ir.najaftech.repository.CategoryRepository;
import ir.najaftech.service.CategoryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
 
    private final CategoryRepository repo;
    private final ModelMapper modelMapper;
    
    @Override
    public CategoryResponse findById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("ID cannot be null");
        }
        Category cat = repo.findById(id).orElseThrow(() -> new Exception("Category not found"));
        return modelMapper.map(cat, CategoryResponse.class);
    }

    @Override
    public List<CategoryResponse> findAll() {
        List<Category> categories = repo.findAll();
        List<CategoryResponse> responses = new ArrayList<>();
        categories.forEach(cat -> {
            responses.add(modelMapper.map(cat, CategoryResponse.class));
        });
        return responses;
    }

}