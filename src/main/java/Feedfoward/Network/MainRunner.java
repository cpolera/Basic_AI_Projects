package Feedfoward.Network;

import Feedfoward.Logger;
import Feedfoward.Main;
import Feedfoward.NNObj;

import java.io.IOException;

public class MainRunner {

    public static void main(String[] args) throws IOException {

        /*
        1. node per layer count
        2. hidden layer count
        3. file name
        4. save location
        5. training count
        6. desired error
         */

        int nodeCount = Integer.parseInt(args[0]);
        int hiddenLayerCount = Integer.parseInt(args[1]);
        String fileName = args[2];
        String saveLocation = args[3];

        //Test

        System.out.println("Node count: " + nodeCount);
        System.out.println("Layer count: " + hiddenLayerCount);
        System.out.println("File name: " + fileName);
        System.out.println("Save location: " + saveLocation);

        //Create network and save output
        Network network = new Network();
        Logger.setFileLocation(fileName, saveLocation);
        Logger logger = new Logger(network);
        NNObj[] trainingSet = Main.createSymbolList_EXAMPLE();
        NNObj[] testSymbols = Main.createTestSymbols();
        network.trainingCount = 1000;
        network.desiredError = 0.1;
        network.setupNetwork(nodeCount, hiddenLayerCount, trainingSet, testSymbols, true);

        logger.closeWriter();
        logger.showNetwork();
    }
}

//C:\Users\cjp2473\IdeaProjects\Basic_AI_Projects>java -cp ./target/classes;. Feedfoward.Network.MainRunner 1 2 test1 test3