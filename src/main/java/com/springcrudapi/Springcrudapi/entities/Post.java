package com.springcrudapi.Springcrudapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private boolean published;
    private String imageUrl;
    private String content;

    public Post(
            String title,
            boolean published,
            String imageUrl,
            String content) {
        this.title = title;
        this.published = published;
        this.imageUrl = imageUrl;
        this.content = content;
    }
}
