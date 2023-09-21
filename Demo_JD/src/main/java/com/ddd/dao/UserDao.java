package com.ddd.dao;

import com.ddd.entitys.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from Age")
    List<Age> getAge();
    @Select("select * from north_america")
    List<north_america> getNorth_america();
    @Select("select * from europe")
    List<europe> getEurope();
    @Select("select * from asia")
    List<asia> getAsia();
    @Select("select * from africa")
    List<africa> getAfrica();
    @Select("select * from oceania")
    List<oceania> getOceania();
    @Select("select * from south_america")
    List<south_america> getSouth_america();
    @Select("select * from airport")
    List<airport> getAirport();
    @Select("select * from getcounts")
    List<getcounts> getGetcounts();
    @Select("select * from airline")
    List<airline> getAirline();
}
