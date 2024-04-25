package org.example.ApplicationServices;

import org.example.interfaces.Organisation.OrganisationRepository;
import org.example.interfaces.Organisation.OrganisationService;
import org.example.performance.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class OrganizationServiceImpl implements OrganisationService {
    Scanner scanner = new Scanner(System.in);
    @Autowired
    OrganisationRepository organisationRepository;
    @Override
    public void addOrganisation(Organization organization) {
        organisationRepository.save(organization);
    }

    @Override
    public void deleteOrganisation(long id) {
        organisationRepository.deleteById(id);
    }

    @Override
    public Organization findOrganisationById(long id) {
        return organisationRepository.getOrganizationById(id);
    }

    @Override
    public void update(long id) {
        System.out.println("Обновление информации о филиале.");
        Organization organization = findOrganisationById(id);
        System.out.println("Введите название филиала: ");
        organization.setName(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Введите адрес филиала: ");
        organization.setAddress(scanner.nextLine());
        scanner.nextLine();
        organisationRepository.save(organization);
    }
}
