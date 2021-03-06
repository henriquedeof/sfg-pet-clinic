package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.PetMap;
import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetMapService implements PetService {
	
	private final PetMap petMap;
	
    public PetMapService(PetMap petMap) {
		super();
		this.petMap = petMap;
	}

	@Override
    public Set<Pet> findAll() {
        return this.petMap.findAll();
    }

    @Override
    public void deleteById(Long id) {
    	this.petMap.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
    	this.petMap.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return this.petMap.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return this.petMap.findById(id);
    }
}
