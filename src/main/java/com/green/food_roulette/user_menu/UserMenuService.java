package com.green.food_roulette.user_menu;

import com.green.food_roulette.common_menu.CommonMenuMapper;
import com.green.food_roulette.user_menu.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.zip.ZipException;

@Service
@RequiredArgsConstructor
public class UserMenuService {
    private final UserMenuMapper mapper;

    @Transactional(rollbackFor = ZipException.class)
    public UserMenuVo postUserMenu(UserMenuInsDto dto) throws ZipException{
        UserMenuEntity entity = new UserMenuEntity();
        entity.setIuser(dto.getIuser());
        entity.setMenu(dto.getMenu());
        Long result = mapper.findUserMenu(entity);
        if (result == null){
            mapper.insUserMenu(entity);
            return mapper.selUserMenu(entity.getIuserMenu());
        }
            throw new ZipException();
    }
    public List<UserMenuVo> getUserMenu(UserMenuIuserDto dto){
        return mapper.getUserMenu(dto);
    }
    public List<UserMenuVo> getActivationUserMenu(UserMenuIuserDto dto){
        return mapper.getActivationUserMenu(dto);
    }
    public int updActivation(UserMenuIuserMenuDto dto){
        UserMenuEntity entity = new UserMenuEntity();
        entity.setIuserMenu(dto.getIuserMenu());
        int result = mapper.findActivation(entity);
        if (result != 0) {
            entity.setActivation(0);
        }else{
            entity.setActivation(1);
        }
        System.out.println(entity.getActivation());
        mapper.updActivation(entity);
        return entity.getActivation();
        }
        public List<MenusVo> getMenus(UserMenuIuserDto dto){
        return mapper.getMenus(dto);
        }
    }