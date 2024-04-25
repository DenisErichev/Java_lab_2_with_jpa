package org.example.interfaces.Organisation;


import org.example.performance.Organization;

public interface OrganisationService {
    void addOrganisation(Organization organization);
    void deleteOrganisation(long id);
    Organization findOrganisationById(long id);
    void update(long id);

}
