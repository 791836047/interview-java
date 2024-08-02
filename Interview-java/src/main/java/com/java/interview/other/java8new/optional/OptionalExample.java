package com.java.interview.other.java8new.optional;

import java.util.Optional;

/**
 * orElseGet()的用法
 * orElseThrow()的用法
 * @author liaowenhui
 * @date 2023/8/10 14:09
 */
public class OptionalExample {
    public static void main(String[] args) {
        // 模拟从数据库中获取用户信息，这里假设返回值为 null
        User userFromDatabase = getUserFromDatabase();

        // 使用orElseGet()提供备选的默认用户信息
        User defaultUser = new User("Guest", "guest@example.com");
        User finalUser = Optional.ofNullable(userFromDatabase)
                .orElseGet(() -> defaultUser);

        System.out.println("Final User: " + finalUser);

        // 使用orElseThrow()抛出自定义异常
        try {
            User finalUser2 = Optional.ofNullable(userFromDatabase)
                    .orElseThrow(() -> new UserNotFoundException("User not found"));
            System.out.println("FinalUser2: " + finalUser2);
        } catch (UserNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static User getUserFromDatabase() {
        // 模拟从数据库中获取用户信息，这里返回 null
        return null;
    }
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}


