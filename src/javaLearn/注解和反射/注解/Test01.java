package javaLearn.注解和反射.注解;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test01 extends Object {


    //重写
    @Override
    public String toString() {
        return super.toString();
    }
    @Deprecated
    public void test(){
        System.out.println("test");
    }
    @SuppressWarnings("all")
    public void test01(){
        List list = new ArrayList<>();
    }
}
