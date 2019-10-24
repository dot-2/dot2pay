package com.dot2.dot2pay.dao;

import com.dot2.dot2pay.model.po.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDao extends JpaRepository<Menu, Long> {
}
