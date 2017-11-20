package controller;

import javax.swing.JTextArea;
import model.Email;

/**
 * @author mrivaj 
 * github.com/mrivaj
 */
public class EmailController {
    
    public static void generateAlias(Email email, JTextArea outputArea) {
        String emailAdress = email.getAdress();
        checkSpecialCases(email);
               
        for (int i = 2; i <= email.getAtPosition() - 1 ; i++) {
            email.addAliasToList(emailAdress.substring(0,i) + "." + emailAdress.substring(i, emailAdress.length()));
        }
        outputArea.setText(email.getAliasList());    
    }

    private static void checkSpecialCases(Email email) {
        String emailAdress = email.getAdress();
        if (emailAdress.indexOf("@") > 0) email.setAtPosition(emailAdress.indexOf("@"));  
        
        if (emailAdress.indexOf("@") > 1) email.addAliasToList(emailAdress.charAt(0) + "." + emailAdress.substring(1));  // STANDARD FIRST CASE     
        else email.addAliasToList(emailAdress);  // ADD FIRST CASE, IF ONLY HAS ONE LETTER
    }   
}
