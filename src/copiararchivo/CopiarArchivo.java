/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copiararchivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alvaro
 */
public class CopiarArchivo {

    public static void main(String[] args) {
        /*File origen = new File("D:\\Programacion\\Netbeans\\borrar\\src\\borrar\\imagen1\\minion.jpg");
        File destino = new File("D:\\Programacion\\Netbeans\\borrar\\src\\borrar\\imagen1\\copia.jpg");

        try {
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);
            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopiarArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CopiarArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        File origen = new File("D:\\Programacion\\Netbeans\\borrar\\src\\borrar\\imagen1\\minion.jpg");
        try {
            InputStream in = new FileInputStream(origen);
            System.out.println(in);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CopiarArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
