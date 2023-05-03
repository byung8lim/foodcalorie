package com.byung8.fitness.foodcalorie.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.byung8.common.domain.IResult;
import com.byung8.common.domain.Result;
import com.byung8.common.exception.Byung8Exception;
import com.byung8.fitness.domain.FoodCalorieBase;
import com.byung8.fitness.foodcalorie.service.FoodCalorieService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/calorie")
public class FoodCalorieController {

	@Autowired
	FoodCalorieService dietService;
	
	private String txId() {
		return UUID.randomUUID().toString();
	}

	@RequestMapping(value = "/food/{foodId}", method = RequestMethod.GET)
	public ResponseEntity<String> getFoodCalorie(@PathVariable("foodId") final String foodId) {

		String txid = txId();
		if (log.isInfoEnabled()) {
			log.info(txid+",Begin to getFoodCalorie,foodId="+foodId);
		}
		try {
			
			Result result = dietService.getFoodCaloire(foodId, txid);
			
			log.warn(txid+",OK to getFoodCalorie,foodId="+foodId+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error(txid+",Failed to getFoodCalorie,foodId="+foodId+",Exception", e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/{foodTypeCd}/type", method = RequestMethod.GET)
	public ResponseEntity<String> getFoodCalorieListByType(@PathVariable("foodTypeCd") final String foodTypeCd) {

		String txid = txId();
		if (log.isInfoEnabled()) {
			log.info(txid+",Begin to getFoodCalorieListByType,foodTypeCd="+foodTypeCd);
		}
		try {
			Result result = dietService.getByType(foodTypeCd, txid);
			
			log.warn(txid+",OK to getFoodCalorieListByType,foodTypeCd="+foodTypeCd+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.warn(txid+",Failed to getFoodCalorieListByType,foodTypeCd="+foodTypeCd+",Exception",e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/{foodName}/name", method = RequestMethod.GET)
	public ResponseEntity<String> getFoodCalorieListByName(@PathVariable("foodName") final String foodName) {

		String txid = txId();
		if (log.isInfoEnabled()) {
			log.info(txid+",Begin to getFoodCalorieListByName,foodName="+foodName);
		}
		try {
			Result result = dietService.getByName(foodName, txid);
			
			log.info(txid+",OK to getFoodCalorieListByName,foodName="+foodName+",result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error(txid+",Failed to getFoodCalorieListByName,foodName="+foodName+",Exception",e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<String> getFoodCalorieAllList() {

		String txid = txId();
		if (log.isInfoEnabled()) {
			log.info(txid+",Begin to getFoodCalorieAllList");
		}
		try {
			Result result = dietService.getAll(txid);
			
			log.info(txid+",OK to getFoodCalorieAllList,result={"+result+"}");
			return new ResponseEntity<String>(result.toJson(), result.status());
		} catch (Exception e) {
			log.error(txid+",OK to getFoodCalorieAllList,Exception",e);
			if (e instanceof NullPointerException) {
				return new ResponseEntity<String>(HttpStatus.EXPECTATION_FAILED);
			} else if (e instanceof Byung8Exception) {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e.getMessage());
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			} else {
				Result result = new Result(txid, IResult.ERROR, "").putValue("error", e);
				return new ResponseEntity<String>(result.toJson(), HttpStatus.EXPECTATION_FAILED);
			}
		}
	}
}
