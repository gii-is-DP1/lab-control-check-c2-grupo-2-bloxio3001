package org.springframework.samples.petclinic.care;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "care_provisions")
public class CareProvision extends BaseEntity{   

    @Pattern(regexp = "^Care rated with [0-9] stars.*$")
    String userRating;
    
    @ManyToOne
    Visit visit;    

    @ManyToOne
    @NotNull
    Care care;   
}
