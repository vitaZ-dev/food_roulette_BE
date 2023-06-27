package com.green.food_roulette.management;

import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagementService {
    private final ManagementMapper mapper;

    public ManagementMonthVo getUserThisMonthManagement(ManagementMonthDto dto){
        return mapper.getUserThisMonthManagement(dto);
    }

    public List<ManagementMonthVo> getUserManagementList(ManagementMonthDto dto){
        return mapper.getUserManagementList(dto);
    }
}
