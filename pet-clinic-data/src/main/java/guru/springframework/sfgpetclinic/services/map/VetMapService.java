package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.SpecialtyMap;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.VetMap;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService implements VetService {
	
	private final VetMap vetMap;
    private final SpecialtyMap specialtyMap;
    
    public VetMapService(VetMap vetMap, SpecialtyMap specialtyMap) {
		super();
		this.vetMap = vetMap;
		this.specialtyMap = specialtyMap;
	}

	@Override
    public Set<Vet> findAll() {
        return this.vetMap.findAll();
    }

    @Override
    public void deleteById(Long id) {
    	this.vetMap.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
    	this.vetMap.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if((object != null) && (object.getSpecialities().size() > 0)){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty = this.specialtyMap.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
            return this.vetMap.save(object);
        }

        return null;
    }

    @Override
    public Vet findById(Long id) {
        return this.vetMap.findById(id);
    }
}
