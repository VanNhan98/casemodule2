
import manage.StudentManage;

import java.util.Scanner;

public class Menu {
    private final StudentManage studentManage = new StudentManage();

    public Menu() {

    }

    public void showMenu() {
        int choice = -1;
        do {
            System.out.println("Menu");
            System.out.println("1. Show");
            System.out.println("2. Add");
            System.out.println("3. Remove");
            System.out.println("4. Update");
            System.out.println("5. Search Student");
            System.out.println("6. Sort Student By GPA");
            System.out.println("7. Sort Student By Name");
            System.out.println("8. Write File");
            System.out.println("9 Read File");
            System.out.println("10. Exit");
            System.out.println("Enter your choice: ");
            System.out.println("-----------------------");
            choice = getChoice();
            handleChoice(choice);
        } while (choice != 10);

    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("-----List Student ------");
                menuShowList();
                break;
            case 2:
                menuAddStudent();
                break;
            case 3:
                menuDeleteStudent();
                break;
            case 4:
                menuUpdateStudent();
                break;
            case 5:
                menuSearchStudent();
                break;
            case 6:
                menuSortStudentByGPA();
                break;
            case 7:
                menuSortStudentByName();
                break;
            case 8:
                menuWriteFile();
                break;
            case 9:
                menuReadFile();
                break;
            case 10:

                break;
            default:
                System.out.println("invalid choice");
                break;
        }
    }


    private void menuShowList() {
        studentManage.showList();
    }

    private void menuAddStudent() {
        studentManage.addStudent();
    }

    private void menuDeleteStudent() {
        studentManage.deleteStudent();
    }

    private void menuUpdateStudent() {
        studentManage.updateStudent();
    }

    private void menuSearchStudent() {
        studentManage.searchStudentById();
    }

    private void menuSortStudentByGPA() {
        studentManage.sortStudentByGPA();
    }

    private void menuSortStudentByName() {
        studentManage.sortStudentByName();
    }


    private void menuReadFile() {
        studentManage.readFileStudent();
    }

    private void menuWriteFile() {
        studentManage.writeFileStudent();
    }


}