package com.test.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.models.Log;
import com.test.repository.LogRepository;

@RestController
@RequestMapping("/rest/users")
public class LogResource {
	@Autowired
	LogRepository logrepository;
	
	@GetMapping("/all")
	public List<Log> getAll(){
		System.out.println("here");
		return logrepository.findAll();
	}
	
	@PostMapping("/post")
	ResponseEntity<Log> postLog(@RequestBody Log log) throws URISyntaxException{
		System.out.println("here");
		System.out.println(log);
		Log result = logrepository.save(log);
		return ResponseEntity.created(new URI("/rest/users" + result.getUserId())).body(result);
	}
}
