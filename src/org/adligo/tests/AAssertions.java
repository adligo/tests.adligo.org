package org.adligo.tests;

/**
 * this is a another abstraction of a test class 
 * which can be used as a base class replacement for JUnit's test case
 * so that you can test things on GWT and JSE with out any recoding.
 * 
 * 
 * @author scott
 *
 */
public class AAssertions {
	private I_Test test;

	public I_Test getTest() {
		return test;
	}

	public void setTest(I_Test test) {
		this.test = test;
	}

	public void assertTrue(boolean p) {
		test.assertIsTrue(p);
	}

	public void assertTrue(String message, boolean p) {
		test.assertIsTrue(message, p);
	}

	public void assertFalse(boolean p) {
		test.assertIsFalse(p);
	}

	public void assertFalse(String message, boolean p) {
		test.assertIsFalse(message, p);
	}

	public void assertEquals(String message, Object a, Object b) {
		test.assertIsEquals(message, a, b);
	}

	public void assertEquals(Object a, Object b) {
		test.assertIsEquals(a, b);
	}

	public void assertIsNull(String message, Object a) {
		test.assertIsNull(message, a);
	}

	public void assertNull(Object a) {
		test.assertIsNull(a);
	}

	public void assertNotNull(String message, Object a) {
		test.assertIsNotNull(message, a);
	}

	public void assertNotNull(Object a) {
		test.assertIsNotNull(a);
	}
	
	
	
}
