package com.irfangerard.agit.model;

import lombok.Data;

@Data
public class MessageModel {
    private String message;
    private Boolean status;
    private Object data;
}
