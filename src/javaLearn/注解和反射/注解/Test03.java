package javaLearn.注解和反射.注解;

import java.lang.annotation.*;

//自定义注解
public class Test03 {
    @MyAnnotation01(value = 12,age = 12)
    public void test01(){

    }
}
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation01{
    int value();
    String name() default "name";
    int age();
        }
