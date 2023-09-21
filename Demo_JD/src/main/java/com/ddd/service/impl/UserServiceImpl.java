package com.ddd.service.impl;

import com.ddd.dao.UserDao;
import com.ddd.entitys.*;
import com.ddd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;
    @Override
    public List<Age> getAge() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getAge();
    }
    @Override
    public List<north_america> getNorth_america() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getNorth_america();
    }
    @Override
    public List<europe> getEurope() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getEurope();
    }
    @Override
    public List<asia> getAsia() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getAsia();
    }
    @Override
    public List<africa> getAfrica() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getAfrica();
    }
    @Override
    public List<oceania> getOceania() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getOceania();
    }
    @Override
    public List<south_america> getSouth_america() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getSouth_america();
    }
    @Override
    public List<airport> getAirport() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getAirport();
    }
    @Override
    public List<getcounts> getGetcounts() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getGetcounts();
    }
    @Override
    public List<airline> getAirline() {
        //进行业务处理，没有业务时，此层代码也不允许省略
        return userDao.getAirline();
    }


}
