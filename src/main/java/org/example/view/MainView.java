package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class MainView {

    private static MainView mainView;
    private ClientView clientView;
    private HotelView hotelView;
    private StaffView staffView;
    private TicketView ticketView;

    public MainView() {
        clientView = new ClientView();
        hotelView = new HotelView();
        staffView = new StaffView();
        ticketView = new TicketView();
    }

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию для операции: ");
            System.out.println("Введите число : ");
            System.out.println("1. Клиент");
            System.out.println("2. Отель");
            System.out.println("3. Работники");
            System.out.println("4. Билет");
            System.out.println("5. Выход");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runClient();
                    break;
                case 2:
                    runHotel();
                    break;
                case 3:
                    runStaff();
                    break;
                case 4:
                    runTicket();
                    break;
                case 5:
                    go = false;
                    break;
                default:
                    System.out.println("Не верное число");
                    System.out.println("Введите числа от 1 до 4, пожалуйста");
            }
        }
    }

    private void runClient() throws SQLException {
        clientView.run();
    }

    private void runHotel() throws SQLException {
        hotelView.run();
    }

    private void runStaff() throws SQLException {
        staffView.run();
    }

    private void runTicket() throws SQLException {
        ticketView.run();
    }
}

