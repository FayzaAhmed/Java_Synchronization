package com.company;
import java.io.IOException;

public class Semaphore {
    public int boundary = 0; //tells me whether there are devices in the waiting queue or not
    public static OutputGUI outputGUI;

    //default constructor
    public Semaphore(){
        this.boundary = 0;
        if (Network.choice.equals("2")) {
            outputGUI = new OutputGUI();
        }
    }

    //parametrized constructor
    public Semaphore(int value){
        this.boundary = value;
        if (Network.choice.equals("2")) {
            outputGUI = new OutputGUI();
        }
    }

    public void setBound(int bound) {
        this.boundary = bound;
    }
    public int getBound() {
        return boundary;
    }

    //function wait
    public synchronized void P(String name) throws InterruptedException, IOException{
        boundary--;
        if (boundary < 0) //the router is full of connections
        {
            String output = "";
            for (int i = 0; i < Network.devices.size(); i++) {
                if (Network.devices.get(i).getName().equals(name)) {
                    output = "- (" + name + ") " + "(" + Network.devices.get(i).getType() + ")" + " arrived and waiting";
                    break;
                }
            }
            //output for console
            System.out.println(output);
            if (Network.choice.equals("2")) //for GUI
                outputGUI.addUpdates(output + "\n");
            //write the output in the file
            OutputFile file1 = new OutputFile(output + " ");

            wait();
        }
        else //there are available connections in the router
        {
            String output = "";
            for (int i = 0; i < Network.devices.size(); i++) {
                if (Network.devices.get(i).getName().equals(name)) {
                    output ="- (" + name + ") " + "(" + Network.devices.get(i).getType() + ")" + " arrived";
                    break;
                }
            }
            //output for console
            System.out.println(output);
            if (Network.choice.equals("2")) //for GUI
                outputGUI.addUpdates(output + "\n");
            //write the output in the file
            OutputFile file2 = new OutputFile(output + " ");

        }
    }

    //function signal
    public synchronized void V(String name)  throws IOException {
        boundary++;
        if (boundary <= 0) //notifying the devices that want to connect to the router
            notify();

        String output = "- Connection " + Network.connectionNumber(name, 1) + ": " + name + " Logged out";
        //output for console
        System.out.println(output);
        if (Network.choice.equals("2")) //for GUI
            outputGUI.addUpdates(output + "\n");
        //write the output in the file
        OutputFile file3 = new OutputFile(output + " ");

    }
}
