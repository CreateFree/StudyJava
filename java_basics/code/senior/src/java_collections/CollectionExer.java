package java_collections;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: ccl
 * @Date: 2020/12/21 22:29
 * @Description:
 */
public class CollectionExer {
    /*
     创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：TreeSet 需使用泛型来定义）
     分别按以下两种方式对集合中的元素进行排序，并遍历输出：

     1). 使Employee 实现 Comparable 接口，并按 name 排序
     2). 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
     */

    /**
     * 问题二：定制排序Comparator
     */
    @Test
    public void test2() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate d1 = e1.getBirthday();
                    MyDate d2 = e2.getBirthday();

                    // 方式二，MyDate 实现 Comparable 接口：
                    return d1.compareTo(d2);

                    // 方式一：
                    // int minYear = d1.getYear() - d2.getYear();
                    // if (minYear != 0) {
                    //     return minYear;
                    // }
                    // int minMonth = d1.getMonth() - d2.getMonth();
                    // if (minMonth != 0) {
                    //     return minMonth;
                    // }
                    // return d1.getDay() - d2.getDay();
                } else {
                    throw new RuntimeException("类型不匹配");
                }
            }
        };

        TreeSet ts = new TreeSet(comparator);

        Employee em1 = new Employee("Tom", 1, new MyDate(1985, 12, 1));
        Employee em2 = new Employee("Jerry", 5, new MyDate(1985, 6, 1));
        Employee em3 = new Employee("Bob", 3, new MyDate(1987, 7, 1));
        Employee em4 = new Employee("Aerobic", 6, new MyDate(1984, 8, 1));
        Employee em5 = new Employee("Money", 7, new MyDate(1983, 10, 1));


        ts.add(em1);
        ts.add(em2);
        ts.add(em3);
        ts.add(em4);
        ts.add(em5);

        Iterator iterator = ts.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 问题一： 自然排序解决
     */
    @Test
    public void test() {
        TreeSet ts = new TreeSet();

        Employee em1 = new Employee("Tom", 1, new MyDate(1991, 12, 1));
        Employee em2 = new Employee("Jerry", 5, new MyDate(1985, 6, 1));
        Employee em3 = new Employee("Bob", 3, new MyDate(1987, 7, 1));
        Employee em4 = new Employee("Aerobic", 6, new MyDate(1984, 8, 1));
        Employee em5 = new Employee("Money", 7, new MyDate(1983, 10, 1));

        ts.add(em1);
        ts.add(em2);
        ts.add(em3);
        ts.add(em4);
        ts.add(em5);

        Iterator iterator = ts.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

/**
 * 定义一个Employee类。
 * 该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 */
class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee() {
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        } else {
            throw new RuntimeException("类型不匹配");
        }
    }
}

/**
 * MyDate类包含:
 * private成员变量year,month,day；并为每一个属性定义 getter, setter 方法；
 */
class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate d = (MyDate) o;
            int minYear = this.getYear() - d.getYear();
            if (minYear != 0) {
                return minYear;
            }
            int minMonth = this.getMonth() - d.getMonth();
            if (minMonth != 0)
                return minMonth;
            return this.getDay() - d.getDay();
        }
        throw new RuntimeException("类型不匹配");
    }
}