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
import com.couchbase.client.java.document.RawJsonDocument;
import com.google.gson.JsonObject;

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
	 * THis is to validate parameters.
	 * @param key to be stored in couchbase.
	 * @param gsonObject Google JsonObject.
	 * @throws IllegalArgumentException if any of the argument is null.
	 */
	private void validateNull(final String key, final JsonObject gsonObject) throws IllegalArgumentException {
		if (key == null || gsonObject == null) {
			throw new IllegalArgumentException("Any of the argument is null");
		}
	}

}
