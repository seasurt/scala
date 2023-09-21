package com.ddd.entitys;

import java.time.Month;

public class airline {
    private String airport;
    private String country;
    private Integer month;
    private Integer num;

    public String getAirport() {return airport;}

    public void setAirport(String airport) {this.airport = airport;}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) { this.num = num; }

}
