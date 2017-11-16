package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author javi_
 */
public class Email {

    public static void saveCurrentEmail(Email email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    String emailAdress;
    int atPosition;
    String aliasList;

    public Email(String emailAdress) {
        this.emailAdress = emailAdress;
        atPosition = 0;
        aliasList = "";    
    }

    public String getAdress() {
        return emailAdress;
    }

    public void getAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public int getAtPosition() {
        return atPosition;
    }

    public void setAtPosition(int atPosition) {
        this.atPosition = atPosition;
    }

    public String getAliasList() {
        return aliasList;
    }

    public void setAliasList(String aliasList) {
        this.aliasList = aliasList;
    }
    
    public void addAliasToList(String alias){
        this.aliasList += alias +"\n";
    }
       
}
