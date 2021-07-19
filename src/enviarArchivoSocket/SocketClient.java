package enviarArchivoSocket;


import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * El que envia el archivo
/**
 *
 * @author Alvaro
 */
public class SocketClient {

    private Socket client;

    public static void main(String[] args) {
        SocketClient sc = new SocketClient();
        sc.connectSocketServer(9527);
        sc.sendFile("D:\\minion.jpg");
    }

    public void connectSocketServer(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            client = server.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String str) {
        byte[] b = new byte[1024];
        File f = new File(str);
        try {// Flujo de salida de datos  
            OutputStream dout = new DataOutputStream(new BufferedOutputStream(client.getOutputStream())); // Archivo leído en secuencia
            InputStream ins = new FileInputStream(f);
            int n = ins.read(b);
            while (n != -1) {  
                dout.write(b); 
                dout.flush();   
                n = ins.read(b);
            } 
            ins.close();
            dout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
