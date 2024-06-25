import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.MovieManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    MovieManager defaultManager = new MovieManager();
    MovieManager customManager = new MovieManager(7);

    @BeforeEach
    public void setUp() {
        defaultManager.add("Movie 1");
        defaultManager.add("Movie 2");
        defaultManager.add("Movie 3");
        defaultManager.add("Movie 4");
        defaultManager.add("Movie 5");
        defaultManager.add("Movie 6");
        defaultManager.add("Movie 7");
    }

    @Test
    public void shouldVerifyAllMoviesReturned() {
        String[] expected = {"Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5", "Movie 6", "Movie 7"};
        String[] actual = defaultManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldVerifyLastMoviesWithDefaultLimit() {
        String[] expected = {"Movie 7", "Movie 6", "Movie 5", "Movie 4", "Movie 3"};
        String[] actual = defaultManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldVerifyLastMoviesWithCustomLimit() {
        customManager.add("Movie 1");
        customManager.add("Movie 2");
        customManager.add("Movie 3");
        customManager.add("Movie 4");
        customManager.add("Movie 5");
        customManager.add("Movie 6");
        customManager.add("Movie 7");

        String[] expected = {"Movie 7", "Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        String[] actual = customManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldVerifyLastMoviesBelowCustomLimit() {
        customManager.add("Movie 1");
        customManager.add("Movie 2");
        customManager.add("Movie 3");

        String[] expected = {"Movie 3", "Movie 2", "Movie 1"};
        String[] actual = customManager.findLast();

        assertArrayEquals(expected, actual);
    }
}