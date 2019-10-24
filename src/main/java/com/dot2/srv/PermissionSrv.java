package com.dot2.srv;

import com.dot2.entity.Permission;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface PermissionSrv {
    Permission add(Permission permission) throws DataAccessException;

    List<Permission> list() throws DataAccessException;

    // 支持根据 id 更新部分字段
    Permission update(Permission permission) throws DataAccessException;

    void remove(Long id) throws DataAccessException;
}
