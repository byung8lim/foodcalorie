package com.byung8.fitness.foodcalorie.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.fitness.domain.FoodCalorieBase;
import com.byung8.fitness.foodcalorie.mapper.FoodCalorieBaseMapper;

import lombok.extern.slf4j.Slf4j;

@Service("foodCalorieService")
@Slf4j
public class FoodCalorieServiceImpl implements FoodCalorieService {

	@Autowired
	FoodCalorieBaseMapper foodCalorieBaseMapper;

	@Override
	public Result getByType(String type, String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getByType,type="+type);
		}
		try {
			List<FoodCalorieBase> list = foodCalorieBaseMapper.findByType(type);
			result = new Result(txid, Result.OK).putValue("foodCalories", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to getByType,type="+type+",result={"+result+"}");
			}
		} catch(SQLException e) {
			log.error(txid+",Failed to getByType,type="+type+",Exception", e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result getByName(String name, String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getByName,name="+name);
		}
		try {
			List<FoodCalorieBase> list = foodCalorieBaseMapper.findByName(name);
			result = new Result(txid, Result.OK).putValue("foodCalories", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to getByName,name="+name+",result={"+result+"}");
			}
		} catch(SQLException e) {
			log.error(txid+",Failed to getByName,name="+name+",Exception",e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result getFoodCaloire(String foodId, String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getFoodCaloire,foodId="+foodId);
		}
		try {
			FoodCalorieBase foodCalorie = foodCalorieBaseMapper.findFoodCalorie(foodId);
			result = new Result(txid, Result.OK).putValue("foodCalorie", foodCalorie);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to getFoodCaloire,foodId="+foodId+",result={"+result+"}");
			}
		} catch(SQLException e) {
			log.info(txid+",Failed to getFoodCaloire,foodId="+foodId+",Exception",e);
			throw new Byung8Exception(e);
		}
		return result;
	}

	@Override
	public Result getAll(String txid) throws Byung8Exception {
		Result result = null;
		if (log.isDebugEnabled()) {
			log.debug(txid+",Begin to getAll");
		}
		try {
			List<FoodCalorieBase> list = foodCalorieBaseMapper.findAll();
			result = new Result(txid, Result.OK).putValue("findFoodCalorieAllList", list);
			if (log.isInfoEnabled()) {
				log.info(txid+",OK to getAll,result={"+result+"}");
			}
		} catch(SQLException e) {
			log.error(txid+",Failed to getAll,Exception",e);
			throw new Byung8Exception(e);
		}
		return result;
	}


}
