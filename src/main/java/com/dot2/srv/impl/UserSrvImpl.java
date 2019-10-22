package com.dot2.srv.impl;

import com.dot2.dao.UserDao;
import com.dot2.entity.User;
import com.dot2.srv.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "userService")
public class UserSrvImpl implements UserSrv {
    @Autowired
    private UserDao userDao;

    /**
     * cacheNames 与 value 定义一样，设置了 value 的值，则类的 cacheNames 配置无效。<br>
     * 使用 keyGenerator ，注意是否在config文件中定义好。
     * @see
     */
    @Override
    @Cacheable(value = "getAllUsers", key = "#root.targetClass")
//  @Cacheable(value = "getAllUsers", keyGenerator = "wiselyKeyGenerator")
    public List<User> getAllUsers()
    {
        return userDao.findAll();
    }

    @CacheEvict(key = "#root.targetClass", value = "getAllUsers")
    public User insert(User user){
        return userDao.save(user);
    }

    /**
     * 执行该函数时，将清除以 userService 的缓存，【cacheNames = "userService"】<br>
     * 也可指定清除的key 【@CacheEvict(value="abc")】
     */
    @CacheEvict(value = "getAllUsers")
    public void clearAllUserCache()
    {

    }

    /**
     * key ="#p0" 表示以第1个参数作为 key
     */
    @Override
    @Cacheable(value="user", key ="#root.targetClass+'-'+#p0")
    public User findById(Long pId)
    {
        Optional<User> _User = userDao.findById(pId);

        return Optional.ofNullable(_User).get().orElse(null);
    }

    @CacheEvict(value="user", key ="#p0")
    public void clear(Long pId)
    {

    }
}
