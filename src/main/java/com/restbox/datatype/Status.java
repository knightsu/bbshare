package com.restbox.datatype;

import java.io.Serializable;

public enum Status implements Serializable{

    OCCUPY("using"),
    IDLE("free"),
    DISCARD("old");

    private String status;

    Status(String status) {
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public static Status getStatusvalue(String status)
    {
        for(Status status1 : Status.values()){
            if(status1.getStatus().equals(status)) {
                return status1;
            }
        }
        return DISCARD;
    }
}
