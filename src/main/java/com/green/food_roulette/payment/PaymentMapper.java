package com.green.food_roulette.payment;

import com.green.food_roulette.payment.model.PaymentDetailDto;
import com.green.food_roulette.payment.model.PaymentDetailVo;
import com.green.food_roulette.payment.model.PaymentMonthListDto;
import com.green.food_roulette.payment.model.PaymentMonthListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    List<PaymentMonthListVo>getUserPaymentList(PaymentMonthListDto dto);
    List<PaymentDetailVo>getUserDetailPayment(PaymentDetailDto dto);
}
