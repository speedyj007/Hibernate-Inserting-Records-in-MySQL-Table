
package java_hibernate_inserting_records;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Java_Hibernate_Inserting_Records {


    public static void main(String[] args) {
        
        try{
            
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            
            SessionFactory sf = cfg.buildSessionFactory();
            Session s = sf.openSession();
            
            Transaction tx = s.beginTransaction();
            
            try{
            Members mem1 = new Members();
            mem1.setId(5);
            mem1.setName("Harry Ackerman");
            mem1.setAddress("6661 Hollywood Blvd");
            
            Members mem2 = new Members();        
            
            mem2.setName("Leroy Anderson");
            mem2.setAddress("1620 Vine Street");
          
            s.save(mem1);
            s.save(mem2);
            
            s.flush();
            tx.commit();
            s.close();
            sf.close();
            System.out.println("Records Successfully Inserted.");
            }
            catch(Exception ev)
            {
                tx.rollback();
            }
            
        }
        catch(Exception e)
        {
            System.out.println("An Error : "+e);
            
        }
    }
    
}
