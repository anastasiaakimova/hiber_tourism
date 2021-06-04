package org.example.repository.impl;

import org.example.entity.Client;
import org.example.repository.JRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ClientRepositoryImpl implements JRepo <Client, Long> {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Client client) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Client> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Client";
        List<Client> clients = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return clients;
    }

    @Override
    public Client getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        transaction.commit();
        session.close();
        return client;
    }

    @Override
    public Client update(Client client) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(client);
        transaction.commit();
        session.close();
        return client;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.remove(client);
        transaction.commit();
        session.close();
    }
}