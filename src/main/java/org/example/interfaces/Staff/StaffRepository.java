package org.example.interfaces.Staff;

import org.example.performance.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends CrudRepository<Staff,Long> {
    Staff getStaffById(long id);
}
