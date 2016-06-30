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

import org.junit.Assert;
import org.junit.Test;

import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.RawJsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

/**
 * @author debmalyajash
 *
 */
public class JsonBrothersUtilTest {

	/**
	 * Test method for
	 * {@link org.deb.utility.JsonBrothersUtil#convertGson2JsonDocument(java.lang.String, com.google.gson.JsonObject)}
	 * .
	 */
	@Test
	public void testConvertGson2JsonDocument() {
		JsonBrothersUtil util = new JsonBrothersUtil();
		try {
			util.convertGson2JsonDocument(null, null);
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("Test for IllegalArgumentException", true);
		}

		try {
			JsonDocument value = util.convertGson2JsonDocument(TestUtil.KEY, TestUtil.JSON_OBJ);
			Assert.assertNotNull(value);
			Assert.assertEquals(TestUtil.KEY, value.id());
			Assert.assertEquals(TestUtil.GSON_STR, value.content().toString());
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("IllegalArgumentException not expected", false);
		}
	}

	/**
	 * Test method for
	 * {@link org.deb.utility.JsonBrothersUtil#convertGson2RawJsonDocument(java.lang.String, com.google.gson.JsonObject)}
	 * .
	 */
	@Test
	public void testConvertGson2RawJsonDocument() {
		JsonBrothersUtil util = new JsonBrothersUtil();
		try {
			util.convertGson2RawJsonDocument(null, null);
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("Test for IllegalArgumentException", true);
		}

		try {
			util.convertGson2RawJsonDocument(null, TestUtil.createJsonObject(TestUtil.JSON_STR));
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("Test for IllegalArgumentException", true);
		}

		try {
			util.convertGson2RawJsonDocument(TestUtil.KEY, null);
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("Test for IllegalArgumentException", true);
		}

		try {
			RawJsonDocument value = util.convertGson2RawJsonDocument(TestUtil.KEY, TestUtil.JSON_OBJ);
			Assert.assertNotNull(value);
			Assert.assertEquals(TestUtil.KEY, value.id());
			Assert.assertEquals(TestUtil.JSON_STR, value.content());
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("IllegalArgumentException not expected", false);
		}
	}

	/**
	 * Test method for
	 * {@link org.deb.utility.JsonBrothersUtil#convertGson2RawJsonDocument(com.google.gson.JsonObject)}
	 * .
	 */
	@Test
	public void testG2C() {
		JsonBrothersUtil util = new JsonBrothersUtil();
		try {
			util.convertG2C(null);
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue(true);
		}

		JsonObject value = util.convertG2C(TestUtil.JSON_OBJ);
		System.out.println(value);
	}

}
