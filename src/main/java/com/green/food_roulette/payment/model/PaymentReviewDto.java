package com.green.food_roulette.payment.model;

import lombok.Data;

@Data
public class PaymentReviewDto {
    private Long iuser;
    private int currentMenuPrice;
    private int reviewGrade;
    private String restaurant;
}
