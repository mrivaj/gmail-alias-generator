package controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Email;

/**
 * @author mrivaj 
 * github.com/mrivaj
 */
public class FileController {
        
    public static void exportAsTxt(Email email) {
        FileWriter file = null;
        PrintWriter pw;    
    
        try{
            File directory = new File("txt");
            if (!directory.exists()) directory.mkdir();
            file = new FileWriter("txt/" + email.getAdress() + ".txt");
            pw = new PrintWriter(file);
            fillTxt(email.getAliasList(), pw); 
        } catch (IOException e){
        } finally{
            try{
                if (null != file) file.close();
            }catch (IOException e1){}
        }
    }

    private static void fillTxt(String aliasList, PrintWriter pw) {
            String[] emailAdressArray = aliasList.split(",");    
        for (String emailAdressArray1 : emailAdressArray) {
            pw.println(emailAdressArray1);
        }    
    }

    public static void copyToClipboard(String list) {
        StringSelection selection = new StringSelection(list);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);    
    }
}
