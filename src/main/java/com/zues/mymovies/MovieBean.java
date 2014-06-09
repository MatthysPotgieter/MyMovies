/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zues.mymovies;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author mpotgieter
 */

@ManagedBean
@ViewScoped
public class MovieBean {
    @EJB
    private MovieEJB movieEJB;
    
    private List<Movie> movieList;

    public List<Movie> getMovieList() {
              
        if (movieList == null)
        {
          movieList = movieEJB.findAll();
        }
        
        return movieList;
    }
    
   
    public void refresh()
    {
        movieList = null;
    }
    /**
     * Creates a new instance of MovieBean
     */
    public MovieBean() {
    }
}
