package com.dot2.dot2pay.dao;

import com.dot2.dot2pay.model.po.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionDao extends JpaRepository<Permission, Long> {
    List<Permission> findAllByParentId(Long parentId);
}
