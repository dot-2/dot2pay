package com.dot2.dot2pay.srv;


import com.dot2.dot2pay.model.po.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserSrv {
    User add(User user) throws DataAccessException;

    Page<User> list(Pageable pageable) throws DataAccessException;

    User get(Long id);

    // 支持根据 id 更新部分字段
    User update(User user) throws DataAccessException;

    void remove(Long id) throws DataAccessException;
}
