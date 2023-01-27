package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movierepository;
    public String addMovie(Movie movie)
    {
        return movierepository.addMovie(movie);
    }
    public String addDirector(Director director)
    {
        return movierepository.addDirector(director);
    }
    public String addMovieDirectorPair(String Mname,String Dname)
    {
        return movierepository.addMovieDirectorPair(Mname,Dname);
    }
    public Movie getMovieByName(String Mname)
    {
        return movierepository.getMovie(Mname);
    }
    public Director getDirector(String Dname)
    {
        return movierepository.getDirector(Dname);
    }
    public List<String> getMoviesByDirectorName(String Dname)
    {
        return movierepository.getMoviesByDirectorName(Dname);
    }
    public List<String> findAllMovies()
    {
        return movierepository.findAllMovies();
    }
    public String deleteDirectorbyName(String Dname)
    {
        return movierepository.deleteDirectorByName(Dname);
    }
    public String deleteAllDirectors()
    {
        return movierepository.deleteAllDirectors();
    }
}
