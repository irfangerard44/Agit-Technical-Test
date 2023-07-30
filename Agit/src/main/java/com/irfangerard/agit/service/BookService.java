package com.irfangerard.agit.service;

import com.irfangerard.agit.model.DAOBook;
import com.irfangerard.agit.model.createBookModel;
import com.irfangerard.agit.model.pinjamBukuModel;
import com.irfangerard.agit.model.updateBukuModel;

import java.text.ParseException;
import java.util.List;

public interface BookService {
    List<DAOBook> findBook(String status);

    boolean createBook(createBookModel cBM) throws ParseException;

    boolean updateBook(updateBukuModel cBM) throws ParseException;

    boolean pinjamBuku(pinjamBukuModel pM) throws ParseException;

    boolean deleteBook(String id);
}
