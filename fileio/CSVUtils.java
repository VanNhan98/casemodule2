package fileio;

import data.FilePath;
import entity.Student;
import manage.StudentManage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    private final StudentManage studentManage;

    public CSVUtils(StudentManage studentManage) {
        this.studentManage = studentManage;
    }


    public static List<Student> readStudent() {
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(FilePath.PATH_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found");
            }
            FileReader reader = new FileReader(file);
            BufferedReader buff = new BufferedReader(reader);
            String line;
//                studentManage.getStudentList().clear(); // Xóa danh sách hiện tại để tránh trùng lặp
            while ((line = buff.readLine()) != null && !line.isEmpty()) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String address = data[3];
                double gpa = Double.parseDouble(data[4]);
                Student student = new Student(id, name, age, address, gpa);
                students.add(student);
            }
            buff.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static void writeStudent(List<Student> students) {
        try {
            File file = new File(FilePath.PATH_FILE);
            FileWriter writer = new FileWriter(file); // Chế độ này sẽ ghi đè nội dung cũ
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Student student : students) {
                String line = student.getId() + "," + student.getFullName() + ","
                        + student.getAge() + ","
                        + student.getAddress() + ","
                        + student.getGpa();
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // Thêm dòng mới sau mỗi sinh viên
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
