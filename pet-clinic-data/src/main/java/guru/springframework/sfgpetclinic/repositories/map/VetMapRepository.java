package guru.springframework.sfgpetclinic.repositories.map;

import java.util.Set;

import org.springframework.stereotype.Repository;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.SpecialtyMap;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.VetMap;

@Repository
public class VetMapRepository extends AbstractMapRepository<Vet, Long> implements VetMap {

    private final SpecialtyMap specialtyMap;

    public VetMapRepository(SpecialtyMap specialtyMap) {
		super();
		this.specialtyMap = specialtyMap;
	}

	@Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
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

            return super.save(object);
        }

        return null;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
