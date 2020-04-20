package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.springdatajpa.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.springdatajpa.PetRepository;
import guru.springframework.sfgpetclinic.repositories.springdatajpa.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")//At this moment, I do not have an active profile (application.properties).
//So, this profile created does not match with anything, therefore, it will be skipped and the next implementation of OwnerService (OwnerServiceMap) will be executed.
public class OwnerSDJpaService implements OwnerService{
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	
	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}
	
	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<Owner>();
		this.ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		//return optional.isPresent() ? optional.get() : null;
		return this.ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		System.out.println("========================= SAVING OWNER - SPRING DATA =======================");
		return this.ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		this.ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		this.ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.ownerRepository.findByLastName(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		return this.ownerRepository.findAllByLastNameLike(lastName);
	}

}
