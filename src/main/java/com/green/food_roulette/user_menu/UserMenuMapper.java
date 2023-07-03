package com.green.food_roulette.user_menu;

import com.green.food_roulette.user_menu.model.MenusVo;
import com.green.food_roulette.user_menu.model.UserMenuEntity;
import com.green.food_roulette.user_menu.model.UserMenuIuserDto;
import com.green.food_roulette.user_menu.model.UserMenuVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMenuMapper {
    Long insUserMenu(UserMenuEntity entity);
    Long findUserMenu(UserMenuEntity entity);
    UserMenuVo selUserMenu(Long iuserMenu);
    List<UserMenuVo> getUserMenu(UserMenuIuserDto dto);
    List<UserMenuVo> getActivationUserMenu(UserMenuIuserDto dto);
    int updActivation(UserMenuEntity entity);

    int findActivation(UserMenuEntity entity);
    List<MenusVo> getMenus(UserMenuIuserDto dto);
}
