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
        String[] actual = manager.findAll();
        assertEquals(1, actual.length);
        assertEquals("Бладшот", actual[0]);
    }

    @Test
    void shouldAddMultipleFilmsAndFindAll() {
        FilmManager manager = new FilmManager();
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель Белград");
        String[] actual = manager.findAll();
        assertEquals(3, actual.length);
        assertEquals("Бладшот", actual[0]);
        assertEquals("Вперёд", actual[1]);
        assertEquals("Отель Белград", actual[2]);
    }

    @Test
    void shouldReturnEmptyArrayWhenNoFilms() {
        FilmManager manager = new FilmManager();
        String[] actual = manager.findLast();
        assertEquals(0, actual.length);
    }

    @Test
    void shouldFindLastWithDefaultLimit5WhenLessThan5Films() {
        FilmManager manager = new FilmManager();
        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель Белград");
        String[] actual = manager.findLast();
        assertEquals(3, actual.length);
        assertEquals("Отель Белград", actual[0]);
        assertEquals("Вперёд", actual[1]);
        assertEquals("Бладшот", actual[2]);
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
        String[] actual = manager.findLast();
        assertEquals(5, actual.length);
        assertEquals("Фильм 7", actual[0]);
        assertEquals("Фильм 6", actual[1]);
        assertEquals("Фильм 5", actual[2]);
        assertEquals("Фильм 4", actual[3]);
        assertEquals("Фильм 3", actual[4]);
    }

    @Test
    void shouldFindLastWithCustomLimit3() {
        FilmManager manager = new FilmManager(3);
        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");
        String[] actual = manager.findLast();
        assertEquals(3, actual.length);
        assertEquals("Фильм 4", actual[0]);
        assertEquals("Фильм 3", actual[1]);
        assertEquals("Фильм 2", actual[2]);
    }

    @Test
    void shouldIgnoreNullFilm() {
        FilmManager manager = new FilmManager();
        manager.add(null);
        String[] actual = manager.findAll();
        assertEquals(0, actual.length);
    }

    @Test
    void shouldIgnoreEmptyFilm() {
        FilmManager manager = new FilmManager();
        manager.add("");
        String[] actual = manager.findAll();
        assertEquals(0, actual.length);
    }

    @Test
    void shouldIgnoreWhitespaceOnlyFilm() {
        FilmManager manager = new FilmManager();
        manager.add("   ");
        String[] actual = manager.findAll();
        assertEquals(0, actual.length);
    }
}