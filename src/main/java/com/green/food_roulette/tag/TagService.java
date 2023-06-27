package com.green.food_roulette.tag;

import com.green.food_roulette.tag.model.TagInsDto;
import com.green.food_roulette.tag.model.TagVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagMapper mapper;
}
//    public TagVo postTag(TagInsDto dto){
//
//
//}
