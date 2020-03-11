package test.process;

/**
 * 多线程练习
 * 创建线程方法
 * 1，继承thread类
 */

public class ProcessTest01 extends Thread{
    @Override
    public void run() {
        for (int i =0;i<100;i++){
            System.out.println("coding");
        }
    }

    public static void main(String[] args) {
        ProcessTest01 p = new ProcessTest01();
        p.start();
        for (int i =0;i<100;i++){
            System.out.println("666");
        }    }
}
