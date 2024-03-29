package com.dot2.dot2pay.srv.impl;

import com.dot2.dot2pay.dao.PermissionDao;
import com.dot2.dot2pay.model.po.Permission;
import com.dot2.dot2pay.srv.PermissionSrv;
import com.dot2.dot2pay.common.util.Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
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
    @Cacheable(key = "#root.targetClass", value = "list")
    public List<Permission> list(Long parentId) throws DataAccessException {
        List<Permission> ps = permissionDao.findAllByParentId(null);
        getChildren(ps);
        return ps;
    }

    @Override
    public List<Permission> list() throws DataAccessException {
        return list(null);
    }

    @Override
    @Cacheable(key = "#root.targetClass+'-'+#p0", value = "permission")
    public Permission get(Long id) throws DataAccessException {
        return permissionDao.findById(id).orElse(null);
    }

    @Override
    @CachePut(key = "#root.targetClass+'-'+#result.id", value = "permission")
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
    @CacheEvict(key = "#root.targetClass+'-'+#p0", value = "permission")
    public void remove(Long id) throws DataAccessException {
        permissionDao.deleteById(id);
    }


    // 获取下级权限
    private void getChildren(List<Permission> ps) {
        if (ps.size() == 0) return;
        for (Permission p : ps) {
            p.setChildren(permissionDao.findAllByParentId(p.getId()));
            getChildren(p.getChildren());
        }
    }

}
