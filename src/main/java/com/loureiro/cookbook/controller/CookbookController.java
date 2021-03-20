package com.loureiro.cookbook.controller;

import com.loureiro.cookbook.entity.Cookbook;
import com.loureiro.cookbook.repository.CookbookRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cookbook/v1")
public class CookbookController {

    private final CookbookRepository cookbookRepository;

    public CookbookController(CookbookRepository cookbookRepository) {
        this.cookbookRepository = cookbookRepository;
    }

    @PostMapping("cookbook")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookbook createRecipe(@RequestBody Cookbook recipe) {
        return cookbookRepository.create(recipe);
    }

    @GetMapping("cookbook")
    public List<Cookbook> getPersons() {
        return cookbookRepository.findAll();
    }

    @GetMapping("cookbook/{id}")
    public ResponseEntity<Cookbook> getRecipe(@PathVariable ObjectId id) {
        Cookbook recipe = cookbookRepository.findById(id);
        if (recipe == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("cookbook/{id}")
    public void deleteRecipe(@PathVariable ObjectId id) {
        cookbookRepository.delete(id);
    }

    @PutMapping("cookbook/{id}")
    public Cookbook updateRecipe(@RequestBody Cookbook recipe) {
        return cookbookRepository.update(recipe);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        return e;
    }
}
