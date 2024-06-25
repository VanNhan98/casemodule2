package manage;


import entity.Student;
import fileio.CSVUtils;

import java.util.*;

public class StudentManage implements IManage {
    private List<Student> studentList;

    public StudentManage() {
        studentList = CSVUtils.readStudent();
    }

    @Override
    public void showList() {
        for (Student student : this.studentList) {
            System.out.println(student.toString());
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter FullName: ");
        String name = scanner.nextLine();
        System.out.println("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Gpa: ");
        double gpa = Double.parseDouble(scanner.nextLine());
        Student student = new Student(name, age, address, gpa);
        this.studentList.add(student);
        // Đọc danh sách sinh viên hiện tại từ tập tin
        readFileStudent();
//         Thêm sinh viên mới vào danh sách
        this.studentList.add(student);

//         Ghi lại danh sách sinh viên mới vào tập tin
        writeFileStudent();
    }

    @Override
    public void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id want delete");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student sv : this.studentList) {
            if (sv.getId() == id) {
                this.studentList.remove(sv);
                break;
            }
        }
        writeFileStudent();
    }

    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id want update");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student sv : this.studentList) {
            if (sv.getId() == id) {
                System.out.println("Enter FullName: ");
                String name = scanner.nextLine();
                System.out.println("Enter Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Address: ");
                String address = scanner.nextLine();
                System.out.println("Enter Gpa: ");
                double gpa = Double.parseDouble(scanner.nextLine());
                sv.setFullName(name);
                sv.setAge(age);
                sv.setAddress(address);
                sv.setGpa(gpa);
                writeFileStudent();
            }
        }
    }

    public void searchStudentById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id want search");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student sv : this.studentList) {
            if (sv.getId() == id) {
                System.out.println(sv);
            }
        }
    }

    public void sortStudentByGPA() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGpa() > o2.getGpa()) {
                    return 1;
                }
                return -1;
            }
        });
        CSVUtils.writeStudent(this.studentList);
    }

    public void sortStudentByName() {

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFullName().compareToIgnoreCase(o2.getFullName());

            }
        });

        writeFileStudent();
    }

    public void readFileStudent() {
        this.studentList = CSVUtils.readStudent();
    }

    public void writeFileStudent() {
        CSVUtils.writeStudent(this.studentList);
    }
}