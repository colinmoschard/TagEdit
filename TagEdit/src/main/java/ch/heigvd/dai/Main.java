package ch.heigvd.dai;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        // ../src/main/ressources/04 - Weird Fishes_Arpeggi.flac
        String inputPath = "flac_files/04 - Weird Fishes_Arpeggi.flac";
        String outputPath = "flac_files/test.flac";
        TaggerFile taggerFile = new TaggerFile(inputPath);
        for(String s: taggerFile.getTags()){
            System.out.println(s);
        }
        System.out.println("---------");

        taggerFile.editArtist("Patrick");
        taggerFile.editTitle("testTitle");
        taggerFile.editYear("2024");
        taggerFile.editAlbumName("the best album");
        taggerFile.editTrackNumber("025");
        taggerFile.writeFile(outputPath);

        TaggerFile taggerFileoutput = new TaggerFile(outputPath);
        for(String s: taggerFileoutput.getTags()){
            System.out.println(s);
        }
    }
}