package com.test.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.test.models.Log;
import com.test.models.action;
import com.test.repository.ActionRepository;
import com.test.repository.LogRepository;

@RestController
@RequestMapping("/rest/users")
public class LogResource {
	@Autowired
	LogRepository logrepository;
	@Autowired
	ActionRepository actionRepository;

	@GetMapping("/all")
	public List<Log> getAll() {
		System.out.println("here");
		// return logrepository.findAll();
		return logrepository.findAll();
	}

	List<Integer> logIds = new ArrayList<Integer>();

	@GetMapping("/one")
	public List<Log> getAll(@RequestParam("user") Optional<String> user,
			@RequestParam("logType") Optional<String> type) {
		System.out.println(type);
		if (type.equals(Optional.empty())) {
			return logrepository.findByuserId(user);
		} else {
			List<action> result = actionRepository.findBytype(type);
			for (action i : result) {
				System.out.println("This is in the loop" + i.getId());
				logIds.add(i.getId());
			}
			return logrepository.findByidIn(logIds);
		}
	}

	@PostMapping("/post")
	ResponseEntity<Log> postLog(@RequestBody Log log) throws URISyntaxException {
		System.out.println("here");
		System.out.println(log);
		Log result = logrepository.save(log);
		return ResponseEntity.created(new URI("/rest/users" + result.getUserId())).body(result);
	}
}
