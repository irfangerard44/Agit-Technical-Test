package com.irfangerard.agit.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "agit_book")
@Data
public class DAOBook {
    @Id @Column(length = 50, unique = true)
    private String idBook;
    @Column
    private String judul;
    @Column
    private String pengarang;
    @Column
    private String penerbit;
    @DateTimeFormat(pattern="dd MM yyyy")
    private Date tanggal_terbit;
    @Column
    private String tebal_buku;
    @Column()
    private int status;
    @Column
    private String peminjam;
    @DateTimeFormat(pattern="dd MM yyyy")
    private Date tanggal_pinjam;
    @DateTimeFormat(pattern="dd MM yyyy")
    private Date tanggal_kembali;

}
