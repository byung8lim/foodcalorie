package com.byung8.fitness.foodcalorie.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.byung8.fitness.domain.FoodCalorieBase;
@Mapper
public interface FoodCalorieBaseMapper {
	FoodCalorieBase findFoodCalorie(String id) throws SQLException;
	List<FoodCalorieBase> findByType(String type) throws SQLException;
	List<FoodCalorieBase> findByName(String name) throws SQLException;
	List<FoodCalorieBase> findAll() throws SQLException;
}
