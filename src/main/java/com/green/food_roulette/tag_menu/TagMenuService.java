package com.green.food_roulette.tag_menu;


import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag_menu.model.TagMenuGetDto;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagDto;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagMenuService {
    private final TagMenuMapper mapper;

    public List<TagMenuGetTagVo> getTagMenu(TagMenuGetDto dto, Long iuser){
        List<TagEntity> arrayList = new ArrayList<>();
        if (dto.getTags().size()==0){return null;}

        for (String tag : dto.getTags()) {
            TagEntity entity = new TagEntity();
            entity.setTag(tag.replaceAll("\\s",""));
            arrayList.add(entity);
        }
        TagMenuGetTagDto tDto = new TagMenuGetTagDto();
        tDto.setSize(arrayList.size());
        tDto.setIuser(iuser);
        return mapper.getTagMenu(arrayList,arrayList.size(),iuser);



    }
}
