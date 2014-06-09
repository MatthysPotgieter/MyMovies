/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zues.mymovies;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mpotgieter
 */
@Stateless
public class MovieEJB {
    @PersistenceContext(unitName = "default")
    private EntityManager em;
    
    public List<Movie> findAll()
    {
       Query Q = em.createQuery("Select M from Movie M");
       
       return Q.getResultList();
    }
    public void saveMovie(Movie movie)
    {
        if (movie.getId() == null)
        {
            em.persist(movie);
        }
        else
        {
            em.merge(movie);
        }
    }
}
