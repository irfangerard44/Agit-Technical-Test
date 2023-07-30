package com.irfangerard.agit.service.Impls;

import com.irfangerard.agit.dao.BookDao;
import com.irfangerard.agit.dao.IncrementDAO;
import com.irfangerard.agit.model.DAOBook;
import com.irfangerard.agit.model.createBookModel;
import com.irfangerard.agit.model.pinjamBukuModel;
import com.irfangerard.agit.model.updateBukuModel;
import com.irfangerard.agit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class bookServiceImpls implements BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    IncrementDAO incDAO;

    SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
    @Override
    public List<DAOBook> findBook(String status) {
        if (status==null) {
            return (List<DAOBook>) bookDao.findAll();
        } else {
            return bookDao.findAllByStatus(Integer.valueOf(status));
        }
    }

    @Override
    public boolean createBook(createBookModel cBM) throws ParseException {
        String id = "A"+incDAO.get_key().get(0);
        System.out.println(id);
        if (bookDao.findDAOBookByIdBook(id) == null) {
            DAOBook savebook = new DAOBook();
            savebook.setIdBook(id);
            savebook.setJudul(cBM.getJudul());
            savebook.setPengarang(cBM.getPengarang());
            savebook.setPenerbit(cBM.getPenerbit());
            savebook.setTanggal_terbit(new Date(sdf.parse(cBM.getTanggal_terbit()).getTime()));
            savebook.setTebal_buku(cBM.getTebal_buku());
            savebook.setStatus(0);
            bookDao.save(savebook);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean updateBook(updateBukuModel cBM) throws ParseException {
        DAOBook book = bookDao.findDAOBookByIdBook(cBM.getID_BOOK());
        System.out.println(book);
        if (book != null) {
            book.setIdBook(cBM.getID_BOOK());
            book.setJudul(cBM.getJudul());
            book.setPengarang(cBM.getPengarang());
            book.setPenerbit(cBM.getPenerbit());
            book.setTanggal_terbit(new Date(sdf.parse(cBM.getTanggal_terbit()).getTime()));
            book.setTebal_buku(cBM.getTebal_buku());
            book.setStatus(cBM.getStatus());
            bookDao.save(book);
            return true;
        } else {
            return false;
        }
//        return false;
    }

    @Override
    public boolean pinjamBuku(pinjamBukuModel pM) throws ParseException {
        DAOBook book = bookDao.findDAOBookByIdBook(pM.getID_BOOK());
        if (book != null) {
            book.setPeminjam(pM.getPeminjam());
            book.setStatus(1);
            book.setTanggal_pinjam(new Date(sdf.parse(pM.getTanggal_pinjam()).getTime()));
            book.setTanggal_kembali(new Date(sdf.parse(pM.getTanggal_kembali()).getTime()));
            bookDao.save(book);
            return true;
        } else {
            return false;
        }
//        return false;
    }

    @Override
    public boolean deleteBook(String id){
        DAOBook book = bookDao.findDAOBookByIdBook(id);
        if (book != null) {
            bookDao.deleteById(id);
            book = bookDao.findDAOBookByIdBook(id);
            if(book == null){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
//        return false;
    }
}
