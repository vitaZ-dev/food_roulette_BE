package com.green.food_roulette.user_menu;

import com.green.food_roulette.common_menu.CommonMenuService;
import com.green.food_roulette.common_menu.model.CommonMenuEntity;
import com.green.food_roulette.common_menu.model.CommonMenuVo;
import com.green.food_roulette.user_menu.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.ZipException;

@RestController
@RequestMapping("/menus/{iuser}")
@Tag(name = "메뉴")
@RequiredArgsConstructor
public class UserMenuController {
    private final UserMenuService service;
    private final CommonMenuService commonMenuService;

    @PostMapping("/insmenu")
    @Operation(summary = "유저 메뉴 생성")
    public UserMenuVo postUserMenu(@RequestBody UserMenuInsDto dto) throws ZipException{
        return service.postUserMenu(dto);
    }
    @GetMapping("/user")
    @Operation(summary = "유저 메뉴 불러오기")
    public List<UserMenuVo> getUserMenu(@PathVariable Long iuser){
        UserMenuIuserDto dto = new UserMenuIuserDto();
        dto.setIuser(iuser);
        return service.getUserMenu(dto);
    }
//    @GetMapping
//    @Operation(summary = "메뉴 불러오기")
//    public List<UserMenuVo> getActivationUserMenu(@PathVariable Long iuser){
//        UserMenuIuserDto dto = new UserMenuIuserDto();
//        dto.setIuser(iuser);
//        return service.getActivationUserMenu(dto);
    // 활성화된 유저메뉴 불러오기
//    }
    @PatchMapping("/onoff")
    @Operation(summary = "메뉴 활성화 풀기")
    public int updActivation(@RequestBody UserMenuIuserMenuDto dto){
        return service.updActivation(dto);
    }
     @GetMapping("/common")
     @Operation(summary = "공통 메뉴 불러오기")
        public List<CommonMenuVo> getCommonMenu(){
         return commonMenuService.getCommonMenu();
   }
   @GetMapping("/menus")
    @Operation(summary = "메뉴리스트")
    public List<MenusVo> getMenus(@PathVariable Long iuser){
       UserMenuIuserDto dto = new UserMenuIuserDto();
       dto.setIuser(iuser);
       return service.getMenus(dto);
   }
}