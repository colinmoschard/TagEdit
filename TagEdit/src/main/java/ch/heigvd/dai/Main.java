package ch.heigvd.dai;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        // ../src/main/ressources/04 - Weird Fishes_Arpeggi.flac
        String path = "flac_files/04 - Weird Fishes_Arpeggi.flac";
        TaggerFile taggerFile = new TaggerFile(path);
        for(String s: taggerFile.getTags()){
            System.out.println(s);
        }
    }
}