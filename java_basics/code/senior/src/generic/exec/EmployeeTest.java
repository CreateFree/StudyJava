package generic.exec;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther: ccl
 * @Date: 2021/1/6 22:26
 * @Description:
 */
public class EmployeeTest {

    /**
     * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（TreeSet 需使用泛型
     * 来定义），
     * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
     * 1). 使 Employee 继承 Comparable 接口，并按 name 排序
     * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
     */
    @Test
    public void test(){
        Employee e1 = new Employee("王",30,new MyDate(6,24,1980));
        Employee e2 = new Employee("吴",28,new MyDate(6,24,1980));
        Employee e3 = new Employee("李",50,new MyDate(4,12,1960));
        Employee e4 = new Employee("陈",33,new MyDate(2,3,1977));
        Employee e5 = new Employee("刘",32,new MyDate(4,5,1978));

        TreeSet<Employee> set = new TreeSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        // 方式一：Employee 实现了 Comparable 接口
        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }
        System.out.println();
        System.out.println("**************************");
        // 方式二：创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate birthday = o1.getBirthday();
                MyDate birthday1 = o2.getBirthday();
                if(birthday.getYear()-birthday1.getYear()>0){
                    return 1;
                }
                if(birthday.getYear() - birthday1.getYear()<0){
                    return -1;
                }
                if(birthday.getMonth()-birthday1.getMonth()>0){
                    return 1;
                }
                if(birthday.getMonth()-birthday1.getMonth()<0){
                    return -1;
                }
                if(birthday.getDay()-birthday1.getDay()>0){
                    return 1;
                }
                if(birthday.getDay()-birthday1.getDay()<0){
                    return -1;
                }
                return 0;
            }
        };
        TreeSet<Employee> set1 = new TreeSet<>(comparator);
        set1.add(e1);
        set1.add(e2);
        set1.add(e3);
        set1.add(e4);
        set1.add(e5);
        Iterator<Employee> iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
