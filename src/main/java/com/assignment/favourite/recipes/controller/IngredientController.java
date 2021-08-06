package com.assignment.favourite.recipes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.favourite.recipes.entity.Ingredients;
import com.assignment.favourite.recipes.exception.IngredientFoundException;
import com.assignment.favourite.recipes.exception.IngredientNotFoundException;
import com.assignment.favourite.recipes.service.IngredientService;


@RestController
public class IngredientController {
	
	private static final Logger logger = LoggerFactory.getLogger(IngredientController.class);

	@Autowired
	private IngredientService ingredientService;
	
	
	@RequestMapping(value = "/level1/fetchIngredients", method = RequestMethod.GET)
	public List<Ingredients> fetchIngredients() {
		logger.info(" In fetchIngredients() of  IngredientController ");
		List<Ingredients> ingredientList = ingredientService.fetchIngredients();
		return ingredientList;
	}

	@RequestMapping(value = "/level2/addIngredient", method = RequestMethod.POST)
	public Ingredients addIngredient(@RequestBody Ingredients ingredient)  throws IngredientFoundException {
		logger.info(" In addIngredient() of  IngredientController ");
		return ingredientService.saveIngredient(ingredient);
	}
	
	@RequestMapping(value = "/level2/deleteIngredient/{id}", method = RequestMethod.DELETE)
	public String deleteIngredient(@PathVariable("id") Long ingredientId) throws IngredientNotFoundException{
		logger.info(" In deleteIngredient() of  IngredientController ");
		 ingredientService.deleteIngredient(ingredientId);
		 return "Ingredient is deleted successfully";
	}
	
}
