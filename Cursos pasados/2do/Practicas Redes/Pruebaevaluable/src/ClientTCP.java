import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTCP {

    public static void main(String[] args) throws IOException {
        // DATOS DEL SERVIDOR:
        //* FIJOS: coméntelos si los lee de la línea de comandos
        // String serverName = "127.0.0.1"; // direccion local
        // int serverPort = 12345;
        //* VARIABLES: descoméntelos si los lee de la línea de comandos
        //String serverName = args[0];
        // int serverPort = Integer.parseInt(args[1]);

        // SOCKET
        Socket serviceSocket = null;

        // FLUJOS PARA EL ENVIO Y RECEPCION
        PrintWriter out = null;
        BufferedReader in = null;
        serviceSocket = new Socket("127.0.0.1", 17500);

        //* COMPLETAR: Inicializar los flujos de entrada/salida del socket conectado en las variables PrintWriter y BufferedReader
        out = new PrintWriter(serviceSocket.getOutputStream(), true);
        //* COMPLETAR: Recibir mensaje de bienvenida del servidor y mostrarlo
        in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
        // Obtener texto por teclado
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;

        System.out.println("Bienvenido al servicio de multiplicación de textos");
        userInput = stdIn.readLine();

        //* COMPLETAR: Comprobar si el usuario ha iniciado el fin de la interacción // bucle del servicio
        while (userInput.compareTo("TOO MANY REQUEST") != 0) {
             
            //* COMPLETAR: Enviar texto en userInput al servidor a través del flujo de salida del socket conectado
            out.println(userInput);

            //* COMPLETAR: Recibir texto enviado por el servidor a través del flujo de entrada del socket conectado
            String line = null;
            line = in.readLine();
            System.out.println("Servidor envía " + line);


            // Leer texto de usuario por teclado
            System.out.println("Introduzca un texto a enviar (TERMINAR para acabar)");
            userInput = stdIn.readLine();
        } // Fin del bucle de servicio en cliente

        // Salimos porque el cliente quiere terminar la interaccion, ha introducido TERMINAR
        //* COMPLETAR: Enviar END al servidor para indicar el fin deL Servicio
        out.println("END");

        //* COMPLETAR: Recibir el OK del Servidor
        String ok;
        ok = in.readLine();
        System.out.println(ok);

        //* COMPLETAR Cerrar flujos y socket
        out.close();
        in.close();
        serviceSocket.close();
        stdIn.close();
    }
}
