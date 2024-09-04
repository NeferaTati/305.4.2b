import com.test.hib.controller.findUser_Hql;
public class App
{
    public static void main( String[] args )
    {
        findUser_Hql u = new findUser_Hql();
        u.findUser();
    }
}

///String hql = "SELECT COUNT(*) FROM User U";
///List results = session.createQuery(hql).getResultList();
////System.out.println(results);





