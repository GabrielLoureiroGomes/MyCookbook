package com.loureiro.cookbook;

import com.loureiro.cookbook.controller.CookbookController;
import com.loureiro.cookbook.entity.Cookbook;
import com.loureiro.cookbook.repository.CookbookRepository;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class MyCookbookApplicationTests {

    @InjectMocks
    private CookbookController cookbookController;

    @Mock
    private CookbookRepository cookbookRepository;

    @Autowired
    private Mocks mock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("FIND ALL RECIPES")
    public void testGetAllRecipes() {
        when(cookbookRepository.findAll()).thenReturn(mock.getListRecipes());
        List<Cookbook> cook = cookbookController.getAllRecipes();
        verify(cookbookRepository).findAll();
        assertEquals(2, cook.size());
    }

    @Test
    @DisplayName("FIND RECIPE BY ID")
    public void testGetRecipeById() {
        ObjectId id = new ObjectId("6056717095bb770081341eba");
        when(cookbookRepository.findById(any())).thenReturn(mock.getRisotoDeCamaraoRecipe());
        Cookbook cook = cookbookController.getRecipe(id);
        verify(cookbookRepository).findById(any());
        assertEquals(new ObjectId("6056717095bb770081341eba"), cook.getId());
    }

    @Test
    @DisplayName("CREATE RECIPE")
    public void testCreateRecipe() {
        when(cookbookRepository.create(any())).thenReturn(mock.getMacarraoBolonhesaRecipe());
        Cookbook cook = cookbookController.createRecipe(mock.getMacarraoBolonhesaRecipe());
        verify(cookbookRepository).create(any());
        assertEquals(new ObjectId("60566ef00f176b6e48d404dd"), cook.getId());
    }

    @Test
    @DisplayName("UPDATE RECIPE")
    public void testUpdateRecipe() {
        when(cookbookRepository.update(any())).thenReturn(mock.getMacarraoBolonhesaRecipe());
        Cookbook cook = cookbookController.updateRecipe(mock.getMacarraoBolonhesaRecipe());
        verify(cookbookRepository).update(any());
        assertEquals(new ObjectId("60566ef00f176b6e48d404dd"), cook.getId());
    }

    @Test
    @DisplayName("DELETE RECIPE")
    public void testDeleteRecipe() {
        ObjectId id = new ObjectId("6056717095bb770081341eba");
        doNothing().when(cookbookRepository).delete(any());
        cookbookController.deleteRecipe(id);
        verify(cookbookRepository).delete(any());
    }
}
