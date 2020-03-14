package guru.springframework.sfgpetclinic.interfaces;

import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    public Vet findById(Long id);
    public Vet save(Vet vet);
    Set<Vet> findAll();

}
