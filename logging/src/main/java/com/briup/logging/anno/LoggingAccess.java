package com.briup.logging.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/19/2022-11-19-4:14 PM
 * @Description：com.briup.logging
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggingAccess {

}
