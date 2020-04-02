package guru.springframework.sfgpetclinic.repositories.map;

import java.util.Set;

import org.springframework.stereotype.Repository;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.PetTypeMap;

@Repository
public class PetTypeMapRepository extends AbstractMapRepository<PetType, Long> implements PetTypeMap {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

}
