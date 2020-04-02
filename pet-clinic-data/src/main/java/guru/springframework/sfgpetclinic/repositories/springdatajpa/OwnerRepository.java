package guru.springframework.sfgpetclinic.repositories.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long>{ //I could use JpaRepository
	 public Owner findByLastName(String lastName);
}
