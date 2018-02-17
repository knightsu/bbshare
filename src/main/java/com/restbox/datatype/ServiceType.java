package com.restbox.datatype;

import java.io.Serializable;

public enum ServiceType implements Serializable{
    RENT("rent"),
    SELL("sell");

    private String serviceType;

    ServiceType(String serviceType)
    {
        this.serviceType=serviceType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public static ServiceType getServiceType(String serviceType)
    {
        for(ServiceType serviceType1 : ServiceType.values())
        {
            if(serviceType1.getServiceType().equals(serviceType))
            {
                return serviceType1;
            }
        }
        return RENT;
    }
}
