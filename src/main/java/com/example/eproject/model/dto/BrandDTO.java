package com.example.eproject.model.dto;

import com.example.eproject.entity.Gif;
import com.example.eproject.entity.Restaurant;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDTO {

    private Long id;

    private String name;

    private String description;

    private String hotline;

    private String email;

    private List<Restaurant> restaurants;

    private List<Gif> gifs;
}
