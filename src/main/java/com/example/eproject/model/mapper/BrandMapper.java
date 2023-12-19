package com.example.eproject.model.mapper;

import com.example.eproject.entity.Brand;
import com.example.eproject.model.dto.BrandDTO;
import com.example.eproject.model.req.BrandReq;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;

public class BrandMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static BrandDTO brandDTO(Brand brand) {
        return modelMapper.map(brand, BrandDTO.class);
    }

    public static Brand toBrand(BrandReq req) {
        return modelMapper.map(req, Brand.class);
    }

    public static Page<BrandDTO> pageDTO(Page<Brand> brands) {
        TypeToken<Page<BrandDTO>> typeToken = new TypeToken<>() {};
        return modelMapper.map(brands, typeToken.getType());
    }
}
