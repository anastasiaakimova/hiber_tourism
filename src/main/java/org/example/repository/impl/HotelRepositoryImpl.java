package org.example.repository.impl;

import org.example.entity.Client;
import org.example.entity.Hotel;
import org.example.repository.JRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class HotelRepositoryImpl implements JRepo<Hotel, Long> {

    private Session session;
    private Transaction transaction;

    @Override
    public void add(Hotel hotel) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(hotel);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Hotel> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Hotel ";
        List<Hotel> hotels = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return hotels;
    }

    @Override
    public Hotel getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Hotel hotel = session.get(Hotel.class, id);
        transaction.commit();
        session.close();
        return hotel;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Hotel hotel = session.get(Hotel.class, id);
        session.remove(hotel);
        transaction.commit();
        session.close();
    }

    @Override
    public Hotel update(Hotel hotel) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(hotel);
        transaction.commit();
        session.close();
        return hotel;
    }
}
