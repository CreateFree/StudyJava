package generic.exec;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ccl
 * @Date: 2021/1/6 23:22
 * @Description:
 */
public class DAOTest {
    @Test
    public void daoTest() {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001", new User(1001, 10, "haha"));
        userDAO.save("1002", new User(1002, 12, "aa"));
        userDAO.save("1003", new User(1003, 13, "ha"));

        User user = userDAO.get("1003");
        System.out.println(user);
        System.out.println("*****************");

        userDAO.update("1002", new User(1005, 15, "lij"));
        Map<String, User> map = userDAO.map;
        for (User u : map.values()) {
            System.out.println(u);
        }
        System.out.println("*****************");

        List<User> list = userDAO.list();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("*****************");

        userDAO.delete("1002");
        for (User u : map.values()) {
            System.out.println(u);
        }

    }
}
