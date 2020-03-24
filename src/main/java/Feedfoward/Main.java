package Feedfoward;

import Feedfoward.Network.Network;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        Network network = new Network();
//        network.setupNetworkAndRunExample();
        Logger logger = new Logger(network);
        NNObj[] trainingSet = createSymbolList_EXAMPLE();
        NNObj[] testSymbols = createTestSymbols();
        network.trainingCount = 1000;
        network.desiredError = 0.1;
        network.setupNetwork(10, 2, trainingSet, testSymbols, true);

        logger.closeWriter();
        logger.showNetwork();

    }

//update to take any number of inputs
    //update to have any number of output neurons
    //update to handle multiple layers of hidden neurons
    //update training method to handle any number of inputs/ same with testing


    public static Symbol[] createSymbolList_EXAMPLE() {

        Symbol.incr = 0;

        int[] plusIntoVals = new int[]{
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0,
                1, 1, 1, 1, 1,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0};

        int[] xIntoVals = new int[]{
                1, 0, 0, 0, 1,
                0, 1, 0, 1, 0,
                0, 0, 1, 0, 0,
                0, 1, 0, 1, 0,
                1, 0, 0, 0, 1};

        int[] oIntoVals = new int[]{
                1, 1, 1, 1, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 1,
                1, 1, 1, 1, 1
        };

        int[] tIntoVals = new int[]{
                1, 1, 1, 1, 1,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0
        };

        Symbol[] symbols = new Symbol[]{
                new Symbol(plusIntoVals, new int[]{0, 0, 1}, "PLUS"),
                new Symbol(xIntoVals, new int[]{0, 1, 0}, "X"),
                new Symbol(oIntoVals, new int[]{1, 0, 0}, "O"),
                new Symbol(tIntoVals, new int[]{1, 1, 0}, "T")
        };

        return symbols;
    }

    public static Symbol[] createTestSymbols() {

        Symbol.incr = 0;

        int[] plusSymbol = new int[]{
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                1, 0, 1, 1, 1,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0};

        int[] xIntoVals = new int[]{
                1, 1, 0, 1, 1,
                0, 1, 0, 1, 0,
                0, 0, 1, 0, 0,
                0, 1, 0, 1, 0,
                1, 0, 0, 0, 1};

        int[] OintoVals = new int[]{
                1, 1, 1, 1, 1,
                1, 0, 0, 1, 1,
                1, 0, 0, 0, 1,
                1, 0, 0, 0, 0,
                1, 1, 1, 1, 1
        };

        int[] tIntoVals = new int[]{
                1, 1, 1, 1, 1,
                0, 0, 0, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0,
                0, 0, 1, 0, 0
        };
        Symbol[] symbols = new Symbol[]{
                new Symbol(plusSymbol, new int[]{0, 0, 1}, "PLUS_t"),
                new Symbol(xIntoVals, new int[]{0, 1, 0}, "X_t"),
                new Symbol(OintoVals, new int[]{1, 0, 0}, "O_t"),
                new Symbol(tIntoVals, new int[]{1, 1, 0}, "T_t")
        };

        return symbols;
    }
}
