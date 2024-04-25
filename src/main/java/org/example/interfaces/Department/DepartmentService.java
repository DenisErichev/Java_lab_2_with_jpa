package org.example.interfaces.Department;

import org.example.performance.Department;

import java.util.Optional;

public interface DepartmentService {
    void addDepartment(Department department);
    void deleteDepartment(long id);
    Department getDepartmentById(long id);
    void update(long id);
}
