package com.wybory.pai.repository;

import com.wybory.pai.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepo extends JpaRepository<Permission,Integer> {
    Permission findPermissionById(int id);
    Permission findPermissionByName(String name);
}
