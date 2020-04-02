package guru.springframework.sfgpetclinic.repositories.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> { //I could use JpaRepository

}
