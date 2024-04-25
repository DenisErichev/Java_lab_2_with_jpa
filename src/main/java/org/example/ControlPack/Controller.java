package org.example.ControlPack;

import org.example.ApplicationServices.DepartmentServiceImpl;
import org.example.ApplicationServices.OrganizationServiceImpl;
import org.example.ApplicationServices.StaffServiceImpl;
import org.example.performance.Department;
import org.example.performance.Organization;
import org.example.performance.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@RestController
public class Controller {
    Scanner scanner = new Scanner(System.in);

    @Autowired
    private StaffServiceImpl staffService;
    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private OrganizationServiceImpl organizationService;
    @PostMapping
    public void addEmployee(Staff employee) {
        staffService.addEmployee(employee);
    }
    @GetMapping
    public Staff findEmployee(long id) {
        return staffService.findById(id);
    }
    @DeleteMapping
    public void deleteEmployee(long id) {
        staffService.delete(id);
    }

    //Отдел
    @PostMapping
    public void addDepartment(Department department) {
        Staff head = createHeadStaff();
        department.setHead(head);
        departmentService.addDepartment(department);
        addEmployee(head);
    }

    @GetMapping
    public Department getDepartmentById(long id) {
        return departmentService.getDepartmentById(id);
    }
    @DeleteMapping
    public void deleteDepartment(long id) {
        departmentService.deleteDepartment(id);
    }
    //Филиал
    @PostMapping
    public void addOrganization(Organization organization) {
        Staff head = createHeadStaff();
        organization.setHead(head);
        organizationService.addOrganisation(organization);
        addEmployee(head);
    }

    @GetMapping
    public Organization getOrganizationById(long id) {
        return organizationService.findOrganisationById(id);
    }
    @DeleteMapping
    public void deleteOrganization(long id) {
        organizationService.deleteOrganisation(id);
    }
    @PutMapping
    public void updateEmployee(Long id) {
        staffService.update(id);
    }
    @PutMapping
    public void updateOrganization(Long id) {
        organizationService.update(id);
    }
    @PutMapping
    public void updateDepartment(Long id) {
        departmentService.update(id);
    }
    public Staff createHeadStaff() {
        Staff head = new Staff();
        System.out.println("Введите ФИО начальника:");
        head.setFullName(scanner.next());
        scanner.nextLine();
        System.out.println("Введите адрес проживания начальника:");
        head.setAddress(scanner.nextLine());
        System.out.println("Введите количество отделов:");
        int countDepartments = scanner.nextInt();
        List<String> departments = new ArrayList<>();
        for(int i=0;i<countDepartments;i++) {
            departments.add(scanner.next());
        }
        head.setRooms(departments);
        scanner.nextLine();
        System.out.println("Введите дату рождения сотрудника:");
        head.setDateOfBirth(scanner.nextLine());
        System.out.println("Введите должность сотрудника:");
        head.setPosition(scanner.nextLine());
        return head;
    }
}
