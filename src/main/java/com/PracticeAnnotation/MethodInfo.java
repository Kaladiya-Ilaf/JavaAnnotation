package com.PracticeAnnotation;

import java.lang.annotation.*;


/*
* @Documented - Whether to put the annotation in Java Docs
* @Retention - When the annotation is needed
* @Target? - Places the annotation can go
* @Inherited - Whether subclasses get the annotation
* */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Ilaf";
    String date();
    int revision() default 1;
    String comments();
}
