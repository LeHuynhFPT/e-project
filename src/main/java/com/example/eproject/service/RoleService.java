package com.example.eproject.service;

import com.example.eproject.entity.Role;
import com.example.eproject.model.dto.RoleDTO;
import com.example.eproject.model.req.RoleReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {

    Page<RoleDTO> getRole(Pageable pageable, String name, String description, Integer status);

    RoleDTO saveRole(RoleReq req);

    void deleteRole(Long id);
}
