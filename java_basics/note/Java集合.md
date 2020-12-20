# Java集合概述

 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。  
    此时的存储在内存中，没有持久化。
    
 2.数组的存储特点：  
    2.1 数组的长度一旦确定就不能改变
    2.2 是一组特定类型的值
    2.3 数组存储的数据是有序的，可以重复的
    
 3.Java 集合类可以用于存储数量不等的多个对象，还可用于保存具有映射关系的
   关联数组。
 
 
# Java集合框架
1.Collection 接口 单例数据，  
  1.1 List 接口 有序的，可重复的  
     ArrayList 、 LinkedList 、 Vector
  1.2 Set 接口 无序的，不可重复的  
     HashSet 、 LinkedSet 、 TreeSet
  
2.Map 接口  键值对 key-value 
    HashMap 、LinkedMap 、TreeMap 、 HashTable
    
3.每个接口的理解及源码分析

3.1 Collection

3.2 List

3.3 ArrayList\LinkedList\Vector

3.4 HashSet\LinkedSet\TreeSet

3.5 HashMap\LinkedMap\TreeMap\HashTable



 
# Collection 接口方法
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
 
 
#   

