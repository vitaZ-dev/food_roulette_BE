package com.green.food_roulette.user_menu;

import com.green.food_roulette.user_menu.model.UserMenuEntity;
import com.green.food_roulette.user_menu.model.UserMenuInsDto;
import com.green.food_roulette.user_menu.model.UserMenuVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;

import java.io.IOException;
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
}
