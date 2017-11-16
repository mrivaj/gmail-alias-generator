/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Email;

/**
 *
 * @author javi_
 */
public class FileController {
        
    public static void exportAsTxt(Email email) {
        FileWriter fichero = null;
        PrintWriter pw = null;    
    
        try{
            fichero = new FileWriter("txt/" + email.getAdress() + ".txt");
            pw = new PrintWriter(fichero);
            
            String[] emailAdressArray = email.getAliasList().split(",");
        
            for (int i = 0; i < emailAdressArray.length; i++) {
                pw.println(emailAdressArray[i]);
            }
        }catch (IOException e){
        } finally{
            try{
                if (null != fichero)
                    fichero.close();
            }catch (IOException e2){}
        }
    }
}
