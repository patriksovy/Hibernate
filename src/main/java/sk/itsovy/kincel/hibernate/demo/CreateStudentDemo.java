package sk.itsovy.kincel.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.kincel.hibernate.demo.entity.Student;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();

        try {
            System.out.println("Creating new Student object");
            Student student=new Student("Patrik","Kincel","patrik@kincel.com");
            session.beginTransaction();
            System.out.println("Student saving");
            session.save(student);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
