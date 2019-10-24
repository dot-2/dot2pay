package com.dot2.dao;

import com.dot2.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    List<Permission> findAllByParentId(Permission parent);
}
