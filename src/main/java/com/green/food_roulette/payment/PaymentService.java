package com.green.food_roulette.payment;

import com.green.food_roulette.payment.model.PaymentDetailDto;
import com.green.food_roulette.payment.model.PaymentDetailVo;
import com.green.food_roulette.payment.model.PaymentMonthListDto;
import com.green.food_roulette.payment.model.PaymentMonthListVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper mapper;

    public List<PaymentMonthListVo> getUserPaymentList(PaymentMonthListDto dto){
       return mapper.getUserPaymentList(dto);
    }

    public List<PaymentDetailVo>getUserDetailPayment(PaymentDetailDto dto){
        return mapper.getUserDetailPayment(dto);
    }
}
