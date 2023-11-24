package sem1.task01;

public class Book {
    //region Поля

    /**
     * Наименование
     */
    private final String title;

    /**
     * Автор
     */
    private final String author;

    /**
     * Год издания
     */
    private final int year;

    //endregion

    //region Конструкторы

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    //endregion


    //region Методы

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Наименование: '" + title + '\'' +
                ", Автор: '" + author + '\'' +
                ", Год издания: " + year +
                '}';
    }

    //endregion

}
