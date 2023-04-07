package IntroJAVA.day16;

import java.util.Date;

public class ElectronicProduct {
	private int productCode;
	private String productName;
	private int price;
	private String company;
	private Date productionDate;
	private Date salesDate;
	private String salesLocation;
	
	/**
	 * @param productCode
	 * @param productName
	 * @param price
	 * @param company
	 * @param productionDate
	 * @param salesDate
	 * @param salesLocation
	 */
	public ElectronicProduct(int productCode, String productName, int price, String company, Date productionDate,
			Date salesDate, String salesLocation) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.company = company;
		this.productionDate = productionDate;
		this.salesDate = salesDate;
		this.salesLocation = salesLocation;
	}

	public ElectronicProduct() {
		// TODO Auto-generated constructor stub
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public String getSalesLocation() {
		return salesLocation;
	}

	public void setSalesLocation(String salesLocation) {
		this.salesLocation = salesLocation;
	}

	@Override
	public String toString() {
		return "productCode = " + productCode + ", productName = " + productName + ", price = " + price
				+ ", company = " + company + ", productionDate = " + productionDate + ", salesDate = " + salesDate
				+ ", salesLocation = " + salesLocation;
	}
}

class TV extends ElectronicProduct{
	
	private String displayQuality; 
	private boolean setting;
	
	/**
	 * @param productCode
	 * @param productName
	 * @param price
	 * @param company
	 * @param productionDate
	 * @param salesDate
	 * @param salesLocation
	 * @param displayQuality
	 * @param setting
	 */
	public TV(int productCode, String productName, int price, String company, Date productionDate, Date salesDate,
			String salesLocation, String displayQuality, boolean setting) {
		super(productCode, productName, price, company, productionDate, salesDate, salesLocation);
		this.displayQuality = displayQuality;
		this.setting = setting;
	}

	@Override
	public String toString() {
		return super.toString()+", displayQuality=" + displayQuality + ", setting=" + setting ;
	}
	
	
	
}

class WashingMachine extends ElectronicProduct{
	
	private boolean drum;
	private boolean setting;
	
	/**
	 * @param productCode
	 * @param productName
	 * @param price
	 * @param company
	 * @param productionDate
	 * @param salesDate
	 * @param salesLocation
	 * @param displayQuality
	 * @param setting
	 */
	public WashingMachine(int productCode, String productName, int price, String company, Date productionDate,
			Date salesDate, String salesLocation, boolean drum, boolean setting) {
		super(productCode, productName, price, company, productionDate, salesDate, salesLocation);
		this.drum = drum;
		this.setting = setting;
	}

	public boolean isDrum() {
		return drum;
	}
	
	public void setDrum(boolean drum) {
		this.drum = drum;
	}
	
	public boolean isSetting() {
		return setting;
	}

	public void setSetting(boolean setting) {
		this.setting = setting;
	}

	@Override
	public String toString() {
		return super.toString()+", drum=" + drum + ", setting=" + setting;
	}
}
class VacuumCleaner extends ElectronicProduct{
	
	private boolean wireless;
	private int chargeDuration;
	
	public VacuumCleaner(int productCode, String productName, int price, String company, Date productionDate,
			Date salesDate, String salesLocation, boolean wireless, int chargeDuration) {
		super(productCode, productName, price, company, productionDate, salesDate, salesLocation);
		this.wireless = wireless;
		this.chargeDuration = chargeDuration;
	}

	
	public boolean isWireless() {
		return wireless;
	}
	
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	
	public int getChargeDuration() {
		return chargeDuration;
	}
	
	public void setChargeDuration(int chargeDuration) {
		this.chargeDuration = chargeDuration;
	}


	@Override
	public String toString() {
		return super.toString()+", wireless=" + wireless + ", chargeDuration=" + chargeDuration ;
	}	
}
