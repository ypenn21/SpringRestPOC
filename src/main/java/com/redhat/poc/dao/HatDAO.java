package com.redhat.poc.dao;

import com.redhat.poc.model.Hat;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// put logic get connection and query db in here
@Repository
public interface HatDAO extends CrudRepository<Hat, Integer> {
}
