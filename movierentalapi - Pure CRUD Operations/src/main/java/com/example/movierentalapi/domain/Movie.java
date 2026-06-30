package com.example.movierentalapi.domain;

import java.util.List;

public class Movie
{
    private Long id;
    private String title; //*
    private String description;
    private Genre genre; //*
    private String director; //*
    private List<String> starring; //*
    private AgeRestriction ageRestriction; //*
    private String contentAlertSymbols; //*

    public Movie()
    {
    }

    public Movie(Long id, String title, String description, Genre genre, String director, List<String> starring, AgeRestriction ageRestriction, String contentAlertSymbols)
    {
        this.contentAlertSymbols = contentAlertSymbols;
        this.ageRestriction = ageRestriction;
        this.starring = starring;
        this.director = director;
        this.genre = genre;
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Genre getGenre()
    {
        return genre;
    }

    public void setGenre(Genre genre)
    {
        this.genre = genre;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public List<String> getStarring()
    {
        return starring;
    }

    public void setStarring(List<String> starring)
    {
        this.starring = starring;
    }

    public AgeRestriction getAgeRestriction()
    {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction)
    {
        this.ageRestriction = ageRestriction;
    }

    public String getContentAlertSymbols()
    {
        return contentAlertSymbols;
    }

    public void setContentAlertSymbols(String contentAlertSymbols)
    {
        this.contentAlertSymbols = contentAlertSymbols;
    }
}
