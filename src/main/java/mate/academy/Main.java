package mate.academy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import mate.academy.lib.Injector;
import mate.academy.model.Movie;
import mate.academy.model.MovieSession;
import mate.academy.service.MovieService;
import mate.academy.service.MovieSessionService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate.academy");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) INJECTOR.getInstance(MovieService.class);

        Movie myMovie = movieService.add(new Movie("Mykola"));
        Movie myMovie2 = movieService.add(new Movie("Mykola2"));
        Movie myMovie3 = movieService.add(new Movie("Mykola3"));

        MovieSession myMovieSession = new MovieSession();
        MovieSession myMovieSession2 = new MovieSession();
        MovieSession myMovieSession3 = new MovieSession();
        myMovieSession.setMovie(myMovie);
        myMovieSession2.setMovie(myMovie2);
        myMovieSession3.setMovie(myMovie3);
        LocalDateTime time
                = LocalDateTime.of(2024, 4, 1, 10, 30);
        LocalDateTime time2
                = LocalDateTime.of(2024, 4, 2, 10, 30);
        LocalDateTime time3
                = LocalDateTime.of(2024, 4, 3, 10, 30);
        myMovieSession.setShowTime(time);
        myMovieSession2.setShowTime(time2);
        myMovieSession3.setShowTime(time3);

        MovieSessionService movieSessionService
                = (MovieSessionService) INJECTOR.getInstance(MovieSessionService.class);

        movieSessionService.add(myMovieSession);
        movieSessionService.add(myMovieSession2);
        movieSessionService.add(myMovieSession3);

        LocalDate date = LocalDate.of(2024, 4, 1);
        System.out.println("Available session"
                + movieSessionService.findAvailableSessions(myMovie.getId(), date));
        System.out.println("Available session"
                + movieSessionService.findAvailableSessions(myMovie2.getId(), date));
        System.out.println("Available session"
                + movieSessionService.findAvailableSessions(myMovie3.getId(), date));

    }
}
