package com.dot2.dot2pay.srv.impl;

import com.dot2.dot2pay.common.util.Util;
import com.dot2.dot2pay.dao.RoleDao;
import com.dot2.dot2pay.model.po.Role;
import com.dot2.dot2pay.srv.RoleSrv;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class RoleSrvImpl implements RoleSrv {

    @Autowired
    RoleDao roleDao;

    @Override
    public Role add(Role role) throws DataAccessException {
        return roleDao.save(role);
    }

    @Override
    public Page<Role> list(Pageable pageable) throws DataAccessException {
        return roleDao.findAll(pageable);
    }

    @Override
    public Role get(Long id) {
        return roleDao.getOne(id);
    }

    @Override
    public Role update(Role role) throws DataAccessException {
        Optional<Role> ret = roleDao.findById(role.getId());
        if(ret.isEmpty()){
            return null;
        }
        Role r = new Role();
        String[] ns = Util.getNullPropertyNames(role);
        BeanUtils.copyProperties(role,r,ns);
        return roleDao.save(r);
    }

    @Override
    public void remove(Long id) throws DataAccessException {
        roleDao.deleteById(id);
    }
}
