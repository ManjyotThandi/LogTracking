package com.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.models.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
	List<Log> findByuserId(Optional<String> user);
	List<Log> findByidIn(List<Integer> logIdList);
}
