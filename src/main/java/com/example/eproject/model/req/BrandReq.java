package com.example.eproject.model.req;

import com.example.eproject.entity.Gif;
import com.example.eproject.entity.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandReq {
    private Long id;

    private String name;

    private String description;

    private String hotline;

    private String email;

    private List<Restaurant> restaurants = new ArrayList<>();

    private List<Gif> gifs = new ArrayList<>();

    private int pageNumber = 0;

    private int pageSize = 20;
}
