package com.example.eproject.repository;

import com.example.eproject.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    @Query(value = "select r from Role r " +
            "where (coalesce(:name, null) is null or r.name like %:name%) " +
            "and (coalesce(:description, null) is null or r.description like %:description%)" +
            "and (coalesce(:status, null) is null or r.status in (:status))"
    )
    Page<Role> findRoles(Pageable pageable, String name, String description, Integer status);
}
