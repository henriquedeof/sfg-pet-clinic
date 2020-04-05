package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.map.interfaces.VisitMap;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService implements VisitService {

    private final VisitMap visitMap;

    public VisitMapService(VisitMap visitMap) {
        this.visitMap = visitMap;
    }

    @Override
    public Set<Visit> findAll() {
        return this.visitMap.findAll();
    }

    @Override
    public void deleteById(Long id) {
    	this.visitMap.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
    	this.visitMap.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        return this.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return this.visitMap.findById(id);
    }
}
