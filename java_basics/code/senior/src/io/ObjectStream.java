package io;

import org.junit.Test;

import java.io.*;

/**
 * @Auther: ccl
 * @Date: 2021/1/13 20:56
 * @Description:
 */
public class ObjectStream {
    /**
     * 序列化过程：将内存中的对象保存在磁盘中或者通过网络发送出去
     */

    @Test
    public void test1(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/io/osTest.bat"));
            oos.writeObject(new String("中文了不会斯大林附件"));
            oos.flush(); // 刷新一次 就写出
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 读取，反序列化
    @Test
    public  void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("src/io/osTest.bat"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 对象序列化 要求 对象必须是可以序列化的
 * 满足以下要求：
 * 1.对象类必须实现接口：Serializable
 * 2.对象类必须提供一个全局常量 serialVersionUID
 */
class Person implements Serializable{

    private static final float serialVersionUID  = 12332539464L; // 这个值随便写

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}