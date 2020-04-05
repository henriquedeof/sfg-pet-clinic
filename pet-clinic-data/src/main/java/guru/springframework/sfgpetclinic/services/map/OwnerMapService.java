package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.OwnerMap;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService implements OwnerService {

	private final OwnerMap ownerMap;
//	private final PetTypeMap petTypeMap;
//	private final PetMap petMap;


	@Override
	public Owner findByLastName(String lastName) {
		return this.ownerMap.findByLastName(lastName);
	}

	public OwnerMapService(OwnerMap ownerMap) {
		super();
		this.ownerMap = ownerMap;
	}

	@Override
	public Set<Owner> findAll() {
		return this.ownerMap.findAll();
		//return super.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.ownerMap.deleteById(id);
		//super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		this.ownerMap.delete(object);
		//super.delete(object);
	}

	@Override
	public Owner save(Owner object) {
		return this.ownerMap.save(object);
		//        if (object != null){
		//            if(object.getPets() != null){
		//                object.getPets().forEach(pet -> {
		//                    if(pet.getPetType() != null){
		//                        if(pet.getPetType().getId() != null){
		//                            pet.setPetType(this.petTypeMap.save(pet.getPetType()));
		//                        }
		//                    }else{
		//                        throw new RuntimeException("Per is required");
		//                    }
		//                    if(pet.getId() == null){
		//                        Pet savedPet = petMap.save(pet);
		//                        pet.setId(savedPet.getId());
		//                    }
		//                });
		//            }
		//            return this.ownerMap.save(object);
		//        }else{
		//            return null;
		//        }
	}

	@Override
	public Owner findById(Long id) {
		return this.ownerMap.findById(id);
	}

}
