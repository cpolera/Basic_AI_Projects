package Feedfoward;

import Feedfoward.Network.Network;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws IOException {
        Network network = new Network();
//        network.setupNetworkAndRunExample();
        Logger logger = new Logger(network);
//        NNObj[] trainingSet = createSymbolList_EXAMPLE();
//        NNObj[] testSymbols = createTestSymbols();

        NNObj[] trainingSet = createSimpleExample();
        NNObj[] testSymbols = createSimpleExampleTest();

        network.trainingCount = 1000;
        network.desiredError = 0.1;
        network.setupNetwork(2, 2, trainingSet, testSymbols, true);

        logger.closeWriter();
        logger.showNetwork();

    }

//update to take any number of inputs
    //update to have any number of output neurons
    //update to handle multiple layers of hidden neurons
    //update training method to handle any number of inputs/ same with testing

    public static NNObj[] createSimpleExample(){
        NNObj.incr = 0;

        double[] first = new double[]{0.1,0.1};
        double[] second = new double[]{0.1,0.9};
        double[] third = new double[]{0.9,0.1};
        double[] fourth = new double[]{0.9,0.9};

        NNObj[] symbols = new NNObj[]{
                new NNObj(first, new double[]{0.9}, "Low Low"),
                new NNObj(second, new double[]{0.1}, "Low High"),
                new NNObj(third, new double[]{0.1}, "High Low"),
                new NNObj(fourth, new double[]{0.9}, "High High"),
        };

        return symbols;
    };

    public static NNObj[] createSimpleExampleTest(){
        NNObj.incr = 0;

        double[] first = new double[]{0.1,0.1};
        double[] second = new double[]{0.1,0.9};
        double[] third = new double[]{0.9,0.1};
        double[] fourth = new double[]{0.9,0.9};

        NNObj[] symbols = new NNObj[]{
                new NNObj(first, new double[]{0.9}, "Low Low_t"),
                new NNObj(second, new double[]{0.1}, "Low High_t"),
                new NNObj(third, new double[]{0.1}, "High Low_t"),
                new NNObj(fourth, new double[]{0.9}, "High High_t"),
        };

        return symbols;
    };

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

        int[] cIntoVals = new int[]{
                1, 1, 1, 1, 1,
                1, 0, 0, 0, 0,
                1, 0, 0, 0, 0,
                1, 0, 0, 0, 0,
                1, 1, 1, 1, 1
        };

        Symbol[] symbols = new Symbol[]{
                new Symbol(plusIntoVals, new int[]{0, 0, 1}, "PLUS"),
                new Symbol(xIntoVals, new int[]{0, 1, 0}, "X"),
                new Symbol(oIntoVals, new int[]{1, 0, 0}, "O"),
                new Symbol(tIntoVals, new int[]{1, 1, 0}, "T"),
                new Symbol(cIntoVals, new int[]{1, 0, 1}, "C"),
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

        int[] cIntoVals = new int[]{
                1, 0, 1, 1, 1,
                1, 0, 0, 0, 0,
                1, 0, 0, 0, 0,
                1, 0, 0, 0, 0,
                1, 1, 1, 0, 1
        };

        Symbol[] symbols = new Symbol[]{
                new Symbol(plusSymbol, new int[]{0, 0, 1}, "PLUS_t"),
                new Symbol(xIntoVals, new int[]{0, 1, 0}, "X_t"),
                new Symbol(OintoVals, new int[]{1, 0, 0}, "O_t"),
                new Symbol(cIntoVals, new int[]{1, 0, 1}, "C_t"),
                new Symbol(tIntoVals, new int[]{1, 1, 0}, "T_t")
        };

        return symbols;
    }
}
