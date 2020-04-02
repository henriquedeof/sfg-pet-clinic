package guru.springframework.sfgpetclinic.services;

import java.util.Set;

/**
 * Instead of using this interface, use CrudOperations<T, ID>, which centralized all the basic CRUD operations.
 * This inteface cannot be classified as Service or Repository.
 */
@Deprecated
public interface CrudService<T, ID> {

    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);

}
