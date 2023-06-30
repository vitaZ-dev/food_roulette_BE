package com.green.food_roulette.management;

import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import com.green.food_roulette.management.model.ManagemetSetMonthDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@Tag(name = "월별 목표")
@RequiredArgsConstructor
public class ManagementController {
    private final ManagementService service;

    @PostMapping("/main/{iuser}/plan")
    @Operation(summary = "이달의 목표 설정하기",description = "iuser=유저 pk" +
            "   monthLimit= 원하는 한도"  )
    public ManagementMonthVo setUserMonthManagement(@RequestBody ManagemetSetMonthDto dto){
       return service.setUserThisMonthManagement(dto);
    }

    @GetMapping("/main/{iuser}")
    @Operation(summary = "이달의 목표 불러오기",description = "iuser=url의 iuser값을 읽어 실행")
    public ManagementMonthVo getUserThisMonthManagement(@PathVariable Long iuser){
        ManagementMonthDto dto = new ManagementMonthDto();
        dto.setIuser(iuser);
        ManagementMonthVo result = service.getUserThisMonthManagement(dto);
        return result;
    }

    @GetMapping("/calculate/{iuser}")
    @Operation(summary = "목표 모두 불러오기",description = "iuser=유저 id")
    public List<ManagementMonthVo> getUserManagementList(@PathVariable Long iuser){
        ManagementMonthDto dto = new ManagementMonthDto();
        dto.setIuser(iuser);
        return service.getUserManagementList(dto);
    }

    @PatchMapping("/main/{iuser}")
    @Operation(summary = "이달의 한도 수정",description = "")
    public ManagementMonthVo patchUserMonthManagement(@RequestBody ManagemetSetMonthDto dto)throws Exception{
        return service.updUserMonthManagement(dto);
    }



}
