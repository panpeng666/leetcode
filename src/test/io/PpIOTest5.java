package test.io;

import java.io.*;
import java.util.Date;

/**
 * 缓冲流练习,并与字节流进行数据对比
 */

public class PpIOTest5 {
    public static void main(String[] args) throws IOException {
        Long time1 = System.currentTimeMillis();
        System.out.println("开始执行缓存流复制新文件");
//        File a = new File("D:/缓存流.mp4");
        copyVideoFile("D:/美剧/爱，死亡与机器人第1季/爱，死亡与机器人.Love.Death.and.Robots.S01E17.中英字幕.WEB.1080P-人人影视.mp4","D:/缓存流.mp4");
        Long time2 = System.currentTimeMillis();
        System.out.println("执行时间为"+(time2-time1));
//        File b = new File("D:/字节流.mp4");
        copyFile("D:/美剧/爱，死亡与机器人第1季/爱，死亡与机器人.Love.Death.and.Robots.S01E17.中英字幕.WEB.1080P-人人影视.mp4","D:/字节流.mp4");
        Long time3 = System.currentTimeMillis();
        System.out.println("执行时间为"+(time3-time2));
    }

    public static void copyFile(String address1,String adderss2) throws IOException {
        File a = new File(adderss2);
        if (!a.exists()){
            a.createNewFile();
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
//        byte[] buffer = new  byte[1024];
        int temp = 0;
        try{
            fis = new FileInputStream(address1);
            fos = new FileOutputStream(adderss2,true);

            while ((temp=fis.read())!= -1){//read(byte[] b) 从该输入流读取最多 b.length个字节的数据为字节数组。
                fos.write(temp);//write(byte[] b) 将 b.length个字节从指定的字节数组写入此文件输出流。
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (fis!=null){fis.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if (fos != null){fos.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static  void copyVideoFile(String add1,String add2) throws IOException {
        File a = new File(add2);
        if (!a.exists()){
            a.createNewFile();
        }
        FileInputStream  fis ;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream(add1);
            fos = new FileOutputStream(add2);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int temp = 0;
            while ((temp=bis.read())!=-1){
                bos.write(temp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        }


    }

