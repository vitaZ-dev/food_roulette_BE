package com.green.food_roulette.management;

import com.green.food_roulette.management.model.*;
import com.green.food_roulette.payment.model.PaymentMonthListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagementMapper {
    int setUserThisMonthManagement(ManagementEntity entity);
    ManagementMonthVo getUserThisMonthManagement(ManagementEntity entity);
    List<ManagementMonthVo>getUserManagementList(ManagementMonthDto dto);
    List<ManagementCalculateVo>monthTotalPayment();
    int updUserMonthManagement(ManagementEntity entity);
    int monthCalculate(List<ManagementCalculateVo>list);

}
