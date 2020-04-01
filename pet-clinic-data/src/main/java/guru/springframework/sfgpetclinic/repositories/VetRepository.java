package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<VetRepository, Long> { //I could use JpaRepository

}
