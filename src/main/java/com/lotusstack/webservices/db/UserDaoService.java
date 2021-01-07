package com.lotusstack.webservices.db;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Service
public class UserDaoService {

    private static ArrayList<User> users = new ArrayList<>();
    private static Integer usersCount = 3;

    static {
        User user1 = new User(1, "Ram", new Date());
        users.add(user1);
        User adam = new User(2, "Adam", new Date());
        users.add(adam);
        User m = new User(3, "m", new Date());
        users.add(m);
    }

    public static ArrayList<User> getAll() {
        return users;
    }

    public static User getUserByID(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
        return null;
    }
}
