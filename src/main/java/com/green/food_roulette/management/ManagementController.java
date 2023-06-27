package com.green.food_roulette.management;

import com.green.food_roulette.management.model.ManagementMonthDto;
import com.green.food_roulette.management.model.ManagementMonthVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
@Tag(name = "월별 목표")
@RequiredArgsConstructor
public class ManagementController {
    private final ManagementService service;

    @GetMapping("/{iuser}/roulette")
    public ManagementMonthVo getUserThisMonthManagement(@PathVariable Long iuser){
        ManagementMonthDto dto = new ManagementMonthDto();
        dto.setIuser(iuser);
        return service.getUserThisMonthManagement(dto);
    }

    @GetMapping("/{iuser}/calculate")
    public List<ManagementMonthVo> getUserManagementList(@PathVariable Long iuser){
        ManagementMonthDto dto = new ManagementMonthDto();
        dto.setIuser(iuser);
        return service.getUserManagementList(dto);
    }

}
