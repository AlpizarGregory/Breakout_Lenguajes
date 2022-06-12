import java.net.*;
import java.io.*;

class TalkToC
{
    private String host = null;
    private int port = 15482;
    private Socket socket = null;
    private BufferedReader inStream = null;

    public static void main(String[] args)
    {
        TalkToC caller = new TalkToC();
        caller.port = 15482;
        caller.setUp();
        caller.converse();
        caller.setUp();
        caller.converse();
        caller.cleanUp();
    }

    public void setUp()
    {
        System.out.println("Conectado con c");

        try
        {
            socket = new Socket(host, port);
            inStream = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
        }
        catch(UnknownHostException e)
        {
            System.err.println("No se puede encontrar el host llamado: " + host);
            e.printStackTrace();
            System.exit(-1);
        }
        catch(IOException e)
        {
            System.err.println("No se ha podido establecer conexión para " + host);
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void converse()
    {
        System.out.println("Comienza la conversacion");

        if (socket != null && inStream != null)
        {
            try
            {
                System.out.println(inStream.readLine());
            }
            catch(IOException e)
            {
                System.err.println("Error de conversación con host " + host);
                e.printStackTrace();
            }
        }
    }

    public void cleanUp()
    {
        try
        {
            if(inStream != null)
                inStream.close();
            if(socket != null)
                socket.close();
        }
        catch(IOException e)
        {
            System.err.println("Error de borrado");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}