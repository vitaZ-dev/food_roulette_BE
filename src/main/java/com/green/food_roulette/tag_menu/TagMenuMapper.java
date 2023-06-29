package com.green.food_roulette.tag_menu;

import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagDto;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMenuMapper {
    List<TagMenuGetTagVo>getTagMenu(List<TagEntity> list,int size,Long iuser);
}
