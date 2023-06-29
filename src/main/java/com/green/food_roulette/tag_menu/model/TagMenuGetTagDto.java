package com.green.food_roulette.tag_menu.model;

import lombok.Data;

import java.util.List;

@Data
public class TagMenuGetTagDto {
    private int size;
    private Long itag;
    private List<Long> list;

}
