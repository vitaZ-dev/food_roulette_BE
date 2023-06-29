package com.green.food_roulette.payment;

import com.green.food_roulette.payment.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Tag(name = "유저 소비내역")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @PostMapping("/main/{iuser}")
    @Operation(summary = "당첨 메뉴 등록",description = "imenu=메뉴의 id값" +
            " imanagement=이달의 목표 id값")
    public int setUserPayment(@RequestBody PyamentInsDto dto){
       return service.insUserPayment(dto);
    };

    @GetMapping("/calendar/{iuser}")
    @Operation(summary = "해당 달의 소비 내역들",description = "iuser=유저id" +
            "year = yy" +
            "month= mm")
    public List<PaymentMonthListVo> getUserPaymentList(@PathVariable Long iuser,String year,int month){
        PaymentMonthListDto dto = new PaymentMonthListDto();
        dto.setIuser(iuser);
        dto.setYear(year);
        dto.setMonth(month);
        return service.getUserPaymentList(dto);
    }

    @GetMapping("/calendar/{iuser}/detail")
    @Operation(summary = "해당 일의 소비 내역들 ",description = "paymentAt ex)yy-mm-dd 날자정보" +
            "iuser= 유저 id")
    public List<PaymentDetailVo>getUserDetailPayment(@PathVariable Long iuser,String  paymentAt){
        PaymentDetailDto dto = new PaymentDetailDto();
        dto.setIuser(iuser);
        dto.setPaymentAt(paymentAt);
        return service.getUserDetailPayment(dto);

    }
}
