package com.green.food_roulette.tag_menu;


import com.green.food_roulette.tag.model.TagEntity;
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

    public List<TagMenuGetTagVo> getTagMenu(List<String >list,Long iuser){
        List<TagEntity> arrayList = new ArrayList<>();


        for (String tag : list) {
            TagEntity entity = new TagEntity();
            entity.setTag(tag);
            arrayList.add(entity);
        }
        TagMenuGetTagDto dto = new TagMenuGetTagDto();
        dto.setSize(arrayList.size());
        dto.setIuser(iuser);
        return mapper.getTagMenu(arrayList,arrayList.size(),iuser);



    }
}
