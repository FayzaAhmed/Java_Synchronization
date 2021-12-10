package com.company;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Router implements Runnable{

    public static String currentDirectory = System.getProperty("user.dir");
    public static File file = null;
    public static FileWriter myWriter;

    public Network network = new Network();
    public Semaphore semaphore;

    //default constructor
    public Router(){
        semaphore = new Semaphore(network.N);
    }

    public void connect() throws InterruptedException{
        //start a thread for each device
        for (int i = 0; i < network.devices.size(); i++) {
            Thread t = new Thread(this, network.devices.get(i).getName());
            t.start();
        }
    }

    @Override
    public void run() {
        Random random = new Random(); //to generate random numbers

        try {

            semaphore.P(Thread.currentThread().getName()); //perform wait for the device

            String name = Thread.currentThread().getName();
            String outputOccupied;
            outputOccupied = "- Connection " + Network.connectionNumber(name, 0) + ": "
                    + Thread.currentThread().getName() + " Occupied";

            System.out.println(outputOccupied);
            if (Network.choice.equals("2"))
                semaphore.outputGUI.addUpdates(outputOccupied + "\n");
            OutputFile file1 = new OutputFile(outputOccupied);

            Thread.currentThread().sleep(1000);
            String outputLogin = "- Connection " + Network.connectionNumber(name, 0) + ": "
                    + Thread.currentThread().getName() + " login";
            String outputActive = "- Connection " + Network.connectionNumber(name, 0) + ": "
                    + Thread.currentThread().getName() + " Performs online activity";

            System.out.println(outputLogin + "\n" + outputActive);
            if (Network.choice.equals("2"))
                semaphore.outputGUI.addUpdates(outputLogin + "\n" + outputActive  + "\n");
            OutputFile file2 = new OutputFile(outputLogin + "\n" + outputActive + " ");

            Thread.currentThread().sleep((random.nextInt(5) + 1) * 1000);

            semaphore.V(Thread.currentThread().getName()); //perform signal for the device

            Thread.currentThread().stop();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
