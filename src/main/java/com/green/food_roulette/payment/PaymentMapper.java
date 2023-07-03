package com.green.food_roulette.payment;

import com.green.food_roulette.payment.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    int insUserPayment(PaymentEntity entity);
    List<PaymentMonthListVo>getUserPaymentList(PaymentMonthListDto dto);
    List<PaymentDetailVo>getUserDetailPayment(PaymentDetailDto dto);
    int reviewPayment(PaymentReviewDto dto);
   PaymentGetMonthVo getThisMonthPaymet(PaymentCalDto calDto);
}
