package com.dot2.dot2pay.srv.impl;

import com.dot2.dot2pay.dao.PermissionDao;
import com.dot2.dot2pay.entity.Permission;
import com.dot2.dot2pay.srv.PermissionSrv;
import com.dot2.dot2pay.common.util.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@CacheConfig(cacheNames = "PermissionSrv")
public class PermissionSrvImpl implements PermissionSrv {

    @Autowired
    PermissionDao permissionDao;

    @Override
    @CacheEvict(key = "#root.targetClass", value = "list")
    public Permission add(Permission permission) throws DataAccessException {
        return permissionDao.save(permission);
    }

    @Override
//    @Cacheable(key = "#root.targetClass", value = "list")
    public List<Permission> list() throws DataAccessException {
        List<Permission> permissions = permissionDao.findAllByParentId(null);
        return permissions;
    }

    @Override
    @CacheEvict(key = "#root.targetClass", value = "list")
    public Permission update(Permission permission) throws DataAccessException {
        Optional<Permission> ret = permissionDao.findById(permission.getId());
        Permission currentPermission = null;
        if (ret.isPresent()) {
            currentPermission = ret.get();
        } else {
            return null;
        }

        // 部分更新
        String[] nullPropertyNames = Util.getNullPropertyNames(permission);
        BeanUtils.copyProperties(permission, currentPermission, nullPropertyNames);
        return permissionDao.save(currentPermission);
    }

    @Override
    @CacheEvict(key = "#root.targetClass", value = "list")
    public void remove(Long id) throws DataAccessException {
        permissionDao.deleteById(id);
    }
}
