package com.dot2.dot2pay.dao;

import com.dot2.dot2pay.model.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
