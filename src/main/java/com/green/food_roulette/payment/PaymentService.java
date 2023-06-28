package com.green.food_roulette.payment;

import com.green.food_roulette.management.ManagementMapper;
import com.green.food_roulette.payment.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper mapper;
    private final ManagementMapper managementMapper;



    public List<PaymentMonthListVo> getUserPaymentList(PaymentMonthListDto dto){
       return mapper.getUserPaymentList(dto);
    }

    public List<PaymentDetailVo>getUserDetailPayment(PaymentDetailDto dto){
        return mapper.getUserDetailPayment(dto);
    }
}
