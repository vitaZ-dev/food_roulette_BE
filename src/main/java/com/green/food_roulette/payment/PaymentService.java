package com.green.food_roulette.payment;

import com.green.food_roulette.management.ManagementMapper;
import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import com.green.food_roulette.payment.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper mapper;
    private final ManagementMapper managementMapper;


    public int insUserPayment(PyamentInsDto dto){
        PaymentEntity entity = new PaymentEntity();
        entity.setImenu(dto.getImenu());
        entity.setImanagement(dto.getImanagement());
        return mapper.insUserPayment(entity);
    }

    public List<PaymentMonthListVo> getUserPaymentList(PaymentMonthListDto dto){
       return mapper.getUserPaymentList(dto);
    }

    public List<PaymentDetailVo>getUserDetailPayment(PaymentDetailDto dto){
        return mapper.getUserDetailPayment(dto);
    }

    @Transactional(rollbackFor = Exception.class)
    public int reviewPayment(PaymentReviewDto dto)throws Exception{
        PaymentGetMonthVo thisMonthPaymet = mapper.getThisMonthPaymet(dto);
        int monthLimit = thisMonthPaymet.getMonthLimit();
        int sum = thisMonthPaymet.getSum();

        if (monthLimit<sum+dto.getCurrentMenuPrice()){
            throw new Exception();
        }
       return mapper.reviewPayment(dto);

    }
}
