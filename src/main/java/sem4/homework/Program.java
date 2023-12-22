package sem4.homework;

import sem4.homework.models.CoursesDB;

public class Program {

    /**
     * Задание
     * =======
     * Создайте базу данных (например, SchoolDB).
     * В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.
     * Настройте Hibernate для работы с вашей базой данных.
     * Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.
     * Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.
     * Убедитесь, что каждая операция выполняется в отдельной транзакции.
     */

    public static void main(String[] args) {
        CoursesDB.sessionConnector();
        CoursesDB.fillingData();
        CoursesDB.gettingDataFromTable();
        CoursesDB.changingObjects();
        CoursesDB.deleteOb();
    }

}
