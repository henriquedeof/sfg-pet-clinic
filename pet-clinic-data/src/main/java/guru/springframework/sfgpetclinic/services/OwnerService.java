package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.common.CrudOperations;
import guru.springframework.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudOperations<Owner, Long> {

    public Owner findByLastName(String lastName);

    public List<Owner> findAllByLastNameLike(String lastName);

}
