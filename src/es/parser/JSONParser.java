package es.parser;

/**
 * 
 * @author Jorge F. Oliva
 *
 */
public class JSONParser {

	private static final String PATH_PRODUCT = ".\\data\\product.json";

	public JSONParser() {
		ProductImporter pi = new ProductImporter(PATH_PRODUCT);
		pi.doImport();

	}

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
	}
}