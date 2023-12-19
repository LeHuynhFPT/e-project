package com.example.eproject.model.mapper;

import com.example.eproject.entity.User;
import com.example.eproject.model.dto.UserDTO;
import com.example.eproject.model.req.UserReq;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    public static UserDTO userDto(User user) {
        UserDTO tmp = new UserDTO();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setTel(user.getTel());
        tmp.setAddress(user.getAddress());
        tmp.setBirthday(user.getBirthday());
        tmp.setType(user.getType());
        tmp.setStatus(user.getStatus());
        tmp.setRoles(user.getRoles());
        tmp.setGifs(user.getGifs());

        return tmp;
    }

    public static User toUser(UserReq req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setTel(req.getTel());
        user.setAddress(req.getAddress());
        user.setBirthday(req.getBirthday());
        user.setType(req.getType());
        user.setStatus(req.getStatus());
        user.setRoles(req.getRoles());
        user.setGifs(req.getGifs());
        // Hash password using BCryptPasswordEncoder
        user.setPassword(new BCryptPasswordEncoder(12).encode(req.getPassword()));

        return user;
    }

    public static User toUser(UserReq req, Long id) {
        User user = new User();
        user.setId(id);
        user.setEmail(req.getEmail());
        user.setName(req.getName());
        user.setTel(req.getTel());
        user.setAddress(req.getAddress());
        user.setBirthday(req.getBirthday());
        user.setType(req.getType());
        user.setStatus(req.getStatus());
        user.setRoles(req.getRoles());
        user.setGifs(req.getGifs());
        // Hash password using BCrypt
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);

        return user;
    }
}
