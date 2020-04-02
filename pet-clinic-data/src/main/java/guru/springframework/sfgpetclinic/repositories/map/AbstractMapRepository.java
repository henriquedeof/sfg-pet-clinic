package guru.springframework.sfgpetclinic.repositories.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import guru.springframework.sfgpetclinic.common.CrudOperations;
import guru.springframework.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapRepository<T extends BaseEntity, ID extends Long> implements CrudOperations<T, ID>{

    protected Map<Long, T> map = new HashMap<>();
    
    @Override
    public Set<T> findAll() {
    	return new HashSet<>(map.values());
    }
    
    @Override
    public T findById(ID id) {
    	return map.get(id);
    }
    
    @Override
    public T save(T object) {
    	 if(object != null){
           if (object.getId() == null){
               object.setId(this.getNextId());
           }
           this.map.put(object.getId(), object);
       } else {
           throw new RuntimeException("Object cannot be null");
       }
       return object;
    }
    
    @Override
    public void delete(T object) {
    	this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
    
    @Override
    public void deleteById(ID id) {
    	this.map.remove(id);
    }
    
    private Long getNextId(){
        Long nextId = null;

        try {
            nextId = Collections.max(this.map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }

        return nextId;
    }

//    Set<T> findAll(){
//        return new HashSet<>(map.values());
//    }
//
//    T findById(ID id){
//        return map.get(id);
//    }
//
//    T save(T object){
//        if(object != null){
//            if (object.getId() == null){
//                object.setId(this.getNextId());
//            }
//            this.map.put(object.getId(), object);
//        } else {
//            throw new RuntimeException("Object cannot be null");
//        }
//        return object;
//    }
//
//    void delete(T object){
//        this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
//    }
//
//    void deleteById(ID id){
//        this.map.remove(id);
//    }

}
