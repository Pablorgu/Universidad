import java.io.*;
import java.net.*;
import java.util.Scanner;

class ServerTCP {

    public static String separate(String s) {
        String numero = s.substring(0, 1);
        int num = Integer.parseInt(numero);
        s = s.substring(1);
        String res = "";
        for (int i = 0; i < num; i++) {
            res += s;
        }
        return res;
    }

    public static void main(String[] args) throws IOException
    {
        // DATOS DEL SERVIDOR
        //* FIJO: Si se lee de línea de comando debe comentarse
        int port = 17500; // puerto del servidor
        //* VARIABLE: Si se lee de línea de comando debe descomentarse
        // int port = Integer.parseInt(args[0]);
        int  numPeticiones = 0;
        // SOCKETS
        ServerSocket server = null; // Pasivo (recepción de peticiones)
        Socket client = null;       // Activo (atención al cliente)

        // FLUJOS PARA EL ENVIO Y RECEPCION
        BufferedReader in = null;
        PrintWriter out = null;

        //* COMPLETAR: Crear e inicalizar el socket del servidor (socket pasivo)
        try{
            server = new ServerSocket(port, 10);
        }catch (Exception e){
            e.printStackTrace();
        }
        while (true) // Bucle de recepción de conexiones entrantes
        {
            //* COMPLETAR: Esperar conexiones entrantes
            client = server.accept();

            //* COMPLETAR: Una vez aceptada una conexion, inicializar flujos de entrada/salida del socket conectado
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);

            boolean salir = false;
            while(!salir) // Inicio bucle del servicio de un cliente
            {
                //* COMPLETAR: Recibir texto en line enviado por el cliente a través del flujo de entrada del socket conectado
                String line = null;
                line = in.readLine();
                System.out.println(line);

                //* COMPLETAR: Comprueba si es fin de conexion - SUSTITUIR POR LA CADENA DE FIN enunciado
                if (line.compareTo("TERMINAR") != 0){
                    line = separate(line);
                    numPeticiones++;
                    if(numPeticiones == 4) {
                        System.out.println("TOO MANY REQUEST");
                    }

                    //* COMPLETAR: Enviar texto al cliente a traves del flujo de salida del socket conectado
                    out.println(line);
                } else { // El cliente quiere cerrar conexión, ha enviado END
                    salir = true;
                }
            } // fin del servicio

            //* COMPLETAR: Cerrar flujos y socket
            in.close();
            out.close();
            client.close();

        } // fin del bucle
    } // fin del metodo
}
