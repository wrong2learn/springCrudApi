package com.springcrudapi.Springcrudapi.services;

import com.springcrudapi.Springcrudapi.dtos.PostDto;

import java.util.List;

public interface IPostService {

    List<PostDto> getAll();
    PostDto getById(int idPost);
    Integer add(PostDto post);
    void delete(int id);
    void Update(PostDto post);
}

