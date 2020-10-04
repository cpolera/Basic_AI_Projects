package Feedfoward;

public class Manager {

    private static String fileLocation = "src/main/logs/Log1.json";

    public static String getFileLocation(){return Manager.fileLocation;}

    public static void setFileLocation(String fileName, String fileLocation){
        Manager.fileLocation = fileLocation + fileName + ".json";
    }
}
