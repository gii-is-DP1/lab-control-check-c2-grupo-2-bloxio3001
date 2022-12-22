package org.springframework.samples.petclinic.care;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.pet.Visit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CareService {    

    @Autowired
    CareProvisionRepository cpr;

    public List<Care> getAllCares(){
        return null;
    }
    
    public List<Care> getAllCompatibleCares(PetType petTypeName, Care additionalCareName){
        return cpr.findCompatibleCares(petTypeName, additionalCareName);
    }
    
    public Care getCare(String careName) {
        return cpr.findCareByName(careName);
    }
    
    @Transactional(rollbackFor)
    public CareProvision save(CareProvision p) throws NonCompatibleCaresException, UnfeasibleCareException {        
        Visit visit = p.getVisit();
        List<CareProvision> cares = getCaresProvidedInVisitById(visit.getId());
        if (cares.stream().map(CareProvision::getCare).map(Care::getIncompatibleCares).anyMatch(s->s.contains(p.getCare()))) throw new NonCompatibleCaresException();
        if (!p.getCare().getCompatiblePetTypes().contains(visit.getPet().getType())) throw new UnfeasibleCareException();
        return cpr.save(p);   
    }

    public List<CareProvision> getAllCaresProvided(){
        return cpr.findAll();
    }

    public List<CareProvision> getCaresProvidedInVisitById(Integer visitId){
        return cpr.findCaresProvidedByVisitId(visitId);

    }
 
    public Page<CareProvision> getPaginatedCareProvisions(Pageable pageable){
        return null;
    }

}
