package com.byung8.fitness.foodcalorie.service;

import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.fitness.domain.FoodCalorieBase;

public interface FoodCalorieService {
	Result getFoodCaloire(String foodId, String txid) throws Byung8Exception;
	Result getByType(String type, String txid) throws Byung8Exception;
	Result getByName(String name, String txid) throws Byung8Exception;
	Result getAll(String txid) throws Byung8Exception;
}
