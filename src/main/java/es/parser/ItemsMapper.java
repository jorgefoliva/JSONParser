package main.java.es.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Jorge F. Oliva
 *
 */
public class ItemsMapper {

	public class ProductMapper {

		private Map<String, String> productMap = new HashMap<String, String>();

		public ProductMapper() {
			productMap.put("product", "product");
			productMap.put("id", "id");
			productMap.put("name", "name");
			productMap.put("sizes", "sizes");

		}

		public Map<String, String> getProductMap() {
			return productMap;
		}

		public void setProductMap(Map<String, String> productMap) {
			this.productMap = productMap;
		}

	}

}
