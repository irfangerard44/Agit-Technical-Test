package com.irfangerard.agit.dao;

import com.irfangerard.agit.model.DAOIncrement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncrementDAO extends CrudRepository<DAOIncrement, Integer> {
    @Query("SELECT get_key()")
    List<String> get_key();


}
