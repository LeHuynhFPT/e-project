package com.example.eproject.service.impl;

import com.example.eproject.entity.Role;
import com.example.eproject.entity.User;
import com.example.eproject.model.dto.UserDTO;
import com.example.eproject.model.mapper.UserMapper;
import com.example.eproject.model.req.UserReq;
import com.example.eproject.repository.RoleRepository;
import com.example.eproject.repository.UserRepository;
import com.example.eproject.service.UserService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<UserDTO> getUser() {
        List<User> users = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (User user : users) {
            result.add(UserMapper.userDto(user));
        }
        return result;
    }

    @Override
    public UserDTO findId(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("Not Found In System");
        }
        return UserMapper.userDto(user.get());
    }

    @Override
    public List<UserDTO> searchUser(String keyword) {
        List<User> users = userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();
        for (User user : users) {
            if (user.getName().contains(keyword)) {
                result.add(UserMapper.userDto(user));
            }
        }
        return result;
    }

    @Override
    public UserDTO createUser(UserReq req) {
        if (req == null) {
            throw new RuntimeException("NullPointerException");
        }
        User user = userRepository.findByEmail(req.getEmail());
        if (user != null) {
            throw new RuntimeException("Email is already in use");
        }
        Role role = roleRepository.findByName("EMPLOYEE");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        if (req.getType() != null) {
            role = roleRepository.findByName(req.getType().toUpperCase(Locale.ROOT));
            roles.add(role);
            req.setRoles(roles);
        }
        user = UserMapper.toUser(req);
        user.setStatus(1);
        userRepository.save(user);

        return UserMapper.userDto(user);
    }

    @Override
    public UserDTO updateUser(UserReq req, Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("Not Found User");
        }

        User update = UserMapper.toUser(req, id);
        try {
            userRepository.save(update);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Database error. Can't update user");
        }

        return UserMapper.userDto(update);
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("Not Found User");
        }
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Database error. Can't delete user");
        }
    }

    @Override
    public User findByEmail(String name) {
        User user = userRepository.findByEmail(name);
        if (user == null) {
            throw new RuntimeException("Not Found In System");
        }
        return user;
    }
}
