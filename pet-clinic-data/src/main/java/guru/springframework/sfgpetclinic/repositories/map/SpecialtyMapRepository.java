package guru.springframework.sfgpetclinic.repositories.map;

import java.util.Set;

import org.springframework.stereotype.Repository;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.SpecialtyMap;

@Repository
public class SpecialtyMapRepository extends AbstractMapRepository<Speciality, Long> implements SpecialtyMap {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
