package enviarArchivoSocket;


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;

/*
 * El que lo recibe
 */
/**
 *
 * @author Alvaro
 */
public class Socketserver {

    private Socket s;

    public static void main(String[] args) {
        Socketserver sk = new Socketserver();
        sk.initServer(9527);
        sk.getFile();
    }

    public void initServer(int port) {
        try {
            s = new Socket(InetAddress.getLocalHost(), 9527); // Conéctese al servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // Leer archivo de SocketClient 

    public void getFile() {
        byte[] b = new byte[1024];
        try {// Defina la secuencia de entrada,
            InputStream in = s.getInputStream();
            DataInputStream din = new DataInputStream(new BufferedInputStream(in)
            ); // Cree el archivo que se guardará   
            File f = new File("D:\\copy.jpg");
            RandomAccessFile fw = new RandomAccessFile(f, "rw");
            int num = din.read(b);
            while (num != -1) {// Escribe 0 ~ num bytes en el archivo    
                fw.write(b, 0, num); // Omita los bytes num y vuelva a escribir en el archivo   
                fw.skipBytes(num); // Leer bytes numéricos    
                num = din.read(b);
            } // Cerrar flujo de entrada y salida  
            din.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
