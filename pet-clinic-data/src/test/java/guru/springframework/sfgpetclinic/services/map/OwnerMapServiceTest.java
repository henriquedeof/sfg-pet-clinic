package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.map.OwnerMapRepository;
import guru.springframework.sfgpetclinic.repositories.map.PetMapRepository;
import guru.springframework.sfgpetclinic.repositories.map.PetTypeMapRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {
        this.ownerMapService = new OwnerMapService(new OwnerMapRepository(new PetTypeMapRepository(), new PetMapRepository()));
        this.ownerMapService.save(Owner.builder().id(1L).lastName("Weston").build());
    }

    @Test
    void findByLastName() {
        Owner byLastName = this.ownerMapService.findByLastName("Weston");
        Assertions.assertEquals("Weston", byLastName.getLastName());
        Assertions.assertNotNull(byLastName);
    }

    @Test
    void findAll() {
        Set<Owner> owners = this.ownerMapService.findAll();
        Assertions.assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        this.ownerMapService.deleteById(1L);
        Assertions.assertEquals(null, this.ownerMapService.findById(1L));
        Assertions.assertEquals(0, this.ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        this.ownerMapService.delete(this.ownerMapService.findById(1L));
        Assertions.assertEquals(null, this.ownerMapService.findById(1L));
        Assertions.assertEquals(0, this.ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Owner owner = Owner.builder().id(2L).build();
        Owner ownerSaved = this.ownerMapService.save(owner);
        Assertions.assertEquals(2, ownerSaved.getId());
    }

    @Test
    void saveNoId() {
        Owner ownerSaved = this.ownerMapService.save(Owner.builder().build());
        Assertions.assertNotNull(ownerSaved);
        Assertions.assertNotNull(ownerSaved.getId());
    }

    @Test
    void findById() {
        Owner owner = this.ownerMapService.findById(1L);
        Assertions.assertEquals(1, owner.getId());
    }
}
