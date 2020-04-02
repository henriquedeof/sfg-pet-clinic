package guru.springframework.sfgpetclinic.common;

import java.util.Set;

public interface CrudOperations<T, ID> {

    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);

}
