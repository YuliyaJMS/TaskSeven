public class FilmManager {
    private String[] films;
    private int limit;
    private int currentSize;

    public FilmManager() {
        this(5);
    }

    public FilmManager(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Лимит должен быть больше 0");
        }
        this.limit = limit;
        this.films = new String[100];
        this.currentSize = 0;
    }

    public int getLimit() {
        return limit;
    }

    public void add(String film) {
        if (film == null || film.trim().isEmpty()) {
            return;
        }
        films[currentSize] = film;
        currentSize++;
    }

    public String[] findAll() {
        String[] result = new String[currentSize];
        for (int i = 0; i < currentSize; i++) {
            result[i] = films[i];
        }
        return result;
    }

    public String[] findLast() {
        int resultLength = Math.min(limit, currentSize);
        String[] result = new String[resultLength];

        for (int i = 0; i < resultLength; i++) {
            int indexFromEnd = currentSize - 1 - i;
            result[i] = films[indexFromEnd];
        }

        return result;
    }
}