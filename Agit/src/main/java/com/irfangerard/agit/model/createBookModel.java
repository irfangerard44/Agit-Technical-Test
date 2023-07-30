package com.irfangerard.agit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

//import java.sql.Date;

@Data
public class createBookModel {
    private String judul;
    private String pengarang;
    private String penerbit;
    @Schema(description = "tanngal_terbit ",example = "29 07 2023")
    private String tanggal_terbit;
    private String tebal_buku;
}
