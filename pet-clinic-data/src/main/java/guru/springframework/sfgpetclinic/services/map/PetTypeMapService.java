package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.PetTypeMap;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService implements PetTypeService {
	
	private final PetTypeMap petTypeMap;

    public PetTypeMapService(PetTypeMap petTypeMap) {
		super();
		this.petTypeMap = petTypeMap;
	}

	@Override
    public Set<PetType> findAll() {
        return this.petTypeMap.findAll();
    }

    @Override
    public void deleteById(Long id) {
    	this.petTypeMap.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
    	this.petTypeMap.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return this.petTypeMap.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return this.petTypeMap.findById(id);
    }

}
