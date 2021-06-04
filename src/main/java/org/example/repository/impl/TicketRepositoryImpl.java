package org.example.repository.impl;

import org.example.entity.Staff;
import org.example.entity.Ticket;
import org.example.repository.JRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class TicketRepositoryImpl implements JRepo<Ticket, Long> {

    private Session session;
    private Transaction transaction;

    @Override
    public void add(Ticket ticket) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(ticket);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Ticket> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Ticket ";
        List<Ticket> tickets = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return tickets;
    }

    @Override
    public Ticket getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        transaction.commit();
        session.close();
        return ticket;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        session.remove(ticket);
        transaction.commit();
        session.close();
    }

    @Override
    public Ticket update(Ticket ticket) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(ticket);
        transaction.commit();
        session.close();
        return ticket;
    }
}