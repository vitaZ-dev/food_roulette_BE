package com.green.food_roulette.management;

import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagementMapper {
    ManagementMonthVo getUserThisMonthManagement(ManagementMonthDto dto);
}
