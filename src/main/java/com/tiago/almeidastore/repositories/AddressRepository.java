package com.tiago.almeidastore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.almeidastore.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
