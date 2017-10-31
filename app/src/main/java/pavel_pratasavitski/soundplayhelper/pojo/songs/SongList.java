package pavel_pratasavitski.soundplayhelper.pojo.songs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SongList {

    @SerializedName("Songs")
    @Expose
    private List<Song> songs = null;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("Details")
    @Expose
    private String details;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}