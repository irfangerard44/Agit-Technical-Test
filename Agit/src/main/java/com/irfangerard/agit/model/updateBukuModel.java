package com.irfangerard.agit.model;

import lombok.Data;

@Data
public class updateBukuModel extends  createBookModel{
    private int status;
    private String ID_BOOK;
}
