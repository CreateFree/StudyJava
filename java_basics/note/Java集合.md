# 1. Java集合概述

 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。  
    　此时的存储在内存中，没有持久化。
    
 2.数组的存储特点：  
　2.1 数组的长度一旦确定就不能改变  
　2.2 是一组特定类型的值  
　2.3 数组存储的数据是有序的，可以重复的  
    
 3.Java 集合类可以用于存储数量不等的多个对象，还可用于保存具有映射关系的关联数组。
 
 
# 2. Java集合框架
1.Collection 接口 单例数据，  
  1.1 List 接口 有序的，可重复的  
   　ArrayList 、 LinkedList 、 Vector  
  1.2 Set 接口 无序的，不可重复的  
   　HashSet 、 LinkedSet 、 TreeSet
  
2.Map 接口  键值对 key-value  
  　HashMap 、LinkedMap 、TreeMap 、 HashTable
    
 
# 3. Collection 接口
3.1 结论：向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().

3.2 常用方法：  
    1、添加  
     add(Object obj)  
     addAll(Collection coll)  
    2、获取有效元素的个数  
     int size()  
    3、清空集合  
     void clear()  
    4、是否是空集合  
     boolean isEmpty()  
    5、是否包含某个元素  
     boolean contains(Object obj)：是通过元素的equals方法来判断是否是同一个对象  
     boolean containsAll(Collection c)：也是调用元素的equals方法来比较的。拿两个集合的元素挨个比较。  
    6、删除  
     boolean remove(Object obj) ：通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素  
     boolean removeAll(Collection coll)：取当前集合的差集    
    7、取两个集合的交集  
     boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c  
    8、集合是否相等  
     boolean equals(Object obj)  
    9、转成对象数组  
     Object[] toArray()  
    10、获取集合对象的哈希值  
     hashCode()  
    11、遍历  
     iterator()：返回迭代器对象，用于集合遍历

3.3 迭代器Iterator

 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和  next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
 * 默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()






# 4. List
存储特点：有序的，可重复的。
## 1.ArrayList
1.作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储。

2.源码分析
- 2.1 jdk7中  
    ArrayList list = new ArrayList();   //底层创建了长度是10的Object[]数组elementData  
    list.add(123);  //elementData[0] = new Integer(123);  
    ...  
    list.add(11);   //如果此次的添加导致底层elementData数组容量不够，则扩容。  
    默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。  

    结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)

- 2.2 jdk8中  
     ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没有创建长度为10的数组

     list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]  
     ...  
     后续的添加和扩容操作与jdk 7 无异。  

- 2.3   
    jdk7中的ArrayList的对象的创建类似于单例的饿汉式；  
    而jdk8中的ArrayList的对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。


## 2.LinkedList
1.对于频繁的插入、删除操作，使用此类效率比ArrayList高；底层使用双向链表存储。

2.源码分析  
    LinkedList list = new LinkedList();    //内部声明了Node类型的first和last属性，默认值为null。  
    list.add(123);  //将123封装到Node中，创建了Node对象。  
    其中，Node定义为：体现了LinkedList的双向链表的说法。
    
   Node：  
   
    private static class Node<E> {
         E item;
         Node<E> next;
         Node<E> prev;

         Node(Node<E> prev, E element, Node<E> next) {
         this.item = element;
         this.next = next;
         this.prev = prev;
         }
    }   
   

## 3.Vector
1. 作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储

2. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。
在扩容方面，默认扩容为原来的数组长度的2倍。

## 4.ArrayList\LinkedList\Vector 的区别
相同点：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据。

不同点：上面总结的。

# 5. Set
存储特点：无序的，不可重复的。
## 1.HashSet

## 2.LinkedSet

## 3.TreeSet



