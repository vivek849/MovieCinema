package com.infi.moviecinema.serviceIml;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infi.moviecinema.dto.PaymentDTO;
import com.infi.moviecinema.entity.Payment;
import com.infi.moviecinema.repository.PaymentRepository;
import com.infi.moviecinema.service.PaymentService;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepo;
    private final ModelMapper mapper;

    @Autowired 
    public PaymentServiceImpl(PaymentRepository paymentRepo, ModelMapper mapper) {
        this.paymentRepo = paymentRepo;
        this.mapper = mapper;
    }

    @Override
    public PaymentDTO processPayment(PaymentDTO dto) {

        double discount = dto.getCardType().equalsIgnoreCase("CREDIT") ? 0.10 : 0.05;
        double finalAmount = dto.getAmount() * (1 - discount);

        Payment payment = mapper.map(dto, Payment.class);
        payment.setDiscountApplied(discount * 100);
        payment.setFinalAmount(finalAmount);
        payment.setStatus("SUCCESS");
        payment.setPaymentDate(LocalDateTime.now());

        Payment saved = paymentRepo.save(payment);
        return mapper.map(saved, PaymentDTO.class);
    }
}
