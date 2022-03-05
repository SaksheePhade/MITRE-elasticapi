package com.spring.esAPI.controller;


import com.spring.esAPI.beans.TechniqueBean;
import com.spring.esAPI.business.GetTechniques;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping

public class TechniqueController {

    @Autowired
    GetTechniques getTechniques;
    /*Lists technique info on search by techniquename*/
    @GetMapping("/techName/{techName}")
    public List<TechniqueBean> findTechniqueName(@PathVariable String techName){
        return getTechniques.findTechniqueName(techName);
    }
    /*Gives technique info on search by technique ID*/
    @GetMapping("/techID/{techID}")
    public List<TechniqueBean> findTechniqueID(@PathVariable String techID){
        return getTechniques.findTechniqueID(techID);
    }
    /*Lists technique info on search by tactic name*/
    @GetMapping("/techTactic/{techTactic}")
    public List<TechniqueBean> findTechniqueTactic(@PathVariable String techTactic){
        return getTechniques.findTechniqueTactic(techTactic);
    }
    /*Lists technique info on search by its Subtechnique*/
    @GetMapping("/techSubtechnique/{techSubtechnique}")
    public List<TechniqueBean> findTechniqueSubtechnique(@PathVariable String techSubtechnique){
        return getTechniques.findTechniqueSubtechnique(techSubtechnique);
    }
    /*Lists technique info of which it is a subtechnique*/
    @GetMapping("/techSubtechniqueOf/{techSubtechniqueOf}")
    public List<TechniqueBean> findTechniqueSubtechniqueOf(@PathVariable String techSubtechniqueOf){
        return getTechniques.findTechniqueSubtechniqueOf(techSubtechniqueOf);
    }
    /*Lists technique info on search by all above fields*/
    @GetMapping("/techAll/{techAll}")
    public List<TechniqueBean>findTechniqueAll(@PathVariable String techAll){
        return getTechniques.findTechniqueAll(techAll);
    }
}
