package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Repository
public class MovieRepository {
    private Map<String,Movie> movieDB;
   private Map<String,Director> directorDB;
   private Map<String, List<String>> directormovieDB;

    public MovieRepository(Map<String, Movie> movieDB, Map<String, Director> directorDB, Map<Director, List<String>> directormovieDB) {
        this.movieDB = new HashMap<>();
        this.directorDB = new HashMap<>();
        this.directormovieDB = new HashMap<>();
    }

    public Movie getMovie(String name){
        return movieDB.get(name);
    }

    public String addMovie(Movie movie)
    {
        String name=movie.getName();
        movieDB.put(name,movie);
        return "movie added";
    }

    public String addDirector(Director director)
    {
        String name=director.getName();
        directorDB.put(name,director);
        return "director details added";
    }

    public Director getDirector(String name)
    {
        return directorDB.get(name);
    }
    public String addMovieDirectorPair(String movieName,String directorName)
    {
        if(movieDB.containsKey(movieName)&&directorDB.containsKey(directorName))
        {
            List<String> currentmovies=new ArrayList<>();
            if(directormovieDB.containsKey(directorName))
                currentmovies=directormovieDB.get(directorName);
            currentmovies.add(movieName);
            directormovieDB.put(directorName,currentmovies);

        }
        return "Added successfully";
    }
    public List<String> getMoviesByDirectorName(String directorName){
        List<String> movielist=new ArrayList<>();
        if(directormovieDB.containsKey(directorName))
            movielist=directormovieDB.get(directorName);
           return movielist;
    }

    public List<String> findAllMovies()
    {
        return new ArrayList<>(movieDB.keySet());
    }

    public String  deleteDirectorByName(String directorName)
    {
        List<String> movies=new ArrayList<>();
        if(directormovieDB.containsKey(directorName))
        {
            movies=directormovieDB.get(directorName);
            for(String movie:movies)
            {
                if(movieDB.containsKey(movie))
                    movieDB.remove(movie);
            }
        }
        directormovieDB.remove(directorName);
        return "deleted successfully";
    }

    public String  deleteAllDirectors(){
        for(String dir:directormovieDB.keySet())
        {
            List<String> movies=new ArrayList<>();
            movies=directormovieDB.get(dir);
            for(String movie:movies )
            {
                if(movieDB.containsKey(movie)) {
                    movieDB.remove(movie);
                }
            }
            directormovieDB.remove(dir);
        }
//        for(String D:directorDB.keySet())
//        {
//            directorDB.remove(D);
//        }

        return "deleted successfully";
    }
}
