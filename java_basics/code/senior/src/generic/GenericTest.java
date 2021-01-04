package generic;

import org.junit.Test;

import java.util.*;

/**
 * @Auther: ccl
 * @Date: 2021/1/4 22:03
 * @Description:
 */
public class GenericTest {

    // 1.在集合中使用泛型之前的情况
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        // 需求 存放成绩
        list.add(78);
        list.add(78);
        list.add(78);
        list.add(78);
        // 问题1，类型不安全
        list.add("Tom");

        for (Object score : list) {
            // 问题2，强转可能报错
            int sScore = (Integer) score;
            System.out.println(sScore);
        }
    }

    // 2.在集合中使用泛型解决之前的问题
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(88);
        list.add(88);
        list.add(88);
        // 解决问题1，声明的时Integer类型的list，不能添加String类型的
        // 编译时就会报错  保证数据安全
        // 基本数据类型不在泛型包含中，泛型还是面向对象在做
        // list.add("gsa");

        for (Integer score : list) {
            // 同时避免了强转
            int ss = score;
            System.out.println(ss);
        }
    }

    // HashMap
    @Test
    public void test3(){
        // Map<String, Integer> map = new HashMap<String,Integer>();
        // Jdk7.0新特性 类型推断，后面可以不用写泛型的内容了
        Map<String, Integer> map = new HashMap<>();

        map.put("123",21);
        map.put("123",21);
        map.put("123",21);

        // 编译时 报错
        // map.put(21,21);
        // map.put("dsa","dfa");

        // Map遍历 (先得到entry（set结构） 然后调用 迭代器iterator）
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " ---- " +value);
        }

    }
}


