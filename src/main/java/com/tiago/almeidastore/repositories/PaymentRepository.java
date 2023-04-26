package com.tiago.almeidastore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.almeidastore.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
