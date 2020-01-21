package com.enigma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enigma.entity.ParkingDockEntity;
import com.enigma.service.ParkingDockService;

@RestController
public class ParkingDockController {
	@Autowired
	private ParkingDockService dockService;

	@PostMapping("/dock")
	public ResponseEntity<ParkingDockEntity> createDock(@RequestBody ParkingDockEntity dock) {
		ParkingDockEntity response = dockService.createDock(dock);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("/dock")
	public ResponseEntity<ParkingDockEntity> updateDock(@RequestBody ParkingDockEntity dock) {
		ParkingDockEntity response = dockService.updateDock(dock);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/docks")
	public ResponseEntity<Page<ParkingDockEntity>> findAllDock(@RequestParam("page") Integer page,
			@RequestParam("size") Integer size) {
		Page<ParkingDockEntity> response = dockService.findAllDock(page, size);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@DeleteMapping("/dock")
	public ResponseEntity<ParkingDockEntity> deletedock(@RequestParam("id") Long id) {
		ParkingDockEntity response = dockService.deleteDock(id);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}
