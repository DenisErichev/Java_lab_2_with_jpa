package org.example.interfaces.Department;

import org.example.performance.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {
    Department getDepartmentById(long id);
}
