package com.dot2.dot2pay.srv;

import com.dot2.dot2pay.model.po.Auth;
import com.dot2.dot2pay.model.po.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthSrv {
    Auth add(Auth auth) throws DataAccessException;

    Page<Auth> list(Pageable pageable) throws DataAccessException;

    Auth get(Long id);

    // 支持根据 id 更新部分字段
    Auth update(Auth auth) throws DataAccessException;

    void remove(Long id) throws DataAccessException;
}
