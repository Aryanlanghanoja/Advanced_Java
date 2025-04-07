package org.example;

import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{

    public static void Delete_User(int id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        User user = new User();
        Session session = factory.openSession();
        user = session.get(User.class , id);

        if(user != null) {
            session.beginTransaction();
            user.setPassWord("New Password");
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("User Deleted Sucessfully with ID " + id);
        }

        else {
            System.out.println("No User Exist With ID :- " + id);
        }

        session.close();
        factory.close();

        return ;
    }

    public static void Update_User(int id) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        User user = new User();
        Session session = factory.openSession();
        user = session.get(User.class , id);

        if(user != null) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("User Updated Successfully with ID " + id);
        }

        else {
            System.out.println("No User Exist With ID :- " + id);
        }

        session.close();
        factory.close();

        return ;
    }

    public static void Validate_User(String User_Name , String Password) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        String hql = "from User where user_name = :User_Name and pwd =:Password";
        Query query = session.createQuery(hql,User.class);
        query.setParameter("User_Name",User_Name);
        query.setParameter("Password",Password);

        List users = query.getResultList();
        Iterator i = users.iterator();

        while(i.hasNext()){
            User U =  (User)i.next();
            System.out.println("Your Full Name is: "+ U.getFullname());
        }
        session.getTransaction().commit();
        session.close();
        factory.close();

        return ;
    }

    public static void Create_User() {
        return ;
    }

    public static void Read_User() {
        return ;
    }

    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        User user = new User();
        user.setUserName("Aryan");
        user.setPassWord("012345678");

        Session session = factory.openSession();
//        user = session.get(User.class , "Aryan"); // get will throw exception of data is unavailable in database
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Your User Name :- ");
//        String user_name = sc.nextLine();
//        System.out.println("Enter Your Password :- ");
//        String password = sc.nextLine();

//        Validate_User(user_name , password);

//        user = session.load(User.class , 10); // it will generate dummy object if iti is unavialble
//        System.out.println("ID :- " + user.getId() + "\nName :- " + user.getUserName() + "\nPassword :- " + user.getPassWord());
//        Update_User(2);
//        System.out.println(user.getId());
        session.close();
        factory.close();
    }
}
