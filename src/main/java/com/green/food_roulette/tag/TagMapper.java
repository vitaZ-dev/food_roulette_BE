package com.green.food_roulette.tag;

import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag.model.TagVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    Long insTag(TagEntity entity);
    TagVo findTag(TagEntity entity);
}
