package com.dot2.dot2pay.api;

import com.dot2.dot2pay.common.util.Util;
import com.dot2.dot2pay.model.bo.RequestPermission;
import com.dot2.dot2pay.model.po.Permission;
import com.dot2.dot2pay.common.exception.ParameterException;
import com.dot2.dot2pay.srv.PermissionSrv;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping(value = "/permissions")
public class PermissionController {
    private static Logger logger = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    PermissionSrv permissionSrv;

    @ApiOperation(value = "添加权限", notes = "添加权限")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Object add(@Valid RequestPermission permission, BindingResult result) throws ParameterException {
        try {
            Util.checkError(result);
            return permissionSrv.add(permission.toPermission());
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
