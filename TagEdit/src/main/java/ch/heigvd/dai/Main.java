package ch.heigvd.dai;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "tagedit",
        description = "Print a 'Hello World!' type of message.",
        version = "TagEdit 0.0.1",
        mixinStandardHelpOptions = true)

public class Main implements Runnable {
    @Option(
            names = {"-v", "--version"},
            versionHelp = true,
            description = "Affiche la version de l'application")
    boolean versionRequested;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        // Cette méthode sera exécutée si aucune option -v ou --version n'est spécifiée
        System.out.println("Commande exécutée sans la version. Utilisez -v ou --version pour voir la version.");
    }
}