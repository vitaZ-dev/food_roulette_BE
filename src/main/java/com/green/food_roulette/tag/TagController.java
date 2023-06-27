package com.green.food_roulette.tag;

import com.green.food_roulette.tag.model.TagEntity;
import com.green.food_roulette.tag.model.TagInsDto;
import com.green.food_roulette.tag.model.TagVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TagController {
    private final TagService service;
//    @PostMapping
//    public TagVo postTag(TagInsDto dto){
//        return service.postTag(dto);
//    }
}
