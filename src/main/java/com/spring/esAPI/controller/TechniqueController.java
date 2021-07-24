package com.spring.esAPI.controller;


import com.spring.esAPI.beans.TechniqueBean;
import com.spring.esAPI.business.GetTechniques;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TechniqueController {

    @Autowired
    GetTechniques getTechniques;

    @GetMapping("/techName/{techName}")
    public List<TechniqueBean> findTechniqueName(@PathVariable String techName){

        return getTechniques.findTechniqueName(techName);
    }
}
