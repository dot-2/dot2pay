package com.dot2.dot2pay.srv.impl;

import com.dot2.dot2pay.common.util.Util;
import com.dot2.dot2pay.dao.AuthDao;
import com.dot2.dot2pay.model.po.Auth;
import com.dot2.dot2pay.srv.AuthSrv;
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
public class AuthSrvImpl implements AuthSrv {

    @Autowired
    AuthDao authDao;

    @Override
    public Auth add(Auth auth) throws DataAccessException {
        return authDao.save(auth);
    }

    @Override
    public Page<Auth> list(Pageable pageable) throws DataAccessException {
        return authDao.findAll(pageable);
    }

    @Override
    public Auth get(Long id) {
        return authDao.getOne(id);
    }

    @Override
    public Auth update(Auth auth) throws DataAccessException {
        Optional<Auth> ret = authDao.findById(auth.getId());
        if(ret.isEmpty()){
            return null;
        }
        Auth a = new Auth();
        String[] ns = Util.getNullPropertyNames(auth);
        BeanUtils.copyProperties(auth,a,ns);
        return authDao.save(a);
    }

    @Override
    public void remove(Long id) throws DataAccessException {
        authDao.deleteById(id);
    }
}
