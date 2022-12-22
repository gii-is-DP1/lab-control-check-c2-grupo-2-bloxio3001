package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Repository;

@Repository
public interface CareProvisionRepository extends CrudRepository<CareProvision, Long>{
    List<CareProvision> findAll();        
    Optional<CareProvision> findById(int id);
    CareProvision save(CareProvision p);

    @Query("SELECT c FROM Care c")
	List<Care> findAllCares();
    
    @Query("SELECT c FROM Care c")
    List<Care> findCompatibleCares(PetType petType, Care additionalCare);

    @Query("SELECT c FROM Care c WHERE c.name = ?1")
    Care findCareByName(String name);
    
    @Query("SELECT cp FROM CareProvision cp WHERE cp.visit.id = ?1")
    List<CareProvision> findCaresProvidedByVisitId(Integer visitId);
    //Page<CareProvision> findAllPaginatedCareProvisions(Pageable p);
}
