package com.green.food_roulette.management;

import com.green.food_roulette.management.model.*;
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

    public ManagementMonthVo setUserThisMonthManagement(ManagementEntity entity){
        ManagementMonthVo result;
       try {
           result = mapper.getUserThisMonthManagement(entity);




       }catch (Exception e){
           mapper.setUserThisMonthManagement(entity);
           result=mapper.getUserThisMonthManagement(entity);
       }
        return result;


    }

    public ManagementMonthVo getUserThisMonthManagement(ManagementEntity entity)throws Exception{
       try {
           return mapper.getUserThisMonthManagement(entity);
       }catch (Exception e){
           throw new Exception();
       }
    }

    public List<ManagementMonthVo> getUserManagementList(ManagementMonthDto dto){
        return mapper.getUserManagementList(dto);
    }

    @Transactional(rollbackFor = Exception.class)
    public ManagementMonthVo updUserMonthManagement(ManagementEntity entity)throws Exception{
        int result = mapper.updUserMonthManagement(entity);
        if (result==0){
            throw new Exception();
        }

        return mapper.getUserThisMonthManagement(entity) ;
    }

  @Scheduled(cron = "0 48 16 30 6 ?")
    public void calculateUserManagement(){
        List<ManagementCalculateVo> calculateVos = mapper.monthTotalPayment();
        mapper.monthCalculate(calculateVos);
    }
}
