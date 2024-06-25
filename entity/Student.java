package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    static int nextId  = 0;
    private int id = 0;
    private String fullName;
    private int age;
    private String address;
    private double gpa;
    public Student() {

    }
    public Student(int id,String fullName, int age, String address, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.gpa = gpa;

    }
    public Student(String fullName, int age, String address, double gpa) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
        id = ++nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return id +
                ", " + fullName +
                ", "+ age +
                "," + address+
                ", " + gpa;
    }

}
