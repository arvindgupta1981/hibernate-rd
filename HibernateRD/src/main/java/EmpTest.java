import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import au.com.pojo.Department;
import au.com.pojo.Employee;

import com.rd.base.SessionFactoryUtil;


public class EmpTest {
	SessionFactory factory=SessionFactoryUtil.getSessionFactory();
	public static void main(String[] args) {
		Employee emp=new Employee();
		emp.setName("Sobhita");
		new EmpTest().add(emp, 300);
	}
	private int add(Employee emp,int depId){
		
		Session session= factory.openSession();
		Transaction tx=session.beginTransaction();
		emp.setDepId((Department)session.load(Department.class, depId));
		session.save(emp);
		System.out.println(emp.getDepId().getName());
		int id=emp.getEmpId();
		tx.commit();
		session.close();
		System.out.println(id);
		return id;
	}
	

	

}
