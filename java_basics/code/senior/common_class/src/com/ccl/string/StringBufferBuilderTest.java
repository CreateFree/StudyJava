package com.ccl.string;

import org.junit.jupiter.api.Test;

/**
 *
 * StringBuffer \ StringBuilder
 *
 * @Auther: ccl
 * @Date: 2020/12/15 21:33
 * @Description:
 */
public class StringBufferBuilderTest {
    /*
    String \ StringBuffer \ StringBuilder 的区别
    String : 不可变的字符串序列；底层使用char[]存储；
    StringBuffer ：可变的字符串序列；线程安全的，效率低；底层使用char[]存储；
    StringBuilder : 可变的字符串序列；JDK5.0新增，线程不安全，效率高；底层使用char[]存储；


     */
    @Test
    public void test1(){
        // 源码分析：
        String s1 = new String(); // 底层 char[] 的情况：new char[0];
        StringBuffer stringBuffer = new StringBuffer();  // new char[16]; 底层创建了一个16长度的字符数组
        StringBuilder stringBuilder = new StringBuilder(); // 同Buffer一样，只是Buffer是一个同步的syncharnized


    }
}
