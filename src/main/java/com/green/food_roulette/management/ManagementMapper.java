package com.green.food_roulette.management;

import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import com.green.food_roulette.management.model.ManagemetSetMonthDto;
import com.green.food_roulette.payment.model.PaymentMonthListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagementMapper {
    int setUserThisMonthManagement(ManagemetSetMonthDto dto);
    ManagementMonthVo getUserThisMonthManagement(ManagementMonthDto dto);
    List<ManagementMonthVo>getUserManagementList(ManagementMonthDto dto);
    int updUserMonthManagement(ManagemetSetMonthDto dto);
}
