package com.green.food_roulette.common_menu;

import com.green.food_roulette.common_menu.model.CommonMenuEntity;
import com.green.food_roulette.common_menu.model.CommonMenuVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonMenuService {
    private final CommonMenuMapper mapper;

    public List<CommonMenuVo> getCommonMenu(){
        return mapper.getCommonMenu();
    }
}
