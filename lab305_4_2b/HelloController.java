package org.example.lab305_4_2b;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public static void findUserHql(SessionFactory factory,Session session) {
    String hqlFrom = "FROM User"; // Example of HQL to get all records of user class
    String hqlSelect = "SELECT u FROM User u";
    TypedQuery<User> query = session.createQuery(hqlFrom, User.class);
    List<User> results = query.getResultList();

    System.out.printf("%s%13s%17s%34s%n","|User Id","|Full name","|Email","|Password");
    for (User u:results) {
        System.out.printf(" %-10d %-20s %-30s %s %n", u.getId(), u.getFullName(), u.getEmail(), u.getPassword());
    }
}

ublic static void getRecordById(SessionFactory factory, Session session) {
    String hql = "FROM User u WHERE u.id > 2 ORDER BY u.salary DESC";
    TypedQuery<User> query = session.createQuery(hql, User.class);
    List<User> results = query.getResultList();
    System.out.printf("%s%13s%17s%34s%21s%n", "|User Id", "|Full name", "|Email", "|Password", "|Salary");
    for (User u : results) {
        System.out.printf(" %-10d %-20s %-30s %-23s %s %n", u.getId(), u.getFullName(), u.getEmail(), u.getPassword(), u.getSalary());
    }
}
public static void getRecords (Session session) {
    TypedQuery<Object[]> query = session.createQuery(
            "SELECT U.salary, U.fullName FROM User AS U", Object[].class);
    List<Object[]> results = query.getResultList();
    System.out.printf("%s%13s%n","Salary","City");
    for (Object[] a : results) {
        System.out.printf("%-16s%s%n",a[0],a[1]);
    }
}public static void getMaxSalary(Session session) {
    String hql = "SELECT max(U.salary) FROM User U";
    TypedQuery<Object> query = session.createQuery(hql,Object.class);
    Object result = query.getSingleResult();
    System.out.printf("%s%s","Maximum Salary:",result);
}

public static void namedQueryExample(Session session) {
    String hql = "FROM User u WHERE u.id = :id";
    TypedQuery<User> query = session.createQuery(hql, User.class);
    query.setParameter("id", 2);
    List<User> result = query.getResultList();

    System.out.printf("%s%13s%17s%34s%21s%n", "|User Id", "|Full name", "|Email", "|Password", "|Salary");
    for (User u : result) {
        System.out.printf(" %-10d %-20s %-30s %-23s %s %n", u.getId(), u.getFullName(), u.getEmail(), u.getPassword(), u.getSalary());
    }
}







