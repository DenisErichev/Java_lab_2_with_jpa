package org.example.ApplicationServices;

import org.example.interfaces.Staff.StaffRepository;
import org.example.interfaces.Staff.StaffService;
import org.example.performance.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Repository
public class StaffServiceImpl implements StaffService {
    Scanner scanner = new Scanner(System.in);
    @Autowired
    StaffRepository staffRepository;
    @Override
    public void addEmployee(Staff employee) {
        staffRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        staffRepository.deleteById(id);
    }
    @Override
    public Staff findById(long id) {
        return staffRepository.getStaffById(id);
    }

    @Override
    public void update(Long id) {
        Staff employee = findById(id);
        System.out.println("Введите ФИО сотрудника:");
        employee.setFullName(scanner.next());
        scanner.nextLine();
        System.out.println("Введите адрес проживания сотрудника:");
        employee.setAddress(scanner.nextLine());

        System.out.println("Введите количество отделов:");
        int countDepartments = scanner.nextInt();
        List<String> departments = new ArrayList<>();
        for(int i=0;i<countDepartments;i++) {
            departments.add(scanner.next());
        }
        scanner.nextLine();
        employee.setRooms(departments);
        System.out.println("Введите дату рождения сотрудника:");
        employee.setDateOfBirth(scanner.nextLine());

        System.out.println("Введите должность сотрудника:");
        employee.setPosition(scanner.nextLine());
        staffRepository.save(employee);
    }

}
