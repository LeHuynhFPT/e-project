package com.example.eproject.model.dto;

import com.example.eproject.entity.Gif;
import com.example.eproject.entity.Role;
import com.example.eproject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String tel;
    private String address;
    private Date birthday;
    private String type;
    private Integer status;
    private Set<Role> roles;
    private List<Gif> gifs;
}
