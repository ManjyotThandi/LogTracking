package com.test.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.models.Log;
import com.test.models.action;

public interface ActionRepository extends JpaRepository<action, Integer> {
	List<action> findBytype(Optional<String> type);
	List<action> findBytimeBetween(Optional<Date> from, Optional<Date> to);
}
