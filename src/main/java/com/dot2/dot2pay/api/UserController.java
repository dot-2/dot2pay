package com.dot2.dot2pay.api;

import com.dot2.dot2pay.srv.UserSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserSrv userService;

//    // http://localhost:8081/all
//    @GetMapping("/all")
//    public List<User> getAllUsers()
//    {
//        System.out.println("只有第一次才会打印sql语句");
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/add")
//    public User add(){
//        Random rnd = new Random();
//        User user = new User();
//        user.setName(("你好"+rnd.nextLong()+"22222222222222222222222222222222222222222222222222222222222222").substring(0,19));
//        return userService.insert(user);
//    }
//
//    // http://localhost:8081/findById?id=1
//    @GetMapping("/findById")
//    public User findById(@RequestParam(name = "id")Long pId)
//    {
//        return userService.findById(pId);
//    }
//
//    // http://localhost:8081/clear
//    @GetMapping("/clear")
//    public void clear()
//    {
//        userService.clearAllUserCache();
//    }
//
//    // http://localhost:8081/clearOne?id=1
//    @GetMapping("/clearOne")
//    public void clear(@RequestParam(name = "id")Long pId)
//    {
//        userService.clear(pId);
//    }
}