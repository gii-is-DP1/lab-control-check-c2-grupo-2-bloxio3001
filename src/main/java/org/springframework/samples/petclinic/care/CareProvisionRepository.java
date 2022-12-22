package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

public interface CareProvisionRepository{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);
	//List<Care> findAllCares();
    //List<Care> findCompatibleCares(PetType petType, Care additionalCare);
    //Care findCareByName(String name);
    //List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
    //Page<CareProvision> findAllPaginatedCareProvisions(Pageable p);
}
