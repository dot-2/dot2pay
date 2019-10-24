package com.dot2.dot2pay.dao;

import com.dot2.dot2pay.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthDao extends JpaRepository<Auth, Long> {
}
