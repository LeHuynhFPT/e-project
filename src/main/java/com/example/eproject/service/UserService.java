package com.example.eproject.service;

import com.example.eproject.entity.User;
import com.example.eproject.model.dto.UserDTO;
import com.example.eproject.model.req.UserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getUser();

    UserDTO findId(Long id);

    List<UserDTO> searchUser(String keyword);

    UserDTO createUser(UserReq req);

    UserDTO updateUser(UserReq req, Long id);

    void deleteUser(Long id);

    User findByEmail(String name);
}
