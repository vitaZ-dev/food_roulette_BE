package com.green.food_roulette.user_menu;

import com.green.food_roulette.common_menu.CommonMenuService;
import com.green.food_roulette.common_menu.model.CommonMenuEntity;
import com.green.food_roulette.common_menu.model.CommonMenuVo;
import com.green.food_roulette.tag_menu.model.MenuDto;
import com.green.food_roulette.user_menu.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.ZipException;

@RestController
@RequestMapping("api/menu/{iuser}")
@Tag(name = "메뉴")
@RequiredArgsConstructor
public class UserMenuController {
    private final UserMenuService service;
    //private final CommonMenuService commonMenuService;

    @PostMapping
    @Operation(summary = "유저 메뉴 생성",description = "iuser=유저 id" +
            " menu = 메뉴이름")
    public int postUserMenu(@RequestBody UserMenuInsDto dto,@RequestParam List<String> tags) {

        try {
            return service.postUserMenu(dto,tags);
        } catch (ZipException e) {
            return -1;
        }

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
    @DeleteMapping
    @Operation(summary = "메뉴 삭제" ,description = "삭제할 메뉴의 id값")
    public int updActivation(@RequestParam Long iuserMenu ){
        UserMenuIuserMenuDto dto = new UserMenuIuserMenuDto();
        dto.setIuserMenu(iuserMenu);
        return service.updActivation(dto);
    }
//     @GetMapping("/common")
//     @Operation(summary = "공통 메뉴 불러오기")
//        public List<CommonMenuVo> getCommonMenu(){
//         return commonMenuService.getCommonMenu();
//   }
   @GetMapping
    @Operation(summary = "메뉴리스트",description = "iuser= 유저 id")
    public List<MenusVo> getMenus(@PathVariable Long iuser){
       UserMenuIuserDto dto = new UserMenuIuserDto();
       dto.setIuser(iuser);
       return service.getMenus(dto);
   }
   @PutMapping
   @Operation(summary = "태그 삭제(메뉴 안보이게)",description = "iuser= 유저id iuserMenu=삭제할 메뉴pk값")
    public Long delMenuTag(@PathVariable Long iuser, @RequestParam Long iuserMenu){
       UserMenuEntity entity = new UserMenuEntity();
       entity.setIuser(iuser);
       entity.setIuserMenu(iuserMenu);
       return service.delMenuTag(entity);
   }
}