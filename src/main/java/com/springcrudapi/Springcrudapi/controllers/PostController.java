package com.springcrudapi.Springcrudapi.controllers;

import com.springcrudapi.Springcrudapi.dtos.PostDto;
import com.springcrudapi.Springcrudapi.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

    @Autowired
    private IPostService postSrv;

    @GetMapping()
    public ResponseEntity<List<PostDto>> getAll() {
        try {
            var posts = postSrv.getAll();
            return new ResponseEntity(posts, HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable int id) {
        try {
            var post = postSrv.getById(id);
            return new ResponseEntity(post, HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Integer> add(@RequestBody PostDto postDto) {
        try {
            int idPostCreated = postSrv.add(postDto);
            return new ResponseEntity(idPostCreated, HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            postSrv.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody PostDto post) {

        postSrv.Update(post);
        return new ResponseEntity(HttpStatus.OK);
    }


}
