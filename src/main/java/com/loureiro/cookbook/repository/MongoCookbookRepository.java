package com.loureiro.cookbook.repository;

import com.loureiro.cookbook.entity.Cookbook;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

@Repository
public class MongoCookbookRepository implements CookbookRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readPreference(ReadPreference.primary())
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();
    private final MongoClient client;
    private MongoCollection<Cookbook> cookbookCollection;

    public MongoCookbookRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        cookbookCollection = client.getDatabase("Cookbook").getCollection("cookbook", Cookbook.class);
    }

    @Override
    public List<Cookbook> findAll() {
        return cookbookCollection.find().into(new ArrayList<>());
    }

    @Override
    public Cookbook findById(ObjectId id) {
        return cookbookCollection.find(eq("_id", new ObjectId(String.valueOf(id)))).first();
    }

    @Override
    public Cookbook create(Cookbook recipe) {
        recipe.setId(new ObjectId());
        cookbookCollection.insertOne(recipe);
        return recipe;
    }

    @Override
    public Cookbook update(Cookbook recipe) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return cookbookCollection.findOneAndReplace(eq("_id", recipe.getId()), recipe, options);
    }

    @Override
    public void delete(ObjectId id) {
        cookbookCollection.deleteOne(eq("_id", new ObjectId(String.valueOf((id)))));
    }
}
