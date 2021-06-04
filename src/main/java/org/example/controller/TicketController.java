package org.example.controller;

import org.example.entity.Staff;
import org.example.entity.Ticket;
import org.example.repository.JRepo;
import org.example.repository.impl.StaffRepositoryImpl;
import org.example.repository.impl.TicketRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class TicketController {
    private JRepo jRepo = new TicketRepositoryImpl();

    public Ticket getTicketById(Long id) throws SQLException {
        return (Ticket) jRepo.getById(id);
    }

    public Ticket editTicket(Ticket ticket) throws SQLException {
        return (Ticket) jRepo.update(ticket);
    }

    public List<Ticket> getAllTickets() throws SQLException {
        return jRepo.getAll();
    }

    public void saveTicket(Ticket ticket) throws SQLException {
        jRepo.add(ticket);
    }

    public void deleteTicket(Long id) throws SQLException {
        jRepo.remove(id);
    }
}
