package javaLearn.注解和反射.注解;

import java.lang.annotation.*;

//练习元注解
public class Test02 {
    @myAnnotation
    public void test01(){}
}
//Target 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.TYPE, ElementType.FIELD,ElementType.METHOD})

//Retention 表示我们的注解在什么时候生效
//Runtime>CLASS>Sources
@Retention(value = RetentionPolicy.RUNTIME)

//表示是否将我们的注解生成在JAVAdoc中
@Documented

//表示子类可以继承父类的注解
@Inherited

@interface myAnnotation{

}

