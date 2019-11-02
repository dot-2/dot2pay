package com.dot2.dot2pay.srv;

import com.dot2.dot2pay.model.po.Role;
import com.dot2.dot2pay.model.po.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleSrv {
    Role add(Role role) throws DataAccessException;

    Page<Role> list(Pageable pageable) throws DataAccessException;

    Role get(Long id);

    // 支持根据 id 更新部分字段
    Role update(Role role) throws DataAccessException;

    void remove(Long id) throws DataAccessException;
}
