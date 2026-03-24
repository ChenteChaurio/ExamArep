/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eci.escuelaing.arep.parcialarep.controller;

import eci.escuelaing.arep.parcialarep.Service.MathService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vicente.garzon-r
 */
@RestController
@RequestMapping("/")
public class MathServicesController {
    private MathService mathservice;
    
    
    public MathServicesController(MathService mathservice){
        this.mathservice = mathservice;
    }
    
    @GetMapping()
    public List<Integer> SequenceLucas (@RequestParam int value) throws Exception{
        List<Integer>solve = new ArrayList<>();
        try{
            solve = mathservice.SecuenciaLucas(value);}
        catch(Exception e){
        }
        return solve;
    }
}
