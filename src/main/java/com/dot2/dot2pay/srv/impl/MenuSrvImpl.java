package com.dot2.dot2pay.srv.impl;

import com.dot2.dot2pay.common.util.Util;
import com.dot2.dot2pay.dao.MenuDao;
import com.dot2.dot2pay.model.po.Menu;
import com.dot2.dot2pay.srv.MenuSrv;
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
public class MenuSrvImpl implements MenuSrv {

    @Autowired
    MenuDao menuDao;

    @Override
    public Menu add(Menu menu) throws DataAccessException {
        return menuDao.save(menu);
    }

    @Override
    public Page<Menu> list(Pageable pageable) throws DataAccessException {
        return menuDao.findAll(pageable);
    }

    @Override
    public Menu get(Long id) {
        return menuDao.getOne(id);
    }

    @Override
    public Menu update(Menu menu) throws DataAccessException {
        Optional<Menu> ret = menuDao.findById(menu.getId());
        if(ret.isEmpty()){
            return null;
        }
        Menu menu1 = new Menu();
        String[] ns = Util.getNullPropertyNames(menu);
        BeanUtils.copyProperties(menu,menu1,ns);
        return menuDao.save(menu1);
    }

    @Override
    public void remove(Long id) throws DataAccessException {
        menuDao.deleteById(id);
    }
}
