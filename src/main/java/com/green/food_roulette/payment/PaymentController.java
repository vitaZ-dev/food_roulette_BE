package com.green.food_roulette.payment;

import com.green.food_roulette.payment.model.PaymentDetailDto;
import com.green.food_roulette.payment.model.PaymentDetailVo;
import com.green.food_roulette.payment.model.PaymentMonthListDto;
import com.green.food_roulette.payment.model.PaymentMonthListVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/{iuser}")
@Tag(name = "유저 소비내역")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @GetMapping("/calendar")
    @Operation(summary = "해당 달의 소비 내역들")
    public List<PaymentMonthListVo> getUserPaymentList(@PathVariable Long iuser,String year,int month){
        PaymentMonthListDto dto = new PaymentMonthListDto();
        dto.setIuser(iuser);
        dto.setYear(year);
        dto.setMonth(month);
        return service.getUserPaymentList(dto);
    }

    @GetMapping("/calender/detail")
    @Operation(summary = "해당 일의 소비 내역들")
    public List<PaymentDetailVo>getUserDetailPayment(@PathVariable Long iuser,String  paymentAt){
        PaymentDetailDto dto = new PaymentDetailDto();
        dto.setIuser(iuser);
        dto.setPaymentAt(paymentAt);
        return service.getUserDetailPayment(dto);

    }
}
