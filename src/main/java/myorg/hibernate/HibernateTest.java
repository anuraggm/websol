package myorg.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import myorg.hibernate.dto.Address;
import myorg.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails usr = new UserDetails();
		UserDetails usr1 = new UserDetails();
		
		Address adr = new Address();
		adr.setStreet("Roselea St");
		adr.setCity("Caulfield South");
		adr.setState("VIC");
		adr.setPincode("3162");
		
		Address adr1 = new Address();
		adr1.setStreet("Garden Avenue");
		adr1.setCity("Glen Huntly");
		adr1.setState("VIC");
		adr1.setPincode("3163");
		
		
	//	usr.setUserID(2);
		usr.setUserName("Anurag");
	//	usr.setHomeAddress(adr);
	//	usr.setOffAddress(adr1);
		usr.setJoinDate(new Date());
		usr.setDesc("Employee 1");
		usr.getListOfAddress().add(adr);
		usr.getListOfAddress().add(adr1);
		
	//	usr1.setUserName("Bindu");
	//	usr1.setAddress(adr1);
	//	usr1.setJoinDate(new Date());
	//	usr1.setDesc("Employee 2");
		
		
		/*Session factory is created only once as it is costly, it takes lot of resources */
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
	//    s.beginTransaction();
		s.save(usr);
	//	s.save(usr1);
		s.beginTransaction().commit();
		s.clear();
	//	s.close();
		
		
	//	usr=null;
	//	Session s1 = sf.openSession();
	//	s1.beginTransaction();
		/* Generally the 2nd Arguement is the Primary key , here its the user_id */
		
	//	usr=(UserDetails)s1.get(UserDetails.class, 1);
	//	System.out.println("User Details:\n" + "UserName:"+ usr.getUserName() + "\n" + "Descrption:" + usr.getDescr());
    //	s1.close();
		
	}

}
