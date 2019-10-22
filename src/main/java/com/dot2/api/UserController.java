package com.dot2.api;

import com.dot2.entity.User;
import com.dot2.exception.NotFoundException;
import com.dot2.exception.Result;
import com.dot2.srv.UserSrv;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserSrv userService;

    // http://localhost:8081/all
    @GetMapping("/all")
    public List<User> getAllUsers()
    {
        System.out.println("只有第一次才会打印sql语句");
        return userService.getAllUsers();
    }

    @GetMapping("/add")
    public User add(){
        Random rnd = new Random();
        User user = new User();
        user.setName(("你好"+rnd.nextLong()+"22222222222222222222222222222222222222222222222222222222222222").substring(0,19));
        user.setPass((rnd.nextLong()+"11111111111111111111111111111111111111111111111111111111111111111111111111").substring(0,30));
        return userService.insert(user);
    }

    // http://localhost:8081/findById?id=1
    @GetMapping("/findById")
    public User findById(@RequestParam(name = "id")Long pId)
    {
        return userService.findById(pId);
    }

    // http://localhost:8081/clear
    @GetMapping("/clear")
    public void clear()
    {
        userService.clearAllUserCache();
    }

    // http://localhost:8081/clearOne?id=1
    @GetMapping("/clearOne")
    public void clear(@RequestParam(name = "id")Long pId)
    {
        userService.clear(pId);
    }
}