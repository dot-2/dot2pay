package com.dot2.dot2pay.model.bo;

import com.dot2.dot2pay.common.util.Util;
import com.dot2.dot2pay.model.po.Permission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "权限信息")
@Data
@AllArgsConstructor
public class RequestPermission {

    // 用于显示的名字
    @ApiModelProperty(value = "权限名称", required = true)
    @NotNull(message = "缺少字段 name")
    @NotBlank(message = "权限名称字段 name 不能为空")
    @Size(min = 1, max = 20, message = "权限名称长度在 1-20 个字符之间")
    private String name;

    // 用于判断的权限标识
    @ApiModelProperty(value = "权限标识", required = true)
    @NotNull(message = "缺少字段 mark")
    @NotBlank(message = "权限标识字段 mark 不能为空")
    @Size(min = 1, max = 20, message = "权限标识长度在 1-20 个字符之间")
    private String mark;

    // 排序编号
    @ApiModelProperty(value = "排序编号")
    private Integer sortId;

    @ApiModelProperty(value = "上级编号")
    private Long parentId;

    public Permission toPermission() {
        Permission p = new Permission();
        String[] ns = Util.getNullPropertyNames(this);
        BeanUtils.copyProperties(this, p, ns);
        return p;
    }
}
