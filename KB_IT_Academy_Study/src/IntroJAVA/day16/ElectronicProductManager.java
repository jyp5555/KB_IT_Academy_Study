package IntroJAVA.day16;

import java.util.ArrayList;
import java.util.Iterator;

public class ElectronicProductManager {

	ArrayList<ElectronicProduct> productList = new ArrayList<>();
	
	public void add(ElectronicProduct product) {
		productList.add(product);
	}
	
	public void delete(ElectronicProduct product) {
		Iterator products = productList.iterator();
		while(products.hasNext()) {
			ElectronicProduct currentProduct = (ElectronicProduct) products.next();
			if (currentProduct.equals(product)) {
				products.remove();
			}
		}
	}
	
	public void deleteByIndex(int pos) {
		if(pos < productList.size()-1 && pos >= 0) {
			productList.remove(pos);
		}
	}
	
	public void update(int pos, ElectronicProduct product) {
		if(pos < productList.size()-1 && pos >= 0) {
			productList.set(pos, product);
		}
	}
	
	public ArrayList<ElectronicProduct> getAllProducts() {return productList;}
	
	public ElectronicProduct getProductByIndex(int pos) {
		if(pos < productList.size()-1 && pos >= 0) {
			return productList.get(pos);
		}
		return null;
	}
	
	public ArrayList<ElectronicProduct> getProducts(String name){
		ArrayList<ElectronicProduct> result = new ArrayList<>();
		
		for(ElectronicProduct product : productList) {
			if(product.getProductName().equals(name)) {
				result.add(product);
			}
		}
		
		return result;
	}
	
	public int getSize() {return productList.size();}
}
