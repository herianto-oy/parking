package com.enigma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.dto.TransactionDto;
import com.enigma.entity.TransactionEntity;
import com.enigma.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/check-in")
	public ResponseEntity<TransactionEntity> checkIn(@RequestBody TransactionDto trx) {
		TransactionEntity response = transactionService.checkIn(trx);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PutMapping("/check-out")
	public ResponseEntity<TransactionEntity> checkOut(@RequestParam("id") Long id) {
		TransactionEntity response = transactionService.checkOut(id);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<Page<TransactionEntity>> findAllTransaction(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
		Page<TransactionEntity> response = transactionService.findByAll(page, size);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/transaction")
	public ResponseEntity<TransactionEntity> findByTransactionId(@RequestParam("id") Long id) {
		TransactionEntity response = transactionService.findById(id);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}
