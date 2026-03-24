package eci.escuelaing.arep.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eci.escuelaing.arep.Service.MathService;

/**
 *
 * @author vicente.garzon-r
 */
@RestController
public class MathServiceController {
    private MathService mathservice;
    
    
    public MathServiceController(MathService mathservice){
        this.mathservice = mathservice;
    }
    
    @GetMapping("/sequencuelucas")
    public List<Integer> SequenceLucas (@RequestParam int value) throws Exception{
        List<Integer>solve = new ArrayList<>();
        try{
            solve = mathservice.SecuenciaLucas(value);}
        catch(Exception e){
        }
        return solve;
    }
}
