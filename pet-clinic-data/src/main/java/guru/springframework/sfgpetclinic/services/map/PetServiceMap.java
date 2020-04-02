package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.PetMap;
import guru.springframework.sfgpetclinic.services.PetService;

@Service
public class PetServiceMap implements PetService {
	
	private final PetMap petMap;
	
    public PetServiceMap(PetMap petMap) {
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
