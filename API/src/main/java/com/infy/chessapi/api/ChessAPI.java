package com.infy.chessapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.infy.chessapi.service.ChessService;


@CrossOrigin
@RestController
@RequestMapping("ChessAPI")
public class ChessAPI {
	
	@Autowired
	private ChessService chessService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "populateTestData")
	public ResponseEntity<Boolean> populateTestData() throws Exception {
		try{
			Boolean result = chessService.populateTestData();
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);			
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}

}