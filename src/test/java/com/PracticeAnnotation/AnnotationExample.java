package com.PracticeAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Ilaf", comments = "Main method", date = "Aug 16 2020", revision = 1)
    public String toString(){
        return "Overridden toString Method";
    }

    @Deprecated
    @MethodInfo(comments = "Deprecated Method", date = "Aug 16 2020")
    public static void oldMethod(){
        System.out.println("Old Method.Don't use it!");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationExample.class.getMethods()){
                if (method.isAnnotationPresent(MethodInfo.class)){
                    try {
                        //iterate all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()){
                            System.out.println("Annotation in Method '" + method + "' : " + anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1){
                            System.out.println("Method with revision no 1 = " + method);
                        }
                    }catch (Throwable ex){
                        ex.printStackTrace();
                    }
                }
            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
}
