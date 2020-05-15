package com.example.android.faithhub;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "publication_table")
public class Publication {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;


    private String author;
    private String title;
    private String series;
    private String summary;
    private String imageSrc;
    private int pub_year;
    private long datePublished;
    private int pages;
    private int size;
    private boolean article;
    private boolean book;

    public Publication(String author, String title, String series, String summary, String imageSrc, int pub_year, long datePublished, int pages, int size, boolean article, boolean book) {
        this.author = author;
        this.title = title;
        this.series = series;
        this.summary = summary;
        this.imageSrc = imageSrc;
        this.pub_year = pub_year;
        this.datePublished = datePublished;
        this.pages = pages;
        this.size = size;
        this.article = article;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSummary() {
        return summary;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPub_year() {
        return pub_year;
    }

    public void setPub_year(int pub_year) {
        this.pub_year = pub_year;
    }

    public long getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(long datePublished) {
        this.datePublished = datePublished;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isArticle() {
        return article;
    }

    public void setArticle(boolean article) {
        this.article = article;
    }

    public boolean isBook() {
        return book;
    }

    public void setBook(boolean book) {
        this.book = book;
    }
}
