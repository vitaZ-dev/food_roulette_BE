package com.green.food_roulette.tag_menu;

import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag_menu.model.MenuDto;
import com.green.food_roulette.tag_menu.model.TagMenuEntity;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagDto;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagVo;
import com.green.food_roulette.user_menu.model.UserMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMenuMapper {
    int joinTagMenu(List<TagMenuEntity> tag);
    List<TagMenuGetTagVo>getTagMenu(List<TagEntity> list,int size,Long iuser);
    int insTagMenu(TagMenuEntity entity);
    Long delMenuTag(UserMenuEntity entity);
}
