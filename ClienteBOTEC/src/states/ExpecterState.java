package states;

import gameObjects.Ball;
import gameObjects.Block;
import gameObjects.Info;
import gameObjects.Player;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import socketclient.SocketClient;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class ExpecterState extends State {
    //Variables del socket

    private static Boolean online = false;
    private static SocketClient socket;


    public static Boolean isOnline() {
        return online;
    }
    public static SocketClient getSocket() {
        return socket;
    }
    public static void connect(String ip, Integer port)
    {
        //Main
        socket = new SocketClient(ip, port);
        online = true;

    }
    //Variables JSon
    public String datosServer;
    public String state;
    public Long points;
    public JSONObject datosJSon = new JSONObject();

    public JSONParser parser = new JSONParser();

    public String ObteinState(JSONArray blocks, Integer i) {
        JSONObject jsonObject = (JSONObject) blocks.get(i);
        this.state = (String) jsonObject.get("state");
        return state;
    }
    public Long ObteinPoint(JSONArray blocks, Integer i) {
        JSONObject jsonObject = (JSONObject) blocks.get(i);

        this.points = (Long) jsonObject.get("points");
        return points;
    }

    public void ParseDatos(String datos) throws ParseException {
        this.datosServer = datos;

        this.datosJSon = (JSONObject) this.parser.parse(datosServer);

        //loop array
        JSONArray blocks = (JSONArray) this.datosJSon.get("blocks");
        System.out.println(blocks);
        Integer i  =0;



        //Integer points = (Integer) jsonObject.get("points");
        for(Integer r = 0; r<7; r++) {
            for (Integer j = 0; j < 10; j++) {

                System.out.println("El estado son bloque "+" " +state + " " + points);
                i++;


            }
        }




    }

    /***
     * Constructor del Experter
     * @throws ParseException
     */
    public ExpecterState() throws ParseException {
        connect("127.0.0.1",15557);
        socket.sentString("Cliente Expectador");
        String recibido = socket.receiveString();
        ParseDatos(recibido);
    }


    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

    }
}
