package org.example.ApplicationServices;

import org.example.interfaces.Department.DepartmentRepository;
import org.example.interfaces.Department.DepartmentService;
import org.example.performance.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    Scanner scanner = new Scanner(System.in);
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department getDepartmentById(long id) {
        return departmentRepository.getDepartmentById(id);
    }

    @Override
    public void update(long id) {
        System.out.println("Обновление информации об отделе.");
        Department department = departmentRepository.getDepartmentById(id);
        System.out.println("Введите название отдела: ");
        department.setName(scanner.next());
        scanner.nextLine();
        System.out.println("Введите количество сотрудников: ");
        department.setCountStaff(scanner.nextInt());
        System.out.println("Введите количество комнат: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите комнаты отдела: ");
        List<String> rooms = new ArrayList<>();
        for(int i=0;i<count;i++) {
            rooms.add(scanner.nextLine());
        }
        department.setRooms(rooms);

        departmentRepository.save(department);
    }

}
