package controller;

import javax.swing.JTextArea;
import model.Email;

/**
 * @author mrivaj 
 * github.com/mrivaj
 */
public class EmailController {
    
    public static void generateAliasWithDots(Email email, JTextArea outputArea) {
        String emailAdress = email.getAdress();
        checkSpecialCases(email);
               
        for (int i = 2; i <= email.getAtPosition() - 1 ; i++) {
            email.addAliasToList(emailAdress.substring(0,i) + "." + emailAdress.substring(i, emailAdress.length()));
        }
        outputArea.setText(email.getAliasList());    
    }
    
    public static void generateAliasWithNumbers(Email email, JTextArea outputArea) {
        String emailAdress = email.getAdress();
        emailAdress = emailAdress.substring(0, emailAdress.indexOf("@")) + "+";  
        for (int i = 0; i < 10; i++) {
            email.addAliasToList(emailAdress + "0" + i + "@gmail.com" );
        }
        
        for (int i = 10; i < 100; i++) {
            email.addAliasToList(emailAdress + i + "@gmail.com" );
        }
        outputArea.setText(email.getAliasList());    
    }

    private static void checkSpecialCases(Email email) {
        String emailAdress = email.getAdress();
        if (emailAdress.indexOf("@") > 0) email.setAtPosition(emailAdress.indexOf("@"));  
        
        if (emailAdress.indexOf("@") > 1) email.addAliasToList(emailAdress.charAt(0) + "." + emailAdress.substring(1));   
        else email.addAliasToList(emailAdress);  // ADD FIRST CASE, IF ONLY HAS ONE LETTER
    }   
}

