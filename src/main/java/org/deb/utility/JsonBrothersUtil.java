/**
 * Copyright 2015-2016 Debmalya Jash
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.deb.utility;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.JsonStringDocument;
import com.couchbase.client.java.document.RawJsonDocument;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author debmalyajash
 *
 */
public class JsonBrothersUtil {

	/**
	 * 
	 * @param key
	 *            identifier.
	 * @param gsonObject
	 *            google json object to be converted.
	 * @return couchbase JsonDocument.
	 */
	public JsonDocument convertGson2JsonDocument(final String key, final JsonObject gsonObject) {
		validateNull(key, gsonObject);
		return JsonDocument.create(key,
				com.couchbase.client.java.document.json.JsonObject.fromJson(gsonObject.toString()));
	}
	
	/**
	 * 
	 * @param key
	 * @param gsonObject
	 * @return RawJsonDocument.
	 */
	public RawJsonDocument convertGson2RawJsonDocument(final String key, final JsonObject gsonObject) {
		validateNull(key, gsonObject);
		return RawJsonDocument.create(key, gsonObject.toString());
	}
	
	/**
	 * Converts google JsonObject to couchbase JsonStringDocument.
	 * @param key
	 * @param gsonObject
	 * @return JsonStringDocument.
	 */
	public JsonStringDocument convertGson2JsonStringDocument(final String key, final JsonObject gsonObject) {
		validateNull(key, gsonObject);
		return JsonStringDocument.create(key, gsonObject.toString());
	}

	/**
	 * Converts com.google.gson.JsonObject to
	 * com.couchbase.client.java.document.json.JsonObject.
	 * 
	 * @param google
	 *            JSON object
	 * @return couchbase JSON object.
	 */
	public com.couchbase.client.java.document.json.JsonObject convertG2C(final JsonObject google) {
		validateNull(google);
		return com.couchbase.client.java.document.json.JsonObject.fromJson(google.toString());
	}

	/**
	 * Converts couchbase json object to google JsonObject.
	 * @param csonObject 
	 * @return JsonObject
	 */
	public JsonObject convertC2G(final com.couchbase.client.java.document.json.JsonObject csonObject) {
		validateCson(csonObject);
		JsonParser parser = new JsonParser();
		return (JsonObject) parser.parse(csonObject.toString());

	}

	private void validateCson(final com.couchbase.client.java.document.json.JsonObject csonObject)
			throws IllegalArgumentException {
		if (csonObject == null) {
			throw new IllegalArgumentException("Couchbase object is null");
		}
	}



	/**
	 * THis is to validate parameters.
	 * 
	 * @param key
	 *            to be stored in couchbase.
	 * @param gsonObject
	 *            Google JsonObject.
	 * @throws IllegalArgumentException
	 *             if any of the argument is null.
	 */
	private void validateNull(final String key, final JsonObject gsonObject) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException("Key is null");
		}
		validateNull(gsonObject);
	}

	/**
	 * 
	 * @param gsonObject
	 *            whether it is valid or not.
	 * @throws IllegalArgumentException
	 */
	private void validateNull(final JsonObject gsonObject) throws IllegalArgumentException {
		if (gsonObject == null) {
			throw new IllegalArgumentException("JsonObject is null");
		}
	}

}
