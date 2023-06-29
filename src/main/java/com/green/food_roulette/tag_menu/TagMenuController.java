package com.green.food_roulette.tag_menu;

import com.green.food_roulette.tag_menu.model.TagMenuGetTagVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Tag(name = "태그")
@RestController
@RequestMapping("/menus")
public class TagMenuController {
    private final TagMenuService service;

    @GetMapping("/tag/{iuser}")
    @Operation(summary = "태그로 메뉴 검색")
    public List<TagMenuGetTagVo> getTagMenu(@RequestParam (value = "list") List<String>itag,@PathVariable Long iuser){

        return service.getTagMenu(itag,iuser);
    }
}
