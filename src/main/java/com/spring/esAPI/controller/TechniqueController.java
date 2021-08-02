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

    @GetMapping("/techName/{techName}")
    public List<TechniqueBean> findTechniqueName(@PathVariable String techName){
        return getTechniques.findTechniqueName(techName);
    }
    @GetMapping("/techID/{techID}")
    public List<TechniqueBean> findTechniqueID(@PathVariable String techID){
        return getTechniques.findTechniqueID(techID);
    }

}
