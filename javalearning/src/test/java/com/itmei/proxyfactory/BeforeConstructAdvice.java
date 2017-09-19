package com.itmei.proxyfactory;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by qiaodan on 2017/8/30.
 */
public class BeforeConstructAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] arguments, Object target) throws Throwable {

        if (method.getName().equals("construct")) {
            ((Construction) target).givePermission();
        }

    }
}
