import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import au.com.pojo.Department;

import com.rd.base.SessionFactoryUtil;


public class Test {
	SessionFactory factory=SessionFactoryUtil.getSessionFactory();
	public static void main(String... g){
		System.out.println("Avaiable Actions \n1: New \n2: Update \n3: Delete \n4: Load \nProvide Input:");
		Scanner scanner=new Scanner(System.in); 
		if(scanner.hasNext()){
			if(scanner.nextInt()<=2){
				System.out.println("Department Name:");
				Scanner scanner2=new Scanner(System.in);
				if(scanner2.hasNext()){
					int id=new Test().add(new Department(scanner2.next()));				
					new Test().display(id);
				}
			}else if(scanner.nextInt()==3){
				System.out.println("Department Id:");
				Scanner scanner2=new Scanner(System.in);
				if(scanner2.hasNext()){
					//int id=new Test().add(new Department(scanner2.next()));				
					new Test().display(scanner2.nextInt());
				}
			}
		}		
	}	
	public int add(Department department){
		Session session= factory.openSession();		
		Transaction tx=session.beginTransaction();		
		session.saveOrUpdate(department);
		tx.commit();		
		session.close();
		return department.getDepId();
	}
	/*public void delete(int id){
		Session session= factory.openSession();		
		Transaction tx=session.beginTransaction();		
		session.delete(department);
		tx.commit();		
		session.close();
		return department.getDepId();
	}*/
	
	public void display(int id){
		Department department=null;
		Session session= factory.openSession();
		department=(Department)session.get(Department.class, id);
		System.out.println(department.getEmployees().size());
		session.close();
		//System.out.println(department);
	}
}
