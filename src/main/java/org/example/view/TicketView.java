package org.example.view;

import org.example.controller.HotelController;
import org.example.controller.TicketController;
import org.example.entity.Hotel;
import org.example.entity.Ticket;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TicketView {

    private TicketController ticketController = new TicketController();

    public void showTickets() throws SQLException {
        List<Ticket> tickets = ticketController.getAllTickets();
        System.out.println("Список билетов: ");
        tickets.forEach(ticket -> System.out.println(ticket.toString()));
    }

    public void createTicket() {
        try {
            Ticket newTicket = new Ticket();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите страну: ");
            String country = scanner.nextLine();
            newTicket.setCountry(country);

            System.out.println("Введите дату: ");
            String date = scanner.nextLine();
            newTicket.setDate(date);

            System.out.println("Введите тур: ");
            String tour = scanner.nextLine();
            newTicket.setTour(tour);

            System.out.println("Введите цену: ");
            String price = scanner.nextLine();
            newTicket.setPrice(price);

            ticketController.saveTicket(newTicket);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTicket() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id билета, который хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        ticketController.deleteTicket(id);
    }

    public void updateTicket() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id билета, который хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Ticket newTicket;
            newTicket = ticketController.getTicketById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите страну: ");
            String country = scanner.nextLine();
            newTicket.setCountry(country);

            System.out.println("Введите дату: ");
            String date = scanner.nextLine();
            newTicket.setDate(date);

            System.out.println("Введите тур: ");
            String tour = scanner.nextLine();
            newTicket.setTour(tour);

            System.out.println("Введите цену: ");
            String price = scanner.nextLine();
            newTicket.setPrice(price);

            ticketController.editTicket(newTicket);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByIdTicket() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id билета который хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (ticketController.getTicketById(id) != null) {
                System.out.println(ticketController.getTicketById(id).toString());
            } else {
                System.out.println("Такого билета не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdTicket();
        }
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать все билеты ");
            System.out.println(" 2. Добавить новый билет ");
            System.out.println(" 3. Удалить билет ");
            System.out.println(" 4. Обновить информацию о билете ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showTickets();
                    break;
                case 2:
                    createTicket();
                    break;
                case 3:
                    deleteTicket();
                    break;
                case 4:
                    updateTicket();
                    break;
                case 5:
                    getByIdTicket();
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
