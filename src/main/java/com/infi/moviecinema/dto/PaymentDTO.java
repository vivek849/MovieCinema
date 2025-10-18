package com.infi.moviecinema.dto;


import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class PaymentDTO {

    private Long id;

    @NotNull(message = "{payment.bookingId.required}")
    private Long bookingId;

    @Pattern(regexp = "CREDIT|DEBIT", message = "{payment.cardType.pattern}")
    private String cardType;

    @Pattern(regexp = "\\d{16}", message = "{payment.cardNumber.pattern}")
    private String cardNumber;

    @Pattern(regexp = "(0[1-9]|1[0-2])/\\d{2}", message = "{payment.expiry.pattern}")
    private String expiry;

    @Pattern(regexp = "\\d{3}", message = "{payment.cvv.pattern}")
    private String cvv;

    @DecimalMin(value = "1.0", message = "{payment.amount.min}")
    private Double amount;

    private Double discountApplied;
    private Double finalAmount;

    @Pattern(regexp = "SUCCESS|FAILED", message = "{payment.status.pattern}")
    private String status;

    private LocalDateTime paymentDate;
}
