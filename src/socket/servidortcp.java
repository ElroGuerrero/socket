package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servidortcp {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            while (true) {

                sc = servidor.accept();
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                String mensaje = in.readUTF();

                String[] parts = mensaje.split("-");
                String part1 = parts[0]; // 123
                String part2 = parts[1]; // 654321

                System.out.println("Mensaje: "+part1);
                System.out.println("Dato del sensor: "+part2);

                out.writeUTF("Datos recibidos");

                sc.close();
                System.out.println("Cliente desconectado");

            }

        } catch (IOException ex) {
            Logger.getLogger(servidortcp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
