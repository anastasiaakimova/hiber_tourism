package org.example.controller;

import org.example.entity.Hotel;
import org.example.repository.JRepo;
import org.example.repository.impl.HotelRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class HotelController {
    private JRepo jRepo = new HotelRepositoryImpl();

    public Hotel getHotelById(Long id) throws SQLException {
        return (Hotel) jRepo.getById(id);
    }

    public Hotel editHotel(Hotel hotel) throws SQLException {
        return (Hotel) jRepo.update(hotel);
    }

    public List<Hotel> getAllHotels() throws SQLException {
        return jRepo.getAll();
    }

    public void saveHotel(Hotel hotel) throws SQLException {
        jRepo.add(hotel);
    }

    public void deleteHotel(Long id) throws SQLException {
        jRepo.remove(id);
    }

}