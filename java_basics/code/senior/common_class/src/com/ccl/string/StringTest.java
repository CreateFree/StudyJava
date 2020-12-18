package com.ccl.string;

import org.junit.jupiter.api.Test;

/**
 * @Auther: ccl
 * @Date: 2020/12/15 16:53
 * @Description:
 */
public class StringTest {
    /*
        String:字符串，使用一对""引起来表示。
        1.String声明为final的，不可被继承
        2.String实现了Serializable接口：表示字符串是支持序列化的。
                实现了Comparable接口：表示String可以比较大小
        3.String内部定义了final char[] value用于存储字符串数据
        4.String:代表不可变的字符序列。简称：不可变性。
            体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
                 2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
                 3. 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
        5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。
        6.字符串常量池中是不会存储相同内容的字符串的。
    */
    @Test
    public void test1(){
        String s1 = "abc"; // 字面量定义方式


    }

    @Test
    public void test2(){
        // 通过字面量定义的方式：s1声明在方法区中的字符串常量池中。
        String s1 = "abc";
        // 通过new + 构造器的方式; s2保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String s2 = new String("abc");

        System.out.println(s1 == s2); // false

        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);
        // name的值还是地址，Tom值在方法区

    }

    /**
     *  1. 常量与常量拼接的结果在常量池。常量池中不会存在相同内容的常量。
     *  2. 拼接中，只有有一个变量，则结果在堆中。
     *  3. 只要调用intern()方法，返回值就在常量池中。
     */
    @Test
    public void test3(){
        String s1 ="abc";
        String s2 = "def";
        String s3 = "abcdef";
        String s4 = "abc"+"def";
        String s5 = s1 + "def";
        String s6 = s3.intern();
        String s7 = (s1+s2).intern();

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s5 == s6); // false
        System.out.println(s3 == s6); // true
        System.out.println(s3 == s7); // true
    }
}

class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


class StringMethodTest{
    @Test
    public void test(){
        String str = "acb123";
        char[] chars = str.toCharArray();
        System.out.println(chars);
    }
}