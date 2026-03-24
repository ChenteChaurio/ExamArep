package eci.escuelaing.arep.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author vicente.garzon-r
 */
@Service
public class MathService {
    
    public List<Integer> SecuenciaLucas(int value) throws Exception{
        ArrayList<Integer> solve = new ArrayList<>();
        if(value>1){
            int n = 2;
            int m = 1;
            int current = 0;
            solve.add(n);
            solve.add(m);
            for (int i = 0; i < value-1; i++) {
                current = n + m;
                solve.add(current);
                n = m;
                m = current;
            }
            return solve;
        }
        throw new Exception("Solo numeros mayores o iguales a 1");
    }
    
}

