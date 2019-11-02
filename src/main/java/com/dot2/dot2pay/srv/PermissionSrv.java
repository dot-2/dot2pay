package com.dot2.dot2pay.srv;

import com.dot2.dot2pay.model.po.Permission;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface PermissionSrv {
    Permission add(Permission permission) throws DataAccessException;

    List<Permission> list(Long parentId) throws DataAccessException;
    List<Permission> list() throws DataAccessException;

    Permission get(Long id);

    // 支持根据 id 更新部分字段
    Permission update(Permission permission) throws DataAccessException;

    void remove(Long id) throws DataAccessException;
}
