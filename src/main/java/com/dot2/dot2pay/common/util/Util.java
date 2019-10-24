package com.dot2.dot2pay.common.util;


import com.dot2.dot2pay.common.exception.ParameterException;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.beans.FeatureDescriptor;
import java.util.Objects;
import java.util.stream.Stream;

public class Util
{
    /**
     * 获取对象的 NULL 字段，注意属性定义请将基本类型替换成引用类型，比如 int 替换成 Integer
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

    // 检查错误信息
    public static void checkError(BindingResult result) throws ParameterException {
        if (result.hasErrors()) {
            throw new ParameterException(Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }
    }
}
