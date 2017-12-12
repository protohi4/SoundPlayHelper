package pavel_pratasavitski.soundplayhelper.pojo.songs;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.objectbox.annotation.Convert;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.Transient;
import io.objectbox.converter.PropertyConverter;
import okio.Buffer;
import okio.ByteString;

@Entity
public class Song {
    @Id
    public long id;

    @SerializedName("Id")
    public String serversId;
    @SerializedName("Name")
    @Index
    public String name;
    @SerializedName("OriginalName")
    @Index
    public String originalName;
    @SerializedName("Author")
    public String author;
    @SerializedName("Text")
    public String text;
    @SerializedName("Chords")
    public String chords;
    @SerializedName("Tempo")
    public int tempo;
    @SerializedName("ReleaseDate")
    public String releaseDate;
    @SerializedName("EditedOn")
    public String editedOn;
    @SerializedName("CreatedOn")
    public String createdOn;
    public boolean isFavorite;
//    @SerializedName("Tags")
//    @Convert(converter = TagConverter.class, dbType = String.class)
    @Transient
    public List<String> tags;

    public long getId() {
        return id;
    }

    public String getServersId() {
        return serversId;
    }

    public void setServersId(String serversId) {
        this.serversId = serversId;
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

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public static class TagConverter implements PropertyConverter<List<String>, String> {

        private static final ByteString SEMICOLON = ByteString.decodeBase64(";");

        @Override
        public List<String> convertToEntityProperty(String s) {
            if (s == null) {
                return new ArrayList<>();
            }
            try {
                List<String> ids = new ArrayList<>();
                Buffer buffer = new Buffer();
                buffer.writeUtf8(s);
                long index;
                while ((index = buffer.indexOf(SEMICOLON)) != -1) {
                    ids = add(Long.parseLong(buffer.readUtf8(index - 1)), ids);
                }
                return ids;
            } catch (IOException io) {
                io.printStackTrace();
                return new ArrayList<>();
            }
        }

        public List<String> add(long id, List<String> values) {
            List<String> anotherArray = new ArrayList<>();
            anotherArray.addAll(values);
            anotherArray.add(String.valueOf(id));
            return anotherArray;
        }

        @Override
        public String convertToDatabaseValue(List<String> integers) {
            Buffer buffer = new Buffer();
            for (String value : integers) {
                buffer.write(SEMICOLON);
                buffer.writeUtf8(String.valueOf(value));
            }
            return buffer.toString();
        }
    }
}