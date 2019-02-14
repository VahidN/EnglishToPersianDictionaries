package org.robatipoor;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Word
 */
public 
class Word {
    @SerializedName("EnglishWord")
    private String englishWord;
    @SerializedName("Meanings")
    private String[] meanings;

    public Word() {
    }

    public Word(String englishWord, String[] meanings) {
        this.englishWord = englishWord;
        this.meanings = meanings;
    }

    public String getEnglishWord() {
        return this.englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String[] getMeanings() {
        return this.meanings;
    }

    public void setMeanings(String[] meanings) {
        this.meanings = meanings;
    }

    public Word englishWord(String englishWord) {
        this.englishWord = englishWord;
        return this;
    }

    public Word meanings(String[] meanings) {
        this.meanings = meanings;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Word)) {
            return false;
        }
        Word word = (Word) o;
        return Objects.equals(englishWord, word.englishWord) && Objects.equals(meanings, word.meanings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(englishWord, meanings);
    }

    @Override
    public String toString() {
        return "{" + " englishWord='" + getEnglishWord() + "'" + ", meanings='" + getMeanings() + "'" + "}";
    }

}