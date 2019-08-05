package es.importer;

public class Importador {

	private static final String PATH_PRODUCT = ".\\ficheros\\product.json";

	public Importador() {
		ProductImporter pi = new ProductImporter(PATH_PRODUCT);
		pi.doImport();

		CategoryImporter ci = new CategoryImporter();
	}

	public static void main(String[] args) {
		Importador principal = new Importador();
	}
}
