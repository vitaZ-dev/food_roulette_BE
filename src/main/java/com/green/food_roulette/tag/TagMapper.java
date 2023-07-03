package com.green.food_roulette.tag;

import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag.model.TagInsDto;
import com.green.food_roulette.user_menu.model.UserMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    int insMenuTag(List<TagEntity> entity);
    Long findTag(TagEntity Tagentity);
}
