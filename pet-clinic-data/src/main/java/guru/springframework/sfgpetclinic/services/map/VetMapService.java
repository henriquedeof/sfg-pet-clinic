package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.VetMap;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService implements VetService {
	
	private final VetMap vetMap;

    public VetMapService(VetMap vetMap) {
        this.vetMap = vetMap;
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
        return this.vetMap.save(object);

//        if((object != null) && (object.getSpecialities().size() > 0)){
//            object.getSpecialities().forEach(speciality -> {
//                if(speciality.getId() == null){
//                    Speciality savedSpecialty = this.specialtyMap.save(speciality);
//                    speciality.setId(savedSpecialty.getId());
//                }
//            });
//            return this.vetMap.save(object);
//        }
//        return null;
    }

    @Override
    public Vet findById(Long id) {
        return this.vetMap.findById(id);
    }
}
