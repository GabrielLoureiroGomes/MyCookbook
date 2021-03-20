package com.loureiro.cookbook.repository;

import com.loureiro.cookbook.entity.Cookbook;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CookbookRepository {

    List<Cookbook> findAll();

    Cookbook findById(ObjectId id);

    Cookbook create(Cookbook recipe);

    Cookbook update(Cookbook recipe);

    void delete(ObjectId id);
}
