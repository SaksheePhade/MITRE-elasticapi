package com.spring.esAPI.business;


import com.spring.esAPI.beans.TechniqueBean;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.esAPI.dao.TechniqueDao;
import org.springframework.stereotype.Service;
import java.util.List;

/*Business logic, collect all methods*/

@Service
public class GetTechniques {
    @Autowired
    TechniqueDao techniqueDao;
    /*Lists technique info on search by techniquename*/
    public List<TechniqueBean> findTechniqueName(String techniqueName){

        return techniqueDao.findTechniqueName(techniqueName);
    }
    /*Gives technique info on search by technique ID*/
    public List<TechniqueBean> findTechniqueID(String techniqueID){

        return techniqueDao.findTechniqueID(techniqueID);
    }
    /*Lists technique info on search by tactic name*/
    public List<TechniqueBean> findTechniqueTactic(String techniqueTactic){

        return techniqueDao.findTechniqueTactic(techniqueTactic);
    }
    /*Lists technique info on search by its Subtechnique*/
    public List<TechniqueBean> findTechniqueSubtechnique(String techniqueSubtechnique){

        return techniqueDao.findTechniqueSubtenchnique(techniqueSubtechnique);
    }
    /*Lists technique info of which it is a subtechnique*/
    public List<TechniqueBean> findTechniqueSubtechniqueOf(String techniqueSubtechniqueOf){

        return techniqueDao.findTechniqueSubtenchniqueOf(techniqueSubtechniqueOf);
    }
    
    /*Lists technique info on search by all above fields*/
    public List<TechniqueBean> findTechniqueAll(String techniqueAll){

        return techniqueDao.findTechniqueAll(techniqueAll);
    }

}
