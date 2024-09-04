public void   getmaxSalaryGroupBy()
{
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Session session = factory.openSession();
    String hql = "SELECT SUM(U.salary), U.city FROM User U GROUP BY U.city";
    TypedQuery query = session.createQuery(hql);
    List<Object[]> result =query.getResultList();
    for (Object[] o : result) {
        System.out.println("Total salary " +o[0] +" | city: "+ o[1] );
    }
}


