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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author debmalyajash
 *
 */
public class TestUtil {
	public static final String JSON_STR = "{" + "\"glossary\":{" + "\"title\":\"example glossary\"," + "\"GlossDiv\":{"
			+ "\"title\":\"S\"," + "\"GlossList\":{" + "\"GlossEntry\":{" + "\"ID\":\"SGML\"," + "\"SortAs\":\"SGML\","
			+ "\"GlossTerm\":\"Standard Generalized Markup Language\"," + "\"Acronym\":\"SGML\","
			+ "\"Abbrev\":\"ISO 8879:1986\"," + "\"GlossDef\":{"
			+ "\"para\":\"A meta-markup language, used to create markup languages such as DocBook.\","
			+ "\"GlossSeeAlso\":[\"GML\",\"XML\"]" + "}," + "\"GlossSee\":\"markup\"" + "}" + "}" + "}" + "}" + "}";

	public static final String GSON_STR = "{\"glossary\":{\"title\":\"example glossary\",\"GlossDiv\":{\"title\":\"S\",\"GlossList\":{\"GlossEntry\":{\"GlossTerm\":\"Standard Generalized Markup Language\",\"GlossSee\":\"markup\",\"SortAs\":\"SGML\",\"GlossDef\":{\"para\":\"A meta-markup language, used to create markup languages such as DocBook.\",\"GlossSeeAlso\":[\"GML\",\"XML\"]},\"ID\":\"SGML\",\"Acronym\":\"SGML\",\"Abbrev\":\"ISO 8879:1986\"}}}}}";

	public static final JsonObject JSON_OBJ = createJsonObject(JSON_STR);

	public static final String KEY = "1234567890";

	/**
	 * Create JsonObject from json string.
	 * 
	 * @param jsonString
	 *            to be converted.
	 * @return JsonObject.
	 */
	public static JsonObject createJsonObject(final String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject value = parser.parse(jsonString).getAsJsonObject();
		return value;
	}

}
