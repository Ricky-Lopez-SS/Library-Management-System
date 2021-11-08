/**
 * 
 */
package entity;

/**
 * @author Lopez
 *
 */
public class Borrower implements Modelable {
	
	private final String ITEMTYPE = "Borrower";

	private int cardNo;
	private String name;
	private String address;
	private String phone;

	public Borrower(int cardNo, String name, String address, String phone) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public String getItemType() {
		return ITEMTYPE;
	}
	
	@Override
	public int getVerifiableAttribute() {
		return cardNo;
	}

}
