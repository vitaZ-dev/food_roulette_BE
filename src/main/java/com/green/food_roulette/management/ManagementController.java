package com.green.food_roulette.management;

import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/{iuser}")
@RestController
@Tag(name = "월별 목표")
@RequiredArgsConstructor
public class ManagementController {
    private final ManagementService service;

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

}
