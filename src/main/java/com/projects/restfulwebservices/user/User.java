package com.projects.restfulwebservices.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="user_details")
public class User{
    @Id
    private long id;
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        return result;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public User(){

    }
    public User(long id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
