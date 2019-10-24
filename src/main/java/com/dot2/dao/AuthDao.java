package com.dot2.dao;

import com.dot2.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthDao extends JpaRepository<Auth, Long> {
}
