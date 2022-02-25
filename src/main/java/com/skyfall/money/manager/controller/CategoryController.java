package com.skyfall.money.manager.controller;

import com.skyfall.money.manager.model.Category;
import com.skyfall.money.manager.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@Api(value = "Swagger2DemoRestController", description = "REST API for managing Category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "Get list of Categories in the System ", response = Iterable.class, tags = "Categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @ApiOperation(value = "Add new Category in the System ", response = Iterable.class, tags = "Categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @PostMapping("/addCategory")
    public ResponseEntity<java.io.Serializable> addCategory(@RequestBody Category category) {
        Category categories = categoryService.addNewCategory(category);
        if (categories.getId() != null) {
            return new ResponseEntity<>(categories, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("failed to add new category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Delete Category in the System ", response = String.class, tags = "Categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        try {
            categoryService.deleteCategory(id);
            return new ResponseEntity<>("Deleted category successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unable to delete category.", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
