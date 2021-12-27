package com.example.vvs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class UI implements Runnable{
    static boolean runServer=true;

    public static String getStatusServer() {
        return statusServer;
    }

    static String  statusServer;
    static int port;
    static int stepSetPort=0;

    public static boolean getConnectionOk() {
        return connectionOk;
    }

    public static void setConnectionOk(boolean connectionOk) {
        UI.connectionOk = connectionOk;
    }

    static boolean connectionOk=false;

    public static Server getSrv() {
        return srv;
    }

    public static void setSrv(Server srv) {
        UI.srv = srv;
    }

    static Server srv;
    static int programRun=1;

    public static void main(String[] args) {
        HelloApplication.main();
    }

    public static void init(int port){
        srv = new Server();
        while (!connectionOk) {
            setPortInterface(port);
        }

        Thread interfaceThread = new Thread(new UI());
        interfaceThread.start();
    }

    //@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public static void readComands() throws IOException {
        while(true)
        {
            System.out.print("> Enter command :");
            BufferedReader readerCommand =  new BufferedReader(new InputStreamReader(System.in));
            String comandaLinie = readerCommand.readLine();
            verifCommand(comandaLinie);
        }
    }

    public static void verifCommand(String cmd) throws IOException {
        if (cmd.equals("STATUS")) {
            System.out.println("Status > WebServer Status is:"+statusServer);
        }else if (cmd.equals("systeminfo")) {
            System.out.println("Status server : "+statusServer);
            System.out.println("Port : "+port);
            InetAddress IP = InetAddress.getLocalHost();
            System.out.println("Host : "+IP.getHostAddress());
        }else if (cmd.equals("PAUSE")){
            srv.setStateServer(2);
            statusServer="MAINTENANCE";
            System.out.println("Server is now in maintenance mode!");
        }else if (cmd.equals("START")) {
            srv.setStateServer(1);
            statusServer="RUNNING";
            System.out.println("Server started with initial port : "+Server.serverPort);
        }else if (cmd.equals("STOP")){
            srv.setStateServer(3);
            statusServer="STOP";
            System.out.println("Server is now stopped!");
        }else if (cmd.equals("HELP")){
            System.out.println("The commands are:\n> STATUS\n> START\n> PAUSE\n> STOP");
        }else{
            statusServer="WAITING";
            System.out.println("This command is not defined!");
        }
    }

    public static void setPortInterface(int port) {
        if(srv.setPort(port))
        {
            if(srv.acceptServerPort())
            {
                System.out.println("Port : "+port+" was accepted!\n");
                connectionOk=true;
                statusServer="STOP";
            }
        }
    }

    @Override
    public void run() {
        while(runServer) {
            srv.listenForClients();
        }
    }
}

