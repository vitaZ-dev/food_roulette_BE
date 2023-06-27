package com.green.food_roulette.user_menu;

import com.green.food_roulette.user_menu.model.UserMenuEntity;
import com.green.food_roulette.user_menu.model.UserMenuVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMenuMapper {
    Long insUserMenu(UserMenuEntity entity);
    Long findUserMenu(UserMenuEntity entity);
    UserMenuVo selUserMenu(Long iuserMenu);
}
