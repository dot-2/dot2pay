package com.dot2.dot2pay.api;

import com.dot2.dot2pay.common.exception.NotFoundException;
import com.dot2.dot2pay.common.util.Util;
import com.dot2.dot2pay.model.bo.RequestPermission;
import com.dot2.dot2pay.model.po.Permission;
import com.dot2.dot2pay.common.exception.ParameterException;
import com.dot2.dot2pay.srv.PermissionSrv;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    public Permission add(@Valid RequestPermission permission, BindingResult result) throws ParameterException {
        try {
            Util.checkError(result);
            return permissionSrv.add(permission.toPermission());
        } catch (DataIntegrityViolationException e) {
            throw new ParameterException("已存在同样的权限信息，请检查。");
        }
    }

    @ApiOperation(value = "获取权限列表", notes = "获取权限列表")
    @GetMapping
    public List<Permission> list() {
        return permissionSrv.list();
    }

    @ApiOperation(value = "获取权限信息")
    @GetMapping("/{id}")
    public Permission get(
            @ApiParam(value = "权限id编号", required = true)
            @PathVariable Long id) throws NotFoundException {
        Permission p = permissionSrv.get(id);
        if (p == null) {
            throw new NotFoundException("该权限不存在");
        }
        return p;
    }

    @ApiOperation(value = "更新权限信息")
    @PutMapping("/{id}")
    public Permission put(RequestPermission permission, @PathVariable Long id) throws NotFoundException {
        Permission p = permission.toPermission();
        p.setId(id);
        p = permissionSrv.update(p);
        if (p == null) {
            throw new NotFoundException("该权限不存在");
        }
        return p;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@ApiParam(value = "权限编号", required = true) @PathVariable Long id) {
        permissionSrv.remove(id);
    }

}
