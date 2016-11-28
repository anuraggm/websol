package myorg.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="User_Table")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_ID")
	private int userID;
	private String userName;
	/* This field will not be created and saved if it is under annotation @Transient */
	/*@Transient */
	/*private String Address;*/
	/*Below is address override embedded from Address.java that is one from Embeddable */
/*	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="Street",column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride(name="City",column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride(name="State",column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride(name="pincode",column=@Column(name="HOME_PIN_CODE"))
	})
	private Address HomeAddress;
	
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="Street",column=@Column(name="OFF_STREET_NAME")),
	@AttributeOverride(name="City",column=@Column(name="OFF_CITY_NAME")),
	@AttributeOverride(name="State",column=@Column(name="OFF_STATE_NAME")),
	@AttributeOverride(name="pincode",column=@Column(name="OFF_PIN_CODE"))
	})
	private Address OffAddress; */
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",
	joinColumns=@JoinColumn(name="F_USER_ID"))
/*	private Set<Address> listOfAddress = new HashSet<Address>(); */
	
    @GenericGenerator(name="increment", strategy ="increment")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "increment", type = @Type(type="long") )
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
	
	/* This will avoid creating the field as timestamp in database */
	@Temporal(TemporalType.DATE)
	private Date JoinDate;
	
	/*This will enable the Description be created as LOB object rather that varchar(255) */
	@Column(name="Description")
	/* @Lob */
	private String Descr;
	
	
	
public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	/*	public Set<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}*/
	@Column(name="JoinDate")
	public Date getJoinDate() {
		return JoinDate;
	}
	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}
	
	public String getDescr() {
		return Descr;
	}
	
	public void setDesc(String desc) {
		this.Descr = desc;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName + "from the setter";
	}
/*	public Address getHomeAddress() {
		return HomeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		HomeAddress = homeAddress;
	}
	public Address getOffAddress() {
		return OffAddress;
	}
	public void setOffAddress(Address offAddress) {
		OffAddress = offAddress;
	}*/
	
}
