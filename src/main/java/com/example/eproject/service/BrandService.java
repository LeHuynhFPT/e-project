package com.example.eproject.service;

import com.example.eproject.model.dto.BrandDTO;
import com.example.eproject.model.req.BrandReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BrandService {
    Page<BrandDTO> getBrand(Pageable pageable, String name, String description, String hotline, String email);

    BrandDTO saveBrand(BrandReq req);

    void deleteBrand(Long id);
}
