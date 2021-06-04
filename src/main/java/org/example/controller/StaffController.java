package org.example.controller;

import org.example.entity.Staff;
import org.example.repository.JRepo;
import org.example.repository.impl.StaffRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class StaffController {
    private JRepo jRepo = new StaffRepositoryImpl();

    public Staff getStaffById(Long id) throws SQLException {
        return (Staff) jRepo.getById(id);
    }

    public Staff editStaff(Staff staff) throws SQLException {
        return (Staff) jRepo.update(staff);
    }

    public List<Staff> getAllStaff() throws SQLException {
        return jRepo.getAll();
    }

    public void saveStaff(Staff staff) throws SQLException {
        jRepo.add(staff);
    }

    public void deleteStaff(Long id) throws SQLException {
        jRepo.remove(id);
    }
}
