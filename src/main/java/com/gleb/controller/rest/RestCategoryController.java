package com.gleb.controller.rest;

import com.gleb.controller.constrain.model.CategoryDto;
import com.gleb.serves.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
public class RestCategoryController {

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDto>> getAll() {
        return Optional.ofNullable(categoryService.getAll().stream()
                .map(CategoryDto::of)
                .collect(toList()))
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}
