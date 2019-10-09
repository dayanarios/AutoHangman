/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.autohangman;


import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author dayanarios
 */
public class Words {
    
    private static String secretWord = " "; 

     

    public static String getWord(){
        
        String word = " "; 
        
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/?random=true")
                    .header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
                    .header("x-rapidapi-key", "5f02dbb470mshafbf646db901715p1c9a72jsn03d7d25d6d94")
                    .asJson();
            
            JSONObject obj = response.getBody().getObject();
            word = obj.getString("word");
        } catch (UnirestException ex) {
            Logger.getLogger(Words.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return word; 
    }
    

    
    public static double getFrequency(){
        double freq = 0; 
        
                try {
            HttpResponse<JsonNode> response = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/apartment/frequency")
            .header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
            .header("x-rapidapi-key", "5f02dbb470mshafbf646db901715p1c9a72jsn03d7d25d6d94")
            .asJson();
            
            JSONObject obj = response.getBody().getObject();
            JSONObject freqHeading = obj.getJSONObject("frequency"); 
            freq = freqHeading.getDouble("zipf");

        } catch (UnirestException ex) {
            Logger.getLogger(Words.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return freq; 
        
    }

    
    
    
}
