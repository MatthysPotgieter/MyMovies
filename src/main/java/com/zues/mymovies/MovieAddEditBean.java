/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zues.mymovies;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author mpotgieter
 */
@ManagedBean
@ViewScoped
public class MovieAddEditBean {
    @EJB
    private MovieEJB movieEJB;
    @ManagedProperty(value = "#{movieBean}")
    MovieBean movieBean;

    public MovieBean getMovieBean() {
        return movieBean;
    }

    public void setMovieBean(MovieBean movieBean) {
        this.movieBean = movieBean;
    }
   
    private Movie movie;

    public Movie getMovie() {
        if (movie == null)
        {
            movie = new Movie();
        }
        return movie;
    }
    public void saveMovie()
    {
        movieEJB.saveMovie(movie);
        movieBean.refresh();
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
 
    public void initAdd(){
        System.out.println("initAdd");
        movie = new Movie();
    }
    public void initEdit(Movie movie)
    {
        System.out.println("initEdit");
        this.movie = movie;
    }
}
