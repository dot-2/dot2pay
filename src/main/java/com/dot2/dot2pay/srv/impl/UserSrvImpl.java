package com.dot2.dot2pay.srv.impl;

import com.dot2.dot2pay.common.util.Util;
import com.dot2.dot2pay.dao.UserDao;
import com.dot2.dot2pay.model.po.User;
import com.dot2.dot2pay.srv.UserSrv;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@CacheConfig(cacheNames = "userService")
public class UserSrvImpl implements UserSrv {
    @Autowired
    private UserDao userDao;

    @Override
    public User add(User user) throws DataAccessException {
        return userDao.save(user);
    }

    @Override
    public Page<User> list(Pageable pageable) throws DataAccessException {
        return userDao.findAll(pageable);
    }

    @Override
    public User get(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public User update(User user) throws DataAccessException {
        Optional<User> ret = userDao.findById(user.getId());
        if (ret.isEmpty()) {
            return null;
        }
        User u = ret.get();
        String[] nullNames = Util.getNullPropertyNames(user);
        BeanUtils.copyProperties(user, u, nullNames);
        return userDao.save(u);
    }

    @Override
    public void remove(Long id) throws DataAccessException {
        userDao.deleteById(id);
    }
}
