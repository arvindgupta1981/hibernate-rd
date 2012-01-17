package au.com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(name="empSeq",sequenceName="emp_seq")
@Entity
@Table(name="employee")
public class Employee {
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="emp_id")
	private int empId;
	@Column(name="emp_name")
	private String name;
	@ManyToOne
	@JoinColumn(name="dep_id")
	private Department depId;
	
	public Employee(){}	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepId() {
		return depId;
	}
	public void setDepId(Department depId) {
		this.depId = depId;
	}
	@Override
	public String toString() {
		return empId+":::"+name+":::"+depId.toString();
	}
	
}
