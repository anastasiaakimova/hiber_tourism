package org.example.view;

import org.example.controller.StaffController;
import org.example.entity.Hotel;
import org.example.entity.Staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StaffView {
    private StaffController staffController = new StaffController();

    public void showStaff() throws SQLException {
        List<Staff> staff = staffController.getAllStaff();
        System.out.println("Список работников: ");
        staff.forEach(staff1 -> System.out.println(staff1.toString()));
    }

    public void createStaff() {
        try {
            Staff newStaff = new Staff();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newStaff.setName(name);

            System.out.println("Введите позицию: ");
            String position = scanner.nextLine();
            newStaff.setPosition(position);

            System.out.println("Введите телефон: ");
            String tel = scanner.nextLine();
            newStaff.setTel(tel);

            staffController.saveStaff(newStaff);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStaff() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id работника, которого хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        staffController.deleteStaff(id);
    }

    public void updateStaff() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id работника, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Staff newStaff;
            newStaff = staffController.getStaffById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newStaff.setName(name);

            System.out.println("Введите позицию: ");
            String position = scanner.nextLine();
            newStaff.setPosition(position);

            System.out.println("Введите телефон: ");
            String tel = scanner.nextLine();
            newStaff.setTel(tel);

            staffController.editStaff(newStaff);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByIdStaff() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id работника которого хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (staffController.getStaffById(id) != null) {
                System.out.println(staffController.getStaffById(id).toString());
            } else {
                System.out.println("Такого работника не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdStaff();
        }
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать всех работников ");
            System.out.println(" 2. Добавить нового работника ");
            System.out.println(" 3. Удалить работника ");
            System.out.println(" 4. Обновить информацию о работнике ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showStaff();
                    break;
                case 2:
                    createStaff();
                    break;
                case 3:
                    deleteStaff();
                    break;
                case 4:
                    updateStaff();
                    break;
                case 5:
                    getByIdStaff();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Неверное число!");
                    System.out.println("Введите число от 1 до 6, пожалуйста");
            }
        }
    }
}
