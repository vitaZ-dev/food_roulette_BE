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

@RequestMapping("/{iuser}")
@RestController
@Tag(name = "월별 목표")
@RequiredArgsConstructor
public class ManagementController {
    private final ManagementService service;

    @PostMapping("/roulette")
    @Operation(summary = "이달의 목표 설정하기")
    public ManagementMonthVo setUserMonthManagement(@RequestBody ManagemetSetMonthDto dto){
       return service.setUserThisMonthManagement(dto);
    }

    @GetMapping("/roulette")
    @Operation(summary = "이달의 목표 불러오기")
    public ManagementMonthVo getUserThisMonthManagement(@PathVariable Long iuser){
        ManagementMonthDto dto = new ManagementMonthDto();
        dto.setIuser(iuser);
        ManagementMonthVo result = service.getUserThisMonthManagement(dto);
        return result;
    }

    @GetMapping("/calculate")
    @Operation(summary = "목표 모두 불러오기")
    public List<ManagementMonthVo> getUserManagementList(@PathVariable Long iuser){
        ManagementMonthDto dto = new ManagementMonthDto();
        dto.setIuser(iuser);
        return service.getUserManagementList(dto);
    }

    @PatchMapping("/roulette")
    @Operation(summary = "이달의 한도 수정")
    public ManagementMonthVo patchUserMonthManagement(@RequestBody ManagemetSetMonthDto dto)throws Exception{
        return service.updUserMonthManagement(dto);
    }

}
