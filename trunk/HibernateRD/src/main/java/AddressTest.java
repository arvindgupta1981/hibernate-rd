import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import au.com.pojo.Address;

import com.rd.base.SessionFactoryUtil;


public class AddressTest {
	SessionFactory factory=SessionFactoryUtil.getSessionFactory();
	public static void main(String...f){
			new AddressTest().add();
	}
	private int add(){
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();	
		Address address=new Address();
		address.setPhone_no(989);
		address.setCity("Delhi");
		session.save(address);
		tx.commit();
		System.out.println(address.getPhone_no());
		session.close();
		return 0;
	}
}
