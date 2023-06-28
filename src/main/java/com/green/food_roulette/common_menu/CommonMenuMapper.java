package com.green.food_roulette.common_menu;

import com.green.food_roulette.common_menu.model.CommonMenuEntity;
import com.green.food_roulette.common_menu.model.CommonMenuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommonMenuMapper {
    List<CommonMenuVo> getCommonMenu();
}
