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
public abstract class AAssertions {
	private I_Test test;
	private int count = 0;
	
	/**
	 * this method should return the package that these assertions are testing
	 * ie org.adligo.models.core.shared
	 * if your were testing org.adligo.models.core.shared.EMailAddress
	 * @return
	 */
	public abstract String getPackage();
	
	public int getAssertionCount() {
		return count;
	}
	
	public I_Test getTest() {
		return test;
	}

	public void setTest(I_Test test) {
		this.test = test;
	}

	public void assertTrue(boolean p) {
		count++;
		test.assertIsTrue(p);
	}

	public void assertTrue(String message, boolean p) {
		count++;
		test.assertIsTrue(message, p);
	}

	public void assertFalse(boolean p) {
		count++;
		test.assertIsFalse(p);
	}

	public void assertFalse(String message, boolean p) {
		count++;
		test.assertIsFalse(message, p);
	}

	public void assertEquals(String message, Object a, Object b) {
		count++;
		test.assertIsEquals(message, a, b);
	}

	public void assertEquals(Object a, Object b) {
		count++;
		test.assertIsEquals(a, b);
	}

	public void assertIsNull(String message, Object a) {
		count++;
		test.assertIsNull(message, a);
	}

	public void assertNull(Object a) {
		count++;
		test.assertIsNull(a);
	}

	public void assertNotNull(String message, Object a) {
		count++;
		test.assertIsNotNull(message, a);
	}

	public void assertNotNull(Object a) {
		count++;
		test.assertIsNotNull(a);
	}
	
	
	
}
