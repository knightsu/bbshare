package com.restbox.datatype;

import java.io.Serializable;

public enum DocType implements Serializable {
    CONSUME("consume"),
    PROVIDER("provider");

    private String docType;

    DocType(String docType) {
        this.docType=docType;
    }

    public String getDocType() {
        return docType;
    }

    public static DocType getDocType(String docType) {
        for(DocType docType1 : DocType.values()) {
            if(docType1.getDocType().equals(docType)) {
                return docType1;
            }
        }
        return CONSUME;
    }
}
