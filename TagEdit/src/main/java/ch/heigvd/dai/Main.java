package ch.heigvd.dai;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@CommandLine.Command(
        name = "tagedit",
        description = "Print a 'Hello World!' type of message.",
        version = "TagEdit 0.0.1",
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
        // Cette méthode sera exécutée si aucune option -v ou --version n'est spécifiée
        if(fileName == null) {
            System.out.println("No file given");
            return;
        }

        // open file

        // get file tags

        if(artist == null && year == null && title == null && album == null) {
            System.out.println("showing tags:");

            // show file tags

            return;
        }

        if (title != null) {
            // edit title
        }

        if (artist != null) {

            // edit artist
        }

        if (year != null) {

            // edit year
        }

        if (trackNo != null) {

            // edit track number
        }

        if (album != null) {

            // edit album
        }

        // check if modified tags are different from original

        // display modified tags

        String newFileName = System.console().readLine("Enter new filename: ");

        // save copy of file

    }
}