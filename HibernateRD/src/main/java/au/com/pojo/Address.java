package au.com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
	@Id
	@Column(name="phone_no")	
	private int phone_no;
	@Column(name="city")
	private String city;
	
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phoneNo) {
		phone_no = phoneNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
