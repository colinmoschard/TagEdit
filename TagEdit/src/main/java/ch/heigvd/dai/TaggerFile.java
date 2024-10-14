package ch.heigvd.dai;
import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class TaggerFile {
    private String title;
    private String artist;
    private String album;
    private String trackNo;
    private String year;

    public TaggerFile(String filename){
        try{
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

    public boolean writeFile(String newFileName){
        return true;
    }

}
