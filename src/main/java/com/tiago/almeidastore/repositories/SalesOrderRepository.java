package com.tiago.almeidastore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.almeidastore.entity.SalesOrder;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Integer> {

}
