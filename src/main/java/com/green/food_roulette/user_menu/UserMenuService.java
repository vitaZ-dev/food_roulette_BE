package com.green.food_roulette.user_menu;

import com.green.food_roulette.common_menu.CommonMenuMapper;
import com.green.food_roulette.tag.TagMapper;
import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag_menu.TagMenuMapper;
import com.green.food_roulette.tag_menu.model.TagMenuEntity;
import com.green.food_roulette.user_menu.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipException;

@Service
@RequiredArgsConstructor
public class UserMenuService {
    private final UserMenuMapper mapper;
    private final TagMapper tagMapper;
    private final TagMenuMapper tagMenuMapper;

    @Transactional(rollbackFor = ZipException.class)
    public List<UserMenuDto> postUserMenu(UserMenuInsDto dto) throws ZipException {
        UserMenuEntity entity = new UserMenuEntity();
        TagEntity tagEntity;
        List<UserMenuDto> list = new ArrayList<>();
        String tag = dto.getTag();
        String[] arr = tag.split(" ");
        entity.setIuser(dto.getIuser());
        entity.setMenu(dto.getMenu());
        int i1 = tagMenuMapper.insTagMenu();
        Long result = mapper.findUserMenu(entity);
        if (result == null) {
            mapper.insUserMenu(entity);
        } else {
            throw new ZipException();
        }
        List<TagEntity> tList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            UserMenuDto dto1 = new UserMenuDto();
            tagEntity = new TagEntity();
            tagEntity.setTag(arr[i]);
            tList.add(tagEntity);
            Long result2 = tagMapper.findTag(tagEntity);
            if (result2 == null) {
                tagMapper.insMenuTag(tList);
                result2 = tagEntity.getItag();
                dto1.setItag(result2);
                list.add(dto1);
            } else {
                dto1.setItag(result2);
                list.add(dto1);
            }
        }
        return list;
    }

    public List<UserMenuVo> getUserMenu(UserMenuIuserDto dto) {
        return mapper.getUserMenu(dto);
    }

    public List<UserMenuVo> getActivationUserMenu(UserMenuIuserDto dto) {
        return mapper.getActivationUserMenu(dto);
    }

    public int updActivation(UserMenuIuserMenuDto dto) {
        UserMenuEntity entity = new UserMenuEntity();
        entity.setIuserMenu(dto.getIuserMenu());
        int result = mapper.findActivation(entity);
        if (result != 0) {
            entity.setActivation(0);
        } else {
            entity.setActivation(1);
        }
        System.out.println(entity.getActivation());
        mapper.updActivation(entity);
        return entity.getActivation();
    }

    public List<MenusVo> getMenus(UserMenuIuserDto dto) {
        return mapper.getMenus(dto);
    }
}