package com.springcrudapi.Springcrudapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private int id;
    private String title;
    private boolean published;
    private String imageUrl;
    private String content;


}
