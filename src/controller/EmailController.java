/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JTextArea;
import model.Email;

/**
 *
 * @author javi_
 */
public class EmailController {
    

    public static void generateAlias(Email email, JTextArea outputArea) {
        String emailAdress = email.getAdress();
        
        if (emailAdress.indexOf("@") > 0) email.setAtPosition(emailAdress.indexOf("@"));
        email.addAliasToList(emailAdress.charAt(0) + "." + emailAdress.substring(1));  
        
        for (int i = 2; i <= email.getAtPosition(); i++) {
            email.addAliasToList(emailAdress.substring(0,i) + "." + emailAdress.substring(i, emailAdress.length()));
        }
        outputArea.setText(email.getAliasList());    
    }
    
}
