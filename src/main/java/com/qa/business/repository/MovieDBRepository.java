package com.qa.business.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

public class MovieDBRepository implements IMovieRepository {

	private static final Logger LOGGER = Logger.getLogger(MovieDBRepository.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllMovies() {
		LOGGER.info("MovieDBRepository getAllMovies");
		Query query = em.createQuery("SELECT m FROM Movie m");
		Collection<Movie> movies = (Collection<Movie>)query.getResultList();
		return util.getJSONForObject(movies);
	}

}
