/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.autohangman;

/**
 *
 * @author dayanarios
 */
public class Hangman {
    
    private static String secretWord; 
    private static Words wordAPI = new Words(); 
    
    public Hangman(){
        wordAPI.getRequest(); 
        secretWord = wordAPI.getSecretWord(); 
    }

    public static String getSecretWord() {
        return secretWord;
    }
    
    
    
    
}
