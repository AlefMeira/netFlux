package metodo.springframework.netflux.service;

import metodo.springframework.netflux.Repository.MovieRepository;
import metodo.springframework.netflux.domain.Movie;
import metodo.springframework.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {
    Mono<Movie> getMovieById(String id);

    Flux<Movie> getAllMovies();

    Flux<MovieEvent> streamMovieEvents(String id);


}
