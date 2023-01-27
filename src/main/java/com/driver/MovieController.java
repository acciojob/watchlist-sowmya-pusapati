package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieservice;

    @PostMapping("/add_movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        String Response= movieservice.addMovie(movie);
        return new ResponseEntity<>(Response, HttpStatus.CREATED);
    }

    @PostMapping("/add_director")
    public ResponseEntity addDirector(@RequestBody Director director){
        String Response=movieservice.addDirector(director);
        return new ResponseEntity<>(Response,HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("directorName") String directorName)
    {
        String Response=movieservice.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(Response,HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String movieName)
    {
        Movie movie=movieservice.getMovieByName(movieName);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String directorName)
    {
        Director director=movieservice.getDirector(directorName);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String dirName)
    {
        List<String> movies=new ArrayList<>();
        movies=movieservice.getMoviesByDirectorName(dirName);
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List<String> movies=new ArrayList<>();
        movies=movieservice.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String dirname)
    {
        String Response=movieservice.deleteDirectorbyName(dirname);
        return new ResponseEntity<>(Response,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors()
    {
        String Response=movieservice.deleteAllDirectors();
        return new ResponseEntity<>(Response,HttpStatus.ACCEPTED);
    }


}
