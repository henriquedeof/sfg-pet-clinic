package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.common.CrudOperations;
import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudOperations<Owner, Long> {

    public Owner findByLastName(String lastName);

}
