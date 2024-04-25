package org.example.interfaces.Organisation;

import org.example.performance.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrganisationRepository extends CrudRepository<Organization,Long> {
    Organization getOrganizationById(long id);
}
