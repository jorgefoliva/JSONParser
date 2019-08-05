package es.parser;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ProductImporter extends ItemImporter {
	private String path;

	public ProductImporter(String pPath) {
		this.path = pPath;
	}

	protected Map<String, Object> doImport() {
		Map<String, Object> productMap = new HashMap<>();

		Files file = new Files(path);
		String message = file.loadFile();

		System.out.println("ORIGINAL MESSAGE: " + message);

		JSONTokener tokenizer = new JSONTokener(message);
		try {
			JSONObject json = new JSONObject(tokenizer);
			parse(json, productMap);

			System.out.println("PRODUCT MAP: " + productMap);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return productMap;
	}
}
