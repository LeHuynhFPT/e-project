package com.example.eproject.controller;

import com.example.eproject.entity.Role;
import com.example.eproject.model.dto.RoleDTO;
import com.example.eproject.model.req.RoleReq;
import com.example.eproject.model.res.DataRes;
import com.example.eproject.model.res.Pagination;
import com.example.eproject.service.RoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DataRes> getRole(@RequestBody RoleReq req) {
        Pageable pageable = PageRequest.of(req.getPageNumber(), req.getPageSize());
        Page<RoleDTO> page = roleService.getRole(
                pageable,
                req.getName(),
                req.getDescription(),
                req.getStatus()
        );
        DataRes res = new DataRes();
        res.setData(page.getContent());
        res.setPagination(new Pagination(page.getPageable().getPageNumber(), page.getSize(), page.getTotalElements()));
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> saveRole(@RequestBody RoleReq req) {
        RoleDTO create = roleService.saveRole(req);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateRole(@RequestBody RoleReq req, @PathVariable Long id) {
        req.setId(id);
        RoleDTO create = roleService.saveRole(req);
        return new ResponseEntity<>(create, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok("Delete Success");
    }
}
