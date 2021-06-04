package org.example.view;

import org.example.controller.HotelController;
import org.example.entity.Hotel;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HotelView {

    private HotelController hotelController = new HotelController();

    public void showHotels() throws SQLException {
        List<Hotel> hotels = hotelController.getAllHotels();
        System.out.println("Список отелей: ");
        hotels.forEach(hotel -> System.out.println(hotel.toString()));
    }

    public void createHotel() {
        try {
            Hotel newHotel = new Hotel();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите название: ");
            String name = scanner.nextLine();
            newHotel.setName(name);

            System.out.println("Введите комфорт: ");
            String comfort = scanner.nextLine();
            newHotel.setComfort(comfort);

            System.out.println("Введите еду: ");
            String food = scanner.nextLine();
            newHotel.setFood(food);

            hotelController.saveHotel(newHotel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHotel() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id отеля, который хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        hotelController.deleteHotel(id);
    }

    public void updateHotel() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id отеля, который хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Hotel newHotel;
            newHotel = hotelController.getHotelById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newHotel.setName(name);

            System.out.println("Введите комфорт: ");
            String comfort = scanner.nextLine();
            newHotel.setComfort(comfort);

            System.out.println("Введите еду: ");
            String food = scanner.nextLine();
            newHotel.setFood(food);

            hotelController.editHotel(newHotel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByIdHotel() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id отеля который хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (hotelController.getHotelById(id) != null) {
                System.out.println(hotelController.getHotelById(id).toString());
            } else {
                System.out.println("Такого отеля не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdHotel();
        }
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать все отели");
            System.out.println(" 2. Добавить новый отель");
            System.out.println(" 3. Удалить отель ");
            System.out.println(" 4. Обновить информацию об отеле  ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showHotels();
                    break;
                case 2:
                    createHotel();
                    break;
                case 3:
                    deleteHotel();
                    break;
                case 4:
                    updateHotel();
                    break;
                case 5:
                    getByIdHotel();
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
