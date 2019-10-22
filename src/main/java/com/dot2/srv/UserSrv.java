package com.dot2.srv;

import com.dot2.entity.User;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

public interface UserSrv {
    List<User> getAllUsers();

    User findById(Long pId);

    User insert(User user);

    void clearAllUserCache();

    void clear(Long pId);
}
