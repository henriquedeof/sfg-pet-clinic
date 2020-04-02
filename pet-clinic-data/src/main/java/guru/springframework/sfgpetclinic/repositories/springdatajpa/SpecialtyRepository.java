package guru.springframework.sfgpetclinic.repositories.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long>{ //I could use JpaRepository

}
