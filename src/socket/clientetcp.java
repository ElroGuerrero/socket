package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clientetcp {

    final String HOST = "127.0.0.1";
    final int PUERTO = 5000;
    DataInputStream in;
    DataOutputStream out;

    public void Enviar(String me) {
        try {
            int vAleatorio = (int) (Math.random() * 100 + 1);
            String Mensaje = me +"-"+ vAleatorio;
            Socket sc = new Socket(HOST, PUERTO);
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            //Mensaje de salida
            out.writeUTF(Mensaje);

            //Mensaje de entrada
            String mensaje = in.readUTF();
            System.out.println(mensaje);

            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(clientetcp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
