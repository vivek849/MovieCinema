package com.infi.moviecinema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infi.moviecinema.dto.PaymentDTO;
import com.infi.moviecinema.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // US09: Process payment
    @PostMapping
    public ResponseEntity<PaymentDTO> processPayment(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.ok(paymentService.processPayment(paymentDTO));
    }
}

