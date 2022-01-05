package metodo.springframework.netflux.controller;

import lombok.RequiredArgsConstructor;
import metodo.springframework.netflux.domain.Movie;
import metodo.springframework.netflux.domain.MovieEvent;
import metodo.springframework.netflux.service.MovieServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/movies")
@RequiredArgsConstructor
public class  MovieController {
    private final MovieServiceImpl movieService;

    @GetMapping(path = "/{id}")
    public Mono<Movie> getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }

    @GetMapping
    public Flux<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> streamMovieEvents(@PathVariable String id) {
        return movieService.streamMovieEvents(id);
    }
}
