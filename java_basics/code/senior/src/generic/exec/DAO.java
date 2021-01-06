package generic.exec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ccl
 * @Date: 2021/1/6 23:12
 * @Description:
 */
public class DAO<T> {
    Map<String, T> map = new HashMap<>();

    /**
     * 保存 T 类型的对象到 Map 成员变量中
     *
     * @param id
     * @param entity
     */
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    /**
     * 从 map 中获取 id 对应的对象
     *
     * @param id
     * @return
     */
    public T get(String id) {
        T t = map.get(id);
        return t;
    }

    /**
     * 替换 map 中 key 为 id 的内容, 改为 entity 对象
     *
     * @param id
     * @param entity
     */
    public void update(String id, T entity) {
        if (map.get(id) != null) {
            map.put(id, entity);  //这里有个坑，put进去虽然修改了值，但是遍历时默认修改的会先出来。
        }
    }

    /**
     * 返回 map 中存放的所有 T 对象
     *
     * @return
     */
    public List<T> list() {
        List<T> list = new ArrayList<>();
        for (T t : map.values()) {
            list.add(t);
        }
        return list;
    }

    /**
     * 删除指定 id 对象
     *
     * @param id
     */
    public void delete(String id) {
        map.remove(id);
    }

}
