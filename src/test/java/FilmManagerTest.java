import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    @Test
    void shouldThrowOnZeroLimit() {
        assertThrows(IllegalArgumentException.class, () -> new FilmManager(0));
    }

    @Test
    void shouldThrowOnNegativeLimit() {
        assertThrows(IllegalArgumentException.class, () -> new FilmManager(-1));
    }

    @Test
    void shouldAddOneFilmAndFindAll() {
        FilmManager manager = new FilmManager();
        manager.add("Бладшот");
        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMultipleFilmsAndFindAll() {
        FilmManager manager = new FilmManager();
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель Белград");
        String[] expected = {"Бладшот", "Вперёд", "Отель Белград"};
        String[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnEmptyArrayWhenNoFilms() {
        FilmManager manager = new FilmManager();
        String[] expected = {};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithDefaultLimit5WhenLessThan5Films() {
        FilmManager manager = new FilmManager();
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель Белград");
        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithDefaultLimit5WhenMoreThan5Films() {
        FilmManager manager = new FilmManager();
        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");
        manager.add("Фильм 5");
        manager.add("Фильм 6");
        manager.add("Фильм 7");
        String[] expected = {"Фильм 7", "Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithCustomLimit3() {
        FilmManager manager = new FilmManager(3);
        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");
        String[] expected = {"Фильм 4", "Фильм 3", "Фильм 2"};
        String[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldIgnoreNullFilm() {
        FilmManager manager = new FilmManager();
        manager.add(null);
        String[] expected = {};
        String[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldIgnoreEmptyFilm() {
        FilmManager manager = new FilmManager();
        manager.add("");
        String[] expected = {};
        String[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldIgnoreWhitespaceOnlyFilm() {
        FilmManager manager = new FilmManager();
        manager.add("   ");
        String[] expected = {};
        String[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }
}