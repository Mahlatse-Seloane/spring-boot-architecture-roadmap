package com.example.movierentalapi.controller;

import com.example.movierentalapi.domain.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController
{
    private final List<Movie> movies = new CopyOnWriteArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1L);

    @GetMapping
    public ResponseEntity<List<Movie>> showAllMovies()
    {
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable("id") Long id)
    {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie)
    {
        movie.setId(nextId.getAndIncrement());
        movies.add(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie)
    {
        Movie existingMovie = movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingMovie == null)
            return ResponseEntity.notFound().build();

        Movie movieToSave = new Movie(
                id,
                updatedMovie.getTitle(),
                updatedMovie.getDescription(),
                updatedMovie.getGenre(),
                updatedMovie.getDirector(),
                updatedMovie.getStarring(),
                updatedMovie.getAgeRestriction(),
                updatedMovie.getContentAlertSymbols()
        );

        int index = movies.indexOf(existingMovie);
        movies.set(index, movieToSave);

        return ResponseEntity.ok(movieToSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id)
    {
        boolean deleted = movies.removeIf(movie -> movie.getId().equals(id));

        return deleted ? ResponseEntity.noContent().build(): ResponseEntity.notFound().build();
    }
}
