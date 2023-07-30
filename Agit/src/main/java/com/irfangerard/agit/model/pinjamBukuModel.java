package com.irfangerard.agit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class pinjamBukuModel {

    private String ID_BOOK;
    private String peminjam;
    @Schema(description = "tanggal_pinjam ",example = "29 07 2023")
    private String tanggal_pinjam;
    @Schema(description = "tanggal_kembali ",example = "29 07 2023")
    private String tanggal_kembali;
}
