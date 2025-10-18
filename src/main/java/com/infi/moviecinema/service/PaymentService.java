package com.infi.moviecinema.service;

import com.infi.moviecinema.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO processPayment(PaymentDTO dto);
}

