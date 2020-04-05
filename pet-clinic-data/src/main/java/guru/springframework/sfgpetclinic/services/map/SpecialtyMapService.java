package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.SpecialtyMap;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyMapService implements SpecialtyService {
	
	private final SpecialtyMap specialMap;

    public SpecialtyMapService(SpecialtyMap specialMap) {
		super();
		this.specialMap = specialMap;
	}

	@Override
    public Set<Speciality> findAll() {
        return this.specialMap.findAll();
    }

    @Override
    public void deleteById(Long id) {
    	this.specialMap.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
    	this.specialMap.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return this.specialMap.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return this.specialMap.findById(id);
    }
}
