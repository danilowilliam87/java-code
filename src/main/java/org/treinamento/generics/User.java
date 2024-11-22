package org.treinamento.generics;

import java.time.LocalDateTime;
import java.util.Objects;

public class User implements Comparable<User>{
    private String name;
    private LocalDateTime accessDate;

    public User(String name, LocalDateTime accessDate) {
        this.name = name;
        this.accessDate = accessDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(LocalDateTime accessDate) {
        this.accessDate = accessDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", accessDate=" + accessDate +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return this.getName().compareTo(o.getName());
    }
}
