package com.springcrudapi.Springcrudapi.services;

import com.springcrudapi.Springcrudapi.dtos.PostDto;
import com.springcrudapi.Springcrudapi.entities.Post;
import com.springcrudapi.Springcrudapi.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepo;

    @Override
    public List<PostDto> getAll() {
        List<PostDto> posts = new ArrayList<>();
        var postsFound = postRepo.findAll();

        if (postsFound.isEmpty())
            return posts;

        posts = postsFound.stream().map(p ->
                new PostDto(
                        p.getId(),
                        p.getTitle(),
                        p.isPublished(),
                        p.getImageUrl(),
                        p.getContent()
                )).collect(Collectors.toList());

        return posts;
    }

    @Override
    public PostDto getById(int idPost) {
        var postFound = postRepo.findById(idPost);
        if(postFound != null){
            return postFound.map(p ->
                    new PostDto(
                            p.getId(),
                            p.getTitle(),
                            p.isPublished(),
                            p.getImageUrl(),
                            p.getContent()
                    )).get();
        }
        return null;
    }

    @Override
    public Integer add(PostDto post) {
        if (post != null) {
            Post postToAdd = new Post(
                    post.getTitle(),
                    post.isPublished(),
                    post.getImageUrl(),
                    post.getContent()
            );
            var postAdded = postRepo.save(postToAdd);
            return postAdded.getId();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        if (id > 0) {
            postRepo.deleteById(id);
        }

    }

    @Override
    public void Update(PostDto post) {
        if (post.getId() > 0) {
            var postToUpdate = postRepo.findById(post.getId());

            if (postToUpdate != null) {
                postToUpdate.get().setTitle(post.getTitle());
                postToUpdate.get().setImageUrl(post.getImageUrl());
                postToUpdate.get().setPublished(post.isPublished());
                postToUpdate.get().setContent(post.getContent());

                postRepo.save(postToUpdate.get());
            }
        }
    }
}
