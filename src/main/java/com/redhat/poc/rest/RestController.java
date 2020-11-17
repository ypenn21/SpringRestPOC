package com.redhat.poc.rest;

import com.redhat.poc.model.Hat;
import com.redhat.poc.service.HatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private HatService hatService;

	@GetMapping("/test")
	public String test() {
		return "succes";
	}

	@GetMapping("/hats/{hatId}")
	public Hat getHat(@PathVariable("hatId") Integer hatId){
		return hatService.getHat(hatId);
	}

	@PostMapping("/hats")
	public ResponseEntity<Hat> createHat(@RequestBody Hat hat){
		return new ResponseEntity<>( hatService.createHat(hat), HttpStatus.CREATED );
	}
    
    @PutMapping("/hats/{hatId}")
	public Hat updateHat(@RequestBody Hat hat, @PathVariable("hatId") Integer  hatId) {
		hat.setId(hatId);
		return hat;
	}

	@DeleteMapping("/hats/{hatId}")
	public ResponseEntity<?> deleteHat(@PathVariable("hatId") Integer  hatId) {
		return new ResponseEntity<Void>( HttpStatus.NO_CONTENT );
	}

	@GetMapping("/hats")
	public Iterable<Hat> getAllHats(){
		return hatService.getHats();
	}

}