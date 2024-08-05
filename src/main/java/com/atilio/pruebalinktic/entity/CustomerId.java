package com.atilio.pruebalinktic.entity;

import java.io.Serializable;

public class CustomerId  implements Serializable {
    private String docName;
    private int docType;

    public CustomerId() {

    }

    public CustomerId(String docName, int docType) {
        this.docName = docName;
        this.docType = docType;
    }


}