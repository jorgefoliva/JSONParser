package es.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * @author M6891807
 *
 */
public abstract class ItemImporter {

	/**
	 * 
	 * @param pJsonObject
	 * @param pItem
	 */
	@SuppressWarnings("unchecked")
	protected void parse(JSONObject pJsonObject, Map<String, Object> pItem) {
		try {
			Iterator<String> keys = pJsonObject.keys();
			while (keys.hasNext()) {
				String key = keys.next();
				Object json = pJsonObject.get(key);
				if (json instanceof JSONObject) {
					setJSONObjectValue(pJsonObject, key, pItem);
				} else {
					setJSONNonObjectValue(pJsonObject, key, pItem);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param pJsonObject
	 * @param pKey
	 * @param pItem
	 * @throws JSONException
	 */
	private void setJSONObjectValue(JSONObject pJsonObject, String pKey, Map<String, Object> pItem)
			throws JSONException {
		JSONObject value = pJsonObject.getJSONObject(pKey);

		Map<String, Object> aux = new HashMap<>();
		parse(value, aux);
		pItem.put(pKey, aux);
	}

	/**
	 * 
	 * @param pJsonObject
	 * @param pKey
	 * @param pItem
	 * @throws JSONException
	 */
	private void setJSONNonObjectValue(JSONObject pJsonObject, String pKey, Map<String, Object> pItem)
			throws JSONException {

		JSONArray jsonArrayItemValues = pJsonObject.optJSONArray(pKey);
		if (jsonArrayItemValues == null) {
			setJSONStringValue(pJsonObject, pKey, pItem);
		} else {
			setJSONArrayValue(jsonArrayItemValues, pKey, pItem);
		}
	}

	/**
	 * 
	 * @param pJsonObject
	 * @param pKey
	 * @param pItem
	 */
	private void setJSONStringValue(JSONObject pJsonObject, String pKey, Map<String, Object> pItem) {
		String value = pJsonObject.optString(pKey);
		pItem.put(pKey, value);
	}

	/**
	 * 
	 * @param pJsonArrayItemValues
	 * @param pKey
	 * @param pItem
	 * @throws JSONException
	 */
	private void setJSONArrayValue(JSONArray pJsonArrayItemValues, String pKey, Map<String, Object> pItem)
			throws JSONException {

		Object json = pJsonArrayItemValues.get(0);
		List<Object> values = new ArrayList<>();
		if (json instanceof JSONObject) {
			for (int i = 0; i < pJsonArrayItemValues.length(); i++) {
				JSONObject jsonObject = (JSONObject) pJsonArrayItemValues.get(i);

				Map<String, Object> aux = new HashMap<>();
				parse(jsonObject, aux);

				values.add(aux);
			}
		} else {
			// TODO y si es un array de arrays????
			for (int i = 0; i < pJsonArrayItemValues.length(); i++) {
				values.add((String) pJsonArrayItemValues.get(i));
			}
		}

		pItem.put(pKey, values);
	}
}
