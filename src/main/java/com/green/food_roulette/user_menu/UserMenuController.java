package com.green.food_roulette.user_menu;

import com.green.food_roulette.user_menu.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.ZipException;

@RestController
@RequestMapping("/{iuser}")
@RequiredArgsConstructor
public class UserMenuController {
    private final UserMenuService service;

    @PostMapping("/menu")
    @Operation(summary = "유저 메뉴 생성")
    public UserMenuVo postUserMenu(@RequestBody UserMenuInsDto dto) throws ZipException{
        return service.postUserMenu(dto);
    }
    @GetMapping("/usermenu")
    @Operation(summary = "유저 메뉴 불러오기")
    public List<UserMenuVo> getUserMenu(@PathVariable Long iuser){
        UserMenuIuserDto dto = new UserMenuIuserDto();
        dto.setIuser(iuser);
        return service.getUserMenu(dto);
    }
    @GetMapping("/activationusermenu")
    @Operation(summary = "활성화 된 유저메뉴 불러오기")
    public List<UserMenuVo> getActivationUserMenu(@PathVariable Long iuser){
        UserMenuIuserDto dto = new UserMenuIuserDto();
        dto.setIuser(iuser);
        return service.getActivationUserMenu(dto);
    }
    @PatchMapping
    @Operation(summary = "메뉴 활성화 풀기")
    public int updActivation(@RequestBody UserMenuIuserMenuDto dto){
        return service.updActivation(dto);
    }
}