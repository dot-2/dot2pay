package com.dot2.api;

import com.dot2.entity.User;
import com.dot2.exception.NotFoundException;
import com.dot2.exception.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    /***
     *
     * @param id 参数描述信息
     * @return
     */
    @GetMapping("/exists")
    @ApiOperation(value = "获取存在的用户", notes = "获取存在的用户1")
    public Object getUser(String id) {
        return new User("1111111111", "admin", "123456");
    }

    @GetMapping("/not_exists")
    @ApiOperation(value = "获取存在的用户", notes = "获取存在的用户1")
    public Object getUser1() throws NotFoundException {
        throw new NotFoundException("用户不存在", Result.ErrorCode.UserNotFound);
    }
}