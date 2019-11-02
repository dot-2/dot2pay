package com.dot2.dot2pay.srv;

import com.dot2.dot2pay.model.po.Menu;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuSrv {
    Menu add(Menu menu) throws DataAccessException;

    Page<Menu> list(Pageable pageable) throws DataAccessException;

    Menu get(Long id);

    // 支持根据 id 更新部分字段
    Menu update(Menu menu) throws DataAccessException;

    void remove(Long id) throws DataAccessException;
}
