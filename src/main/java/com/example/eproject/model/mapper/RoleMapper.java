package com.example.eproject.model.mapper;

import com.example.eproject.entity.Role;
import com.example.eproject.model.dto.RoleDTO;
import com.example.eproject.model.req.RoleReq;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;

public class RoleMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static RoleDTO roleDTO(Role role) {
        return modelMapper.map(role, RoleDTO.class);
    }

    public static Role toRole(RoleReq req) {
        return modelMapper.map(req, Role.class);
    }

    public static Page<RoleDTO> pageDTO(Page<Role> roles) {
        TypeToken<Page<RoleDTO>> typeToken = new TypeToken<>() {};
        return modelMapper.map(roles, typeToken.getType());
    }
}
