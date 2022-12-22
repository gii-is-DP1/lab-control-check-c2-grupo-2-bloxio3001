package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cares")
public class Care extends BaseEntity{

    @NotNull
    @Column(unique=true)
    @Size(min=3,max=40)
    String name;

    @Min(1)
    @Max(120)
    int careDuration;

    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty
    @JoinTable(name="care_pet_types")
    Set<PetType> compatiblePetTypes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="incompatible_cares")
    Set<Care> incompatibleCares;
}
