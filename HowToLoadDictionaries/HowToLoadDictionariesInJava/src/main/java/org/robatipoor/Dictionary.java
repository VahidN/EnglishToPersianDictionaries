package org.robatipoor;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Dictionary
 */
public class Dictionary {
    @SerializedName("Group")
    private char group;
    @SerializedName("Entries")
    private int entries;
    @SerializedName("Words")
    private Word[] words;

    public Dictionary() {
    }

    public Dictionary(char group, int entries, Word[] words) {
        this.group = group;
        this.entries = entries;
        this.words = words;
    }

    public char getGroup() {
        return this.group;
    }

    public void setGroup(char group) {
        this.group = group;
    }

    public int getEntries() {
        return this.entries;
    }

    public void setEntries(int entries) {
        this.entries = entries;
    }

    public Word[] getWords() {
        return this.words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public Dictionary group(char group) {
        this.group = group;
        return this;
    }

    public Dictionary entries(int entries) {
        this.entries = entries;
        return this;
    }

    public Dictionary words(Word[] words) {
        this.words = words;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dictionary)) {
            return false;
        }
        Dictionary dictionary = (Dictionary) o;
        return group == dictionary.group && entries == dictionary.entries && Objects.equals(words, dictionary.words);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, entries, words);
    }

    @Override
    public String toString() {
        return "{" +
            " group='" + getGroup() + "'" +
            ", entries='" + getEntries() + "'" +
            ", words='" + getWords() + "'" +
            "}";
    }
}