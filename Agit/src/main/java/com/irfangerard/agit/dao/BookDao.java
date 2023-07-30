package com.irfangerard.agit.dao;

import com.irfangerard.agit.model.DAOBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends CrudRepository<DAOBook, String> {

    List<DAOBook> findAllByStatus(int status);
    DAOBook findDAOBookByIdBook(String idbook);

}
