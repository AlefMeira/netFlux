package metodo.springframework.netflux.bootstrap;

import lombok.RequiredArgsConstructor;
import metodo.springframework.netflux.Repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(
                        Flux.just("Silence of the Lambdas", "AEon Flux", "Enter the Mono<Void>",
                                "The best Spring Flux", "Load of the flux", "back of the future")
                                .map(metodo.springframework.netflux.domain.Movie::new)
                                .flatMap(movieRepository::save)

                ).subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
