package com.green.food_roulette.tag_menu;

import com.green.food_roulette.tag_menu.model.TagMenuGetTagDto;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagMenuService {
    private final TagMenuMapper mapper;

    public List<TagMenuGetTagVo> getTagMenu(TagMenuGetTagDto dto){
        int size = dto.getList().size();
        dto.setSize(size);

        return mapper.getTagMenu(dto);


    }
}
