package pavel_pratasavitski.soundplayhelper.pojo.songs;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import io.objectbox.annotation.Id;

@Entity(tableName = "songs")
public class Song implements Serializable {
//    @Id
//    public long mId;

    @SerializedName("Id")
    @PrimaryKey
    @NonNull
    private String id;
    @SerializedName("Name")
    private String name;
    @SerializedName("OriginalName")
    private String originalName;
    @SerializedName("Author")
    private String author;
    @SerializedName("Text")
    private String text;
    @SerializedName("Chords")
    private String chords;
    @SerializedName("Tempo")
    private int tempo;
    @SerializedName("ReleaseDate")
    private String releaseDate;
    @SerializedName("EditedOn")
    private String editedOn;
    @SerializedName("CreatedOn")
    private String createdOn;
    @Ignore
    @SerializedName("Tags")
    private List<Object> tags = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChords() {
        return chords;
    }

    public void setChords(String chords) {
        this.chords = chords;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(String editedOn) {
        this.editedOn = editedOn;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

}