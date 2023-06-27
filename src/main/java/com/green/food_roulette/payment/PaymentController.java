package com.green.food_roulette.payment;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@Tag(name = "유저 소비내역")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;
}
