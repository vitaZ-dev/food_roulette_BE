package com.green.food_roulette.user_menu;

import com.green.food_roulette.user_menu.model.UserMenuInsDto;
import com.green.food_roulette.user_menu.model.UserMenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.zip.ZipException;

@RestController
@RequestMapping("/{iuser}")
@RequiredArgsConstructor
public class UserMenuController {
    private final UserMenuService service;

    @PostMapping("/menu")
    public UserMenuVo postUserMenu(@RequestBody UserMenuInsDto dto) throws ZipException{
        return service.postUserMenu(dto);
    }
}