package com.green.food_roulette.tag_menu;

import com.green.food_roulette.tag_menu.model.TagMenuGetTagDto;
import com.green.food_roulette.tag_menu.model.TagMenuGetTagVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/{iuser}")
public class TagMenuController {
    private final TagMenuService service;

    @PostMapping("/menus/tag")
    public List<TagMenuGetTagVo> getTagMenu(@RequestBody TagMenuGetTagDto dto){
        return service.getTagMenu(dto);
    }
}
