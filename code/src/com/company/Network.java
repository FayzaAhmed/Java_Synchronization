package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Network {

    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Device> devices = new ArrayList<Device>();
    public static ArrayList<String> names = new ArrayList<String>();
    public static ArrayList<Boolean> state = new ArrayList<Boolean>();
    public static int N, TC;
    public static String choice;
    public static void main(String[] args) throws InterruptedException{
        // write your code here
        System.out.println("Choose one of the following options: \n1- Terminal \n2- GUI ");
        choice = input.next();
        if (choice.equals("1")) //for terminal
        {
            System.out.println("What is the number of WI-FI Connections?");
            N = input.nextInt();

            System.out.println("What is the number of devices Clients want to connect?");
            TC = input.nextInt();
            String name="", type="";
            for(int i=0; i<TC; i++){
                name = input.next();
                type = input.next();
                Device d = new Device(name, type);
                devices.add(d);
            }
            for (int j = 0; j < N; j++) {
                names.add("");
                state.add(false);
            }
            Router router = new Router();
            router.connect();
        }
        else if(choice.equals("2")) //for GUI
        {
            RouterGUI gui = new RouterGUI();
        }
        else
            System.out.println("Error: invalid choice");


    }//end of main



    public synchronized static int connectionNumber(String name, int x) {

        int connectionNum = 0;
        int flag = 0;

        if (x == 1)  //device wants to end the connection and logout
        {
            for (int k = 0; k < N; k++) {
                if (names.get(k).equals(name)) {
                    names.set(k, "");
                    state.set(k, false);
                    connectionNum = k + 1;
                }
            }
        }
        else //x=0 => device wants to connect
        {

            for (int i = 0; i < N; i++) {
                if (names.get(i).equals(name)) {
                    connectionNum = i + 1;
                    flag++;
                }
            }
            if (flag == 0) {

                for (int j = 0; j < N; j++) {
                    if (state.get(j) == false) //there is an available connection for a device
                    {
                        state.set(j, true);
                        connectionNum = j + 1;
                        names.set(j, name);
                        break;
                    }
                }
            }
        }

        return connectionNum;
    }


}



