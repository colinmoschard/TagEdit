package ch.heigvd.dai;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.InputStreamReader;
import java.io.BufferedReader;

@CommandLine.Command(
        name = "tagedit",
        description = "Changes the tags of an audio file",
        version = "TagEdit 1.0",
        mixinStandardHelpOptions = true)
public class Main implements Runnable {

    @Option(
            names = {"-v", "--version"},
            versionHelp = true,
            description = "Show version info")
    boolean versionRequested;

    @Parameters(index="0", description = "the .flac file")
    String fileName;

    @Option(names="--trackNo", description = "track number")
    String trackNo;

    @Option(names="--title", description = "track title")
    String title;

    @Option(names="--year", description = "track year")
    String year;

    @Option(names="--album", description = "album name")
    String album;

    @Option(names="--artist", description = "artist name")
    String artist;


    /**
     * Entry point
     * @param args arguments to give to the program
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }


    /**
     * Called when running the program
     */
    @Override
    public void run() {

        if(fileName == null) {
            System.out.println("No file given");
            return;
        }

        TaggerFile taggerFile = new TaggerFile(fileName);

        String[] tags = taggerFile.getTags();

        // if no option has been entered, only display tags.
        if(artist == null && year == null && title == null && album == null) {

            System.out.println("Showing tags:");
            displayTags(tags);

            return;
        }

        if (title != null && !title.equals(tags[0])) {

            taggerFile.editTitle(title);
        }

        if (artist != null && !artist.equals(tags[1])) {

            taggerFile.editArtist(artist);
        }

        if (year != null && !year.equals(tags[4])) {

            taggerFile.editYear(year);
        }

        if (trackNo != null && !trackNo.equals(tags[3])) {

            taggerFile.editTrackNumber(trackNo);
        }

        if (album != null && !album.equals(tags[2])) {

            taggerFile.editAlbumName(album);
        }

        tags = taggerFile.getTags();

        System.out.println("Showing tags with modifications:");
        displayTags(tags);

        System.out.print("Enter new filename (enter to overwrite original): ");
        
        // try catch is necessary to use Reader. if it fails, filename will default to original file name
        // and thus overwrite the old file.
        String newFileName = null;
        try{
            // Better than System.console().ReadLine() because it only works in interactive consoles.
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            newFileName = br.readLine();
        } catch (Exception ex){
            System.out.println();
        }

        if (newFileName == null) {
            System.out.println("No filename given");
            newFileName = fileName;
        }

        if(newFileName.equals(fileName)) {
            System.out.println("Overwriting original file...");
        } else {
            System.out.println("Creating new file...");
        }

        // adds ".flac" if the filename doesn't have it
        if(newFileName.length() > 4 && !newFileName.substring(newFileName.length() - 5).equalsIgnoreCase("flac"))
            newFileName += ".flac";

        // checks whether the writing has succeeded or not 
        if(taggerFile.writeFile(newFileName)){
            System.out.println("Complete.");
        } else {
            System.out.println("An error has occurred.");
        }
    }

    /**
     * Prints contents of tags in the console
     * @param tags [0]:title, [1]: artist, [2]: album, [3]: trackNo, [4]: year
     */
    private void displayTags(String[] tags) {
        System.out.println("Track number 	: " + tags[3]);
        System.out.println("Track title 	: " + tags[0]);
        System.out.println("Album name	    : " + tags[2]);
        System.out.println("Artist name	    : " + tags[1]);
        System.out.println("Year of track	: " + tags[4]);

        System.out.println();
    }
}