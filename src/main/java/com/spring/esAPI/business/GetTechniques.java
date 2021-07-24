package com.spring.esAPI.business;


import com.spring.esAPI.beans.TechniqueBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.esAPI.dao.TechniqueDao;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GetTechniques {
    @Autowired
    TechniqueDao techniqueDao;
    public List<TechniqueBean> findTechniqueName(String techniqueName){

        return techniqueDao.findTechniqueName(techniqueName);
    }


}
