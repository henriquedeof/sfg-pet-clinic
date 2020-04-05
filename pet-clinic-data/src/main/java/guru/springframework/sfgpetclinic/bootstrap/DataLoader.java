package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.petTypeService.findAll().size() == 0){
            this.loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = this.petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = this.petTypeService.save(cat);

//        System.out.println("============== PetTypes saved ===============");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

//        System.out.println("============== Specialties saved ===============");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Street 1");
        owner1.setCity("Sydney");
        owner1.setTelephone("111111111");

        Pet mikesPet = new Pet();
        mikesPet.setName("Rosco");
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        this.ownerService.save(owner1);

        //---------

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");
        owner2.setAddress("123 Street 1");
        owner2.setCity("Sydney");
        owner2.setTelephone("111111111");

        Pet fionasCat = new Pet();
        fionasCat.setName("Cat name");
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setOwner(owner2);
        owner2.getPets().add(fionasCat);

        this.ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setDescription("Fionas kitty");
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(fionasCat);
        this.visitService.save(catVisit);

//        System.out.println("============== Owners saved ===============");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        //----------------

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

//        System.out.println("============== Vets saved ===============");
//        System.out.println("===========================================");
        System.out.println("========================== REPOSITORIOS ====================");
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Owner Repository <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        this.ownerService.findAll().forEach(pet -> {System.out.println("Owner Name: " + pet.getFirstName());});
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Vet Repository <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        this.vetService.findAll().forEach(pet -> {System.out.println("Vet Name: " + pet.getFirstName());});
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> PetType Repository <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        this.petTypeService.findAll().forEach(pet -> {System.out.println("PetType Name: " + pet.getName());});
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Specialty Repository <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        this.specialtyService.findAll().forEach(pet -> {System.out.println("Specialty description: " + pet.getDescription());});
        
        
        
    }

}
