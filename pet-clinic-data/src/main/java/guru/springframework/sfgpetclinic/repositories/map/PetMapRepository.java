package guru.springframework.sfgpetclinic.repositories.map;

import java.util.Set;

import org.springframework.stereotype.Repository;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.PetMap;

@Repository
public class PetMapRepository extends AbstractMapRepository<Pet, Long> implements PetMap {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
