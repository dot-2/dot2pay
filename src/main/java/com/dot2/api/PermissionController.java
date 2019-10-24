package com.dot2.api;

import com.dot2.entity.Permission;
import com.dot2.exception.ParameterException;
import com.dot2.srv.PermissionSrv;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/permissions")
public class PermissionController {
    private static Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    PermissionSrv permissionSrv;

    @ApiOperation(value = "添加权限", notes = "添加权限")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object add(Permission permission) throws ParameterException {
        try {
            return permissionSrv.add(permission);
        } catch (DataIntegrityViolationException e) {
            throw new ParameterException("已存在同样的权限信息，请检查。");
        }
    }

    @ApiOperation(value = "获取权限列表", notes = "获取权限列表")
    @GetMapping
    public Object list() {
        return permissionSrv.list();
    }

}
