package com.tiago.almeidastore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.almeidastore.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
