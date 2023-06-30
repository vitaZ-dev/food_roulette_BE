package com.green.food_roulette.management;

import com.green.food_roulette.management.model.ManagementCalculateVo;
import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import com.green.food_roulette.management.model.ManagemetSetMonthDto;
import com.green.food_roulette.payment.model.PaymentMonthListDto;
import lombok.RequiredArgsConstructor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(rollbackFor = Exception.class)
    public ManagementMonthVo updUserMonthManagement(ManagemetSetMonthDto dto)throws Exception{
        int result = mapper.updUserMonthManagement(dto);
        if (result==0){
            throw new Exception();
        }
        ManagementMonthDto monthDto = new ManagementMonthDto();
        monthDto.setIuser(dto.getIuser());
        return mapper.getUserThisMonthManagement(monthDto) ;
    }

  @Scheduled(cron = "0 48 16 30 6 ?")
    public void calculateUserManagement(){
        List<ManagementCalculateVo> calculateVos = mapper.monthTotalPayment();
        mapper.monthCalculate(calculateVos);
    }
}
