package guru.springframework.sfgpetclinic.repositories.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long>{ //I could use JpaRepository

}
