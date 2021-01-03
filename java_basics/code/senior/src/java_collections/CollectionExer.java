package java_collections;

import org.junit.Test;

import java.util.*;




class Student implements Comparable{
    private String name;
    private double score;
    private int id;

    public Student(String name, double score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student){
            Student st = (Student) o;
            Double ds = this.score;
            Double ods =st.score;
            return -ds.compareTo(ods);
        }
        throw new RuntimeException("类型不匹配！");
    }
}









/**
 * @Auther: ccl
 * @Date: 2020/12/21 22:29
 * @Description:
 */
public class CollectionExer {

    /**
     * 3. 姓氏统计： 一个文件存储名字，其格式如下：
     *  王 二
     *  李 四
     *  张 三
     *  刘保罗
     *  ...
     *  现统计这份文件中所有姓氏出现的次数。
     *  解决方法：使用Map，将姓氏作为key，次数作为value。利用Map的put时，改变Value不改变key的特性。还需要以IO流读取文件。
     */
    
    /**
     * 1.2请把学生名与考试分数录入到集合中，并按分数显示前三名
     * 成绩学员的名字。
     * TreeSet(Student(name,score,id));
     */
    @Test
    public void test4(){
        Student st1 = new Student("AB",89,1001);
        Student st2 = new Student("das",83,1003);
        Student st3 = new Student("tea",50,1002);
        Student st4 = new Student("rea",80,1004);

        // 方式二：
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Student && o2 instanceof Student){
                    Student s1 = (Student)o1;
                    Student s2 = (Student)o2;
                    return -Double.compare(s1.getScore(),s2.getScore());
                }
                return 0;
            }
        };
        TreeSet treeSet = new TreeSet(com);
        // 方式一：
        // TreeSet treeSet = new TreeSet();
        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);

        Iterator iterator = treeSet.iterator();
        int i = 0;
        while(i < 3){
            System.out.println(iterator.next());
            i++;
        }


    }
    /**
     * 练习
     * 1.1.请从键盘随机输入10个整数保存到List中，并按倒序、从大
     * 到小的顺序显示出来
     */
    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        // for (int i = 0; i < 10; i++) {
        //     System.out.println("请输入第"+i+"个整数：");
        //     int num = scanner.nextInt();
        //     System.out.println(num);
        //     list.add(num);
        // }
        list.add(1);
        list.add(12);
        list.add(3);
        list.add(4);
        list.add(21);
        list.add(31);
        list.add(22);
        list.add(13);
        // 从大到小排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                if(o1 instanceof  Integer && o2 instanceof Integer){
                    Integer i1 = (Integer)o1;
                    Integer i2 = (Integer)o2;
                    return -i1.compareTo(i2);
                }else {
                    throw new RuntimeException("匹配的类型不一样！");
                }
            }
        });
        System.out.println(list.toString());
    }
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