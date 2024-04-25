package org.example.interfaces.Staff;

import org.example.performance.Staff;

import java.util.ArrayList;

public interface StaffService {
    void addEmployee(Staff employee);
    void delete(long id);
    Staff findById(long id);
    void update(Long id);
}
