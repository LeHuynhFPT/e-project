package com.example.eproject.repository;

import com.example.eproject.entity.Brand;
import com.example.eproject.entity.Gif;
import com.example.eproject.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(value = "select b from Brand b " +
            "where (coalesce(:name, null) is null or b.name like %:name%) " +
            "and (coalesce(:description, null) is null or b.description like %:description%) " +
            "and (coalesce(:hotline, null) is null or b.hotline like %:hotline%) " +
            "and (coalesce(:email, null) is null or b.email like %:email%) "
    )
    Page<Brand> findBrands(Pageable pageable, String name, String description, String hotline, String email);

    Brand findByName(String name);
}
