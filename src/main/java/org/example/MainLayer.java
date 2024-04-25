package org.example;

import org.example.performance.Department;
import org.example.performance.Organization;
import org.example.performance.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.example.ControlPack.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component("mainLayer")
public class MainLayer {

    private Controller controller;
    private Scanner scanner = new Scanner(System.in);
    @Autowired
    public MainLayer(Controller controller) {
        this.controller = controller;
    }
    public MainLayer(){}
    public void work() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1) Добавить сотрудника");
            System.out.println("2) Найти сотрудника");
            System.out.println("3) Добавить отдел");
            System.out.println("4) Найти отдел");
            System.out.println("5) Добавить филиал");
            System.out.println("6) Найти филиал");
            System.out.println("7) Удалить сотрудника");
            System.out.println("8) Удалить отдел");
            System.out.println("9) Удалить филиал");
            System.out.println("10) Обновить информацию о сотруднике");
            System.out.println("11) Обновить информацию о филиале");
            System.out.println("12) Обновить информацию об отделе");
            System.out.println("13) Выход из программы");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    findEmployee();
                    break;
                case 3:
                    addDepartment();
                    break;
                case 4:
                    findDepartment();
                    break;
                case 5:
                   addOrganization();
                    break;
                case 6:
                    findOrganization();
                    break;
                case 7:
                    deleteEmployee();
                    break;
                case 8:
                    deleteDepartment();
                    break;
                case 9:
                    deleteOrganization();
                    break;
                case 10:
                    updateEmployee();
                    break;
                case 11:
                    updateOrganization();
                    break;
                case 12:
                    updateDepartment();
                    break;
                case 13:
                    System.out.println("Завершение работы.");
                    return;
                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }

    private void addEmployee() {
        Staff employee = new Staff();
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
        employee.setRooms(departments);
        scanner.nextLine();
        System.out.println("Введите дату рождения сотрудника:");
        employee.setDateOfBirth(scanner.nextLine());

        System.out.println("Введите должность сотрудника:");
        employee.setPosition(scanner.nextLine());

        controller.addEmployee(employee);
        System.out.println("Сотрудник успешно добавлен.");
    }
    private void findEmployee() {
        System.out.println("Введите Id сотрудника:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Staff existingEmployee = controller.findEmployee(id);
        if(existingEmployee == null) {
            System.out.println("Работник не найден!");
        }else {
            System.out.println("ФИО: " + existingEmployee.getFullName());
            System.out.println("Адрес: "+existingEmployee.getAddress());
            System.out.println("Дата рождения: "+existingEmployee.getDateOfBirth());
            System.out.println("Должность: "+existingEmployee.getPosition());
            System.out.println("Отделы: "+existingEmployee.getRooms());
        }
    }
    private void addDepartment() {
        Department department = new Department();
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


        controller.addDepartment(department);
    }

    private void findDepartment() {
        System.out.println("Введите id отдела: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Department department = controller.getDepartmentById(id);
        System.out.println("Начальник: "+department.getHead().getId());
        System.out.println("Название отдела: "+department.getName());
        System.out.println("Список комнат: "+department.getRooms());
        System.out.println("Количество сотрудников: "+department.getCountStaff());
    }
    private void addOrganization() {
        Organization organization = new Organization();
        System.out.println("Введите название филиала: ");
        organization.setName(scanner.next());
        scanner.nextLine();
        System.out.println("Введите адрес филиала: ");
        organization.setAddress(scanner.nextLine());
        scanner.nextLine();

        controller.addOrganization(organization);
    }
    private void findOrganization() {
        System.out.println("Введите id филиала: ");
        Long id = scanner.nextLong();
        Organization organization = controller.getOrganizationById(id);
        System.out.println("Начальник филиала: "+organization.getHead().getId());
        System.out.println("Филиал: "+organization.getName());
        System.out.println("Адрес: "+organization.getAddress());
    }
    private void deleteOrganization() {
        System.out.println("Введите id филиала для удаления: ");
        Long id = scanner.nextLong();
        controller.deleteOrganization(id);
    }

    private void deleteDepartment() {
        System.out.println("Введите id отдела для удаления: ");
        Long id = scanner.nextLong();
        controller.deleteDepartment(id);
    }

    private void deleteEmployee() {
        System.out.println("Введите id отдела для удаления: ");
        Long id = scanner.nextLong();
        controller.deleteEmployee(id);
    }
    private void updateEmployee() {
        System.out.println("Введите id сотрудника для обновления: ");
        Long id = scanner.nextLong();
        controller.updateEmployee(id);
    }
    private void updateOrganization() {
        System.out.println("Введите id филиала для обновления: ");
        Long id = scanner.nextLong();
        controller.updateOrganization(id);
    }
    private void updateDepartment() {
        System.out.println("Введите id отдела для обновления: ");
        Long id = scanner.nextLong();
        controller.updateDepartment(id);
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
        scanner.nextLine();
        System.out.println("Введите дату рождения сотрудника:");
        head.setDateOfBirth(scanner.nextLine());
        System.out.println("Введите должность сотрудника:");
        head.setPosition(scanner.nextLine());
        return head;
    }
}
