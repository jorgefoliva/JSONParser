package es.parser;

public class JSONParser {

	private static final String PATH_PRODUCT = ".\\ficheros\\product.json";

	public JSONParser() {
		ProductImporter pi = new ProductImporter(PATH_PRODUCT);
		pi.doImport();

		CategoryImporter ci = new CategoryImporter();
	}

	public static void main(String[] args) {
		JSONParser principal = new JSONParser();
	}
}