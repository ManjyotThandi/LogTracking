package com.test.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

	//List<Integer> logIds = new ArrayList<Integer>();

	@GetMapping("/one")
	public List<Log> getAll(@RequestParam("user") Optional<String> user, @RequestParam("logType") Optional<String> type,
			@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  Optional<Date> from, @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<Date> to) {
		
		System.out.println(type);
		// if only user is provided
		if (type.equals(Optional.empty()) && from.equals(Optional.empty()) && to.equals(Optional.empty())) {
			List<Integer> logIds = new ArrayList<Integer>();
			System.out.println("In first");
			return logrepository.findByuserId(user);
		} 
		// if only type is provided
		else if (user.equals(Optional.empty()) && from.equals(Optional.empty()) && to.equals(Optional.empty())) {
			List<Integer> logIds = new ArrayList<Integer>();
			System.out.println("In 2");
			List<action> result = actionRepository.findBytype(type);
			for (action i : result) {
				System.out.println("This is in the loop" + i.getId());
				logIds.add(i.getId());
			}
			return logrepository.findByidIn(logIds);
		}
		// if only date is provided
		else if(user.equals(Optional.empty()) && type.equals(Optional.empty())) {
			List<Integer> logIds = new ArrayList<Integer>();
			System.out.println("In 3");
		List<action> result = actionRepository.findBytimeBetween(from, to);
		System.out.println("The result of date" + result);
		for (action i : result) {
		System.out.println("This is in the loop" + i.getId());
			logIds.add(i.getId());
		}
		return logrepository.findByidIn(logIds);
		}
		// if user and date are provided
		else if(type.equals(Optional.empty())) {
			List<Integer> logIds = new ArrayList<Integer>();
			System.out.println("In 4");
			// query for the user first
			List<Log> byUser = logrepository.findByuserId(user);
			// query for the date
			List<action> result = actionRepository.findBytimeBetween(from, to);
			System.out.println("The result of date" + result);
			for (action i : result) {
			System.out.println("This is in the loop" + i.getId());
				logIds.add(i.getId());
			}
			List<Log> byDate =  logrepository.findByidIn(logIds);
			// compare the two and return Logs that match
			byUser.retainAll(byDate);
			return byUser;
		}
		// if user and type are provided
		else if (from.equals(Optional.empty()) && to.equals(Optional.empty())) {
			List<Integer> logIds = new ArrayList<Integer>();
			System.out.println("In 5");
			// query for user
			List<Log> byUser = logrepository.findByuserId(user);
			// query for type
			List<action> result = actionRepository.findBytype(type);
			for (action i : result) {
				System.out.println("This is in the loop" + i.getId());
				logIds.add(i.getId());
			}
			List<Log> byType =  logrepository.findByidIn(logIds);
			//compare the two and return Logs that match
			 byUser.retainAll(byType);
			return byUser;
		}
		// if type and date are provided
		else if(user.equals(Optional.empty())) {
			List<Integer> logIds = new ArrayList<Integer>();
			List<Integer> logIds1 = new ArrayList<Integer>();
			System.out.println("In 6");
			// query for type
			List<action> result1 = actionRepository.findBytype(type);
			for (action i : result1) {
				System.out.println("This is in the loop" + i.getId());
				logIds.add(i.getId());
			}
			List<Log> byType =  logrepository.findByidIn(logIds);
			// query for date
			List<action> result = actionRepository.findBytimeBetween(from, to);
			System.out.println("The result of date" + result);
			for (action i : result) {
			System.out.println("This is in the loop" + i.getId());
				logIds1.add(i.getId());
			}
			List<Log> byDate =  logrepository.findByidIn(logIds1);
			// compare the two and return Logs that match
			byType.retainAll(byDate);
			return byType;
		}
		else {
			List<Integer> logIds = new ArrayList<Integer>();
			List<Integer> logIds1 = new ArrayList<Integer>();
			System.out.println("in 7");
			//query for the user
			List<Log> byUser = logrepository.findByuserId(user);
			// query for date
			List<action> result = actionRepository.findBytimeBetween(from, to);
			System.out.println("The result of date" + result);
			for (action i : result) {
			System.out.println("This is in the loop" + i.getId());
				logIds.add(i.getId());
			}
			List<Log> byDate =  logrepository.findByidIn(logIds);
			// query for type
			List<action> result1 = actionRepository.findBytype(type);
			for (action i : result1) {
				System.out.println("This is in the loop" + i.getId());
				logIds1.add(i.getId());
			}
			List<Log> byType =  logrepository.findByidIn(logIds1);
			// compare the two and return Logs that match
			byUser.retainAll(byDate);
			byUser.retainAll(byType);
			return byUser;
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
