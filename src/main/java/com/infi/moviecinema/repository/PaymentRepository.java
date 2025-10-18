package com.infi.moviecinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infi.moviecinema.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
