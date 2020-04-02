package guru.springframework.sfgpetclinic.repositories.map.interfaces;

import guru.springframework.sfgpetclinic.common.CrudOperations;
import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerMap extends CrudOperations<Owner, Long>{
	
	public Owner findByLastName(String lastName);
}
