/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dvdcollection;

/**
 *
 * @author apprentice
 */
public class DVDDTO {
    
    private String title;
    private String releaseDate;
    private String rating;
    private String director;
    private String studio;
    private String note;
    private String movie;
    
    public DVDDTO(String movie)
    {
        this.movie = movie;
    }
    
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getReleaseDate()
    {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }
    public String getRating()
    {
        return rating;
    }
    public void setRating(String rating)
    {
        this.rating = rating;
    }
    public String getStudio()
    {
        return studio;
    }
    public void setStudio(String studio)
    {
        this.studio = studio;
    }
    public String getNote()
            {
                return note;
            }
    public void setNote(String note)
    {
        this.note= note;
    }
}