package eci.escuelaing.arep.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProxy {
    String service1 = "http://ec2-54-197-196-91.compute-1.amazonaws.com:8080";  
    String service2 = "http://ec2-44-202-9-128.compute-1.amazonaws.com:8080";

    @CrossOrigin(origins = "*")
    @GetMapping("/lucasseq")
    public String Sequencuelucas(@RequestParam int value){
        String url1 = service1 + "/sequencuelucas?value=" + value;
        String url2 = service2 + "/sequencuelucas?value=" + value;
        

        try{
            return callURL(url1);
        }catch(Exception e){
            try {
                return callURL(url2);
            } catch (Exception eX) {
                return "Error todo rarito";
            }
        }
    }

        private String callURL(String urlString) throws Exception{
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }

    }

