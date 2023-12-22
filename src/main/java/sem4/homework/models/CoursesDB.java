package sem4.homework.models;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


import java.sql.*;
import java.util.List;

public class CoursesDB {

    static String url = "jdbc:mysql://localhost:3306/";
    static String user = "root";
    static String password = "admin";

    public static void sessionConnector() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            Statement statement =connection.createStatement();
            statement.execute("CREATE SCHEMA `schoolDB`");
            statement.execute("CREATE TABLE `schoolDB`.`courses`(`id` INT NOT NULL AUTO_INCREMENT ,`title` VARCHAR(50) NULL, `duration` INT NULL,PRIMARY KEY(`id`));");




        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillingData(){
        ConnectorHW connectorHW = new ConnectorHW();
        Session session = connectorHW.getSession();
        Courses courses = new Courses("Математика",10);
        session.beginTransaction();
        session.save(courses);
        courses = new Courses("Химия",2);
        session.save(courses);
        courses = new Courses("Ин-яз",12);
        session.save(courses);
        session.getTransaction().commit();
        session.save(courses);
        session.close();

    }

    public static void gettingDataFromTable(){
        ConnectorHW connector = new ConnectorHW();
        try (Session session = connector.getSession()){
            List<Courses> books = session.createQuery("FROM Courses ", Courses.class).getResultList();
            books.forEach(b -> {
                System.out.println(b);
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changingObjects(){
        ConnectorHW connector = new ConnectorHW();
        try (Session session = connector.getSession()){
            //строка хранит запрос на языке hql
            String hql = "from Courses where id = :id";
            Query<Courses> query = session.createQuery(hql, Courses.class);
            query.setParameter("id",4);
            Courses courses = query.getSingleResult();
            System.out.println(courses);
            courses.setDuration(70);
            courses.setTitle("Черчение");
            session.beginTransaction();
            session.update(courses);
            query.setParameter("id",4);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteOb(){
        ConnectorHW connectorHW = new ConnectorHW();
        try (Session session = connector.getSession()){
            Transaction t = session.beginTransaction();
            List<Courses> courses = session.createQuery("FROM Courses ", Courses.class).getResultList();
            courses.forEach(m-> {
                session.delete(m);
            });
            t.commit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
