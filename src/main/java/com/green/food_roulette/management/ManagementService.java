package com.green.food_roulette.management;

import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import com.green.food_roulette.management.model.ManagemetSetMonthDto;
import com.green.food_roulette.payment.model.PaymentMonthListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagementService {
    private final ManagementMapper mapper;

    public ManagementMonthVo setUserThisMonthManagement(ManagemetSetMonthDto dto){
        ManagementMonthDto mmd = new ManagementMonthDto();
        mmd.setIuser(dto.getIuser());
        ManagementMonthVo result = mapper.getUserThisMonthManagement(mmd);
        if (result==null){
            mapper.setUserThisMonthManagement(dto);
            result=mapper.getUserThisMonthManagement(mmd);
        }
        return result;

    }

    public ManagementMonthVo getUserThisMonthManagement(ManagementMonthDto dto){
        return mapper.getUserThisMonthManagement(dto);
    }

    public List<ManagementMonthVo> getUserManagementList(ManagementMonthDto dto){
        return mapper.getUserManagementList(dto);
    }
}
