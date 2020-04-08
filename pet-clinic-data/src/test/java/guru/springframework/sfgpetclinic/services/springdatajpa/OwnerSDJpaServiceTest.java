package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.springdatajpa.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.springdatajpa.PetRepository;
import guru.springframework.sfgpetclinic.repositories.springdatajpa.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;
   static final String LAST_NAME = "Smith";

    @BeforeEach
    void setUp() {
        this.returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        //Creating a mock of my OwnerRepository with the value o the object returnOwner.
        //Aparentemente, pelo fato de metodo 'anyString()' ser executado, quando meu service chamar o metodo findByLastName do repository,
        //nao importa qual String de lastName seja informada, o resultado retornado sempre sera o do que eu criei no returnOwner.
        when(this.ownerRepository.findByLastName(anyString())).thenReturn(returnOwner);
        Owner smith = this.service.findByLastName("");//posso usar qualquer string pois a execucao metodo anyString() nao me deixa customizar minha busca

        assertEquals(LAST_NAME, smith.getLastName());
        verify(this.ownerRepository).findByLastName(anyString());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(this.ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> ownerSet = this.service.findAll();

        assertNotNull(ownerSet);
        assertEquals(2, ownerSet.size());
    }

    @Test
    void findById() {
        when(this.ownerRepository.findById(anyLong())).thenReturn(Optional.of(this.returnOwner));
        Owner owner = this.service.findById(1L);

        assertEquals(1, owner.getId());
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(this.ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = this.service.findById(1L);
        assertNull(owner);
    }

    @Test
    void save() {
        when(this.ownerRepository.save(any())).thenReturn(this.returnOwner);
        Owner owner = this.service.save(null);//I can put any information inside the save() method, as the ownerRepository.save() will always return this.returnOwner.

        assertNotNull(owner);
        assertEquals(1, owner.getId());
        verify(this.ownerRepository).save(any());
    }

    @Test
    void delete() {
        this.service.delete(this.returnOwner);

        //Under the covers, the method verify() is calling verify(this.ownerRepository, times(1))
        verify(this.ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        this.service.deleteById(1L);

        //Under the covers, the method verify() is calling verify(this.ownerRepository, times(1))
        verify(this.ownerRepository).deleteById(anyLong());
    }


}
