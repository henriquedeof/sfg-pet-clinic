package guru.springframework.sfgpetclinic.repositories.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long>{ //I could use JpaRepository

	public Owner findByLastName(String lastName);

	public List<Owner> findAllByLastNameLike(String lastName);
}
