package guru.springframework.sfgpetclinic.repositories.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> { //I could use JpaRepository

}
