package com.springcrudapi.Springcrudapi.repositories;

import com.springcrudapi.Springcrudapi.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {

}

