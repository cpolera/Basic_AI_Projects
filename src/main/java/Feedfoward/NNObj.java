package Feedfoward;

/**
 * NNObj is a generic neural network object that contains an array of input values, expected output values
 * Appears to store the originals in dVals and dVals_targets and uses SetValues as the location for updating values
 */
public class NNObj {

    public String desc;
    protected double[] dVals;//input values for a single set
    protected double[] dVals_targets;//expected output values for a single set
    //EXAMPLE: dVals = [0,1], targets = [1]. EXAMPLE: [0,1,1,1,1,0] targets[0,1,0]
    protected int id;

    public NNObj() {
    }

    public double[] getInputVals(){
        return dVals;
    }

    public double[] getOutputVals(){
        return dVals_targets;
    }
}
