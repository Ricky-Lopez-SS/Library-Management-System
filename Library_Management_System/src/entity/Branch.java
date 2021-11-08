/**
 * 
 */
package entity;

/**
 * @author Lopez
 *
 */
public class Branch implements Modelable{
	
	private final String ITEMTYPE = "Branch";

	private int branchId;
	private String branchName;
	private String branchAddress;

	public Branch(int branchId, String branchName, String branchAddress) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}
	
	@Override
	public String toString() {
		return branchName;
	}
	
	@Override
	public String getItemType() {
		return ITEMTYPE;
	}
	
	@Override
	public int getVerifiableAttribute() {
		return branchId;
	}

}
