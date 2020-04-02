package guru.springframework.sfgpetclinic.repositories.map;

import java.util.Set;

import org.springframework.stereotype.Repository;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.OwnerMap;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.PetMap;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.PetTypeMap;

@Repository
public class OwnerMapRepository extends AbstractMapRepository<Owner, Long> implements OwnerMap {

    private final PetTypeMap petTypeMap;
    private final PetMap petMap;

    public OwnerMapRepository(PetTypeMap petTypeMap, PetMap petMap) {
		super();
		this.petTypeMap = petTypeMap;
		this.petMap = petMap;
	}

	@Override
    public Owner findByLastName(String lastName) {
    	Set<Owner> owners = this.findAll();
    	for (Owner owner : owners) {
			if(owner.getLastName().equalsIgnoreCase(lastName)) {
				return owner;
			}
		}
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() != null){
                            pet.setPetType(this.petTypeMap.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petMap.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

}
