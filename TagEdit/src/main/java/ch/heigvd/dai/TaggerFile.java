package ch.heigvd.dai;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileFilter;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class TaggerFile {
    private String title;
    private String artist;
    private String album;
    private String trackNo;
    private String year;

    private String filename;

    /**
     * Constructor that fills the tag fields of the TaggerFile class
     * @param filename: path of the existing flac file
     */
    public TaggerFile(String filename){
        try{
            this.filename = filename;
            File file = new File(filename);
            AudioFile audioFile = AudioFileIO.read(file);
            Tag tag = audioFile.getTag();

            title = tag.getFirst(FieldKey.TITLE);
            artist = tag.getFirst(FieldKey.ARTIST);
            album = tag.getFirst(FieldKey.ALBUM);
            trackNo = tag.getFirst(FieldKey.TRACK);
            year = tag.getFirst(FieldKey.YEAR);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Writes a new file with the new specified tags
     * @param newFileName: path of the file that will be created
     * @return the success or failure of the file writing
     */
    public boolean writeFile(String newFileName){
        try {
            File outputFile = new File(newFileName);
            Path pathNewFile = Path.of(newFileName);

            if(Files.exists(pathNewFile)) {
                Files.delete(pathNewFile);
            }
            Files.copy(Path.of(filename), pathNewFile);
            AudioFile audioFile = AudioFileIO.read(outputFile);

            Tag tag = audioFile.getTag();
            tag.setField(FieldKey.TITLE, title);
            tag.setField(FieldKey.ARTIST, artist);
            tag.setField(FieldKey.ALBUM, album);
            tag.setField(FieldKey.TRACK, trackNo);
            tag.setField(FieldKey.YEAR, year);

            AudioFileIO.write(audioFile);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Returns all the tags from the song
     * @return [0]:title, [1]: artist, [2]: album, [3]: trackNo, [4]: year
     */
    public String[] getTags(){
        return new String[]{title, artist, album, trackNo, year};
    }

    public void editTitle(String title){
        this.title = title;
    }

    public void editArtist(String artist){
        this.artist = artist;
    }

    public void editTrackNumber(String trackNo){
        this.trackNo = trackNo;
    }

    public void editAlbumName(String albumName){
        this.album = albumName;
    }

    public void editYear(String year){
        this.year = year;
    }



}
