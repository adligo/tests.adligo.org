package org.adligo.tests;

import java.util.Collection;

/**
 * this is a another abstraction of a test class 
 * which can be used as a base class replacement for JUnit's test case
 * so that you can test things on GWT and JSE with out any recoding.
 * 
 * also see AAssertionsTests in the tests_tests project for example usage
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
	public void assertEquals(String message, char a, Object b) {
		assertEquals(message, new Character(a), b);
	}

	public void assertEquals(char a, Object b) {
		assertEquals(new Character(a), b);
	}
	
	public void assertEquals(String message, char a, char b) {
		assertEquals(message, new Character(a), new Character(b));
	}

	public void assertEquals(char a, char b) {
		assertEquals(new Character(a), new Character(b));
	}
	
	public void assertEquals(String message, Object a, char b) {
		assertEquals(message, a, new Character(b));
	}

	public void assertEquals(Object a, char b) {
		assertEquals(a, new Character(b));
	}
	
	public void assertEquals(String message, int a, Object b) {
		assertEquals(message, new Integer(a), b);
	}

	public void assertEquals(int a, Object b) {
		assertEquals(new Integer(a), b);
	}
	
	public void assertEquals(String message, int a, int b) {
		assertEquals(message, new Integer(a), new Integer(b));
	}

	public void assertEquals(int a, int b) {
		assertEquals(new Integer(a), new Integer(b));
	}
	
	public void assertEquals(String message, Object a, int b) {
		assertEquals(message, a, new Integer(b));
	}

	public void assertEquals(Object a, int b) {
		assertEquals(a, new Integer(b));
	}
	
	public void assertEquals(String message, long a, Object b) {
		assertEquals(message, new Long(a), b);
	}

	public void assertEquals(long a, Object b) {
		assertEquals(new Long(a), b);
	}
	
	public void assertEquals(String message, long a, long b) {
		assertEquals(message, new Long(a), new Long(b));
	}

	public void assertEquals(long a, long b) {
		assertEquals(new Long(a), new Long(b));
	}
	
	public void assertEquals(String message, Object a, long b) {
		assertEquals(message, a, new Long(b));
	}

	public void assertEquals(Object a, long b) {
		assertEquals(a, new Long(b));
	}
	
	public void assertEquals(String message, double a, Object b) {
		assertEquals(message, new Double(a), b);
	}

	public void assertEquals(double a, Object b) {
		assertEquals(new Double(a), b);
	}
	
	public void assertEquals(String message, double a, double b) {
		assertEquals(message, new Double(a), new Double(b));
	}

	public void assertEquals(double a, double b) {
		assertEquals(new Double(a), new Double(b));
	}
	
	public void assertEquals(String message, Object a, double b) {
		assertEquals(message, a, new Double(b));
	}

	public void assertEquals(Object a, double b) {
		assertEquals(a, new Double(b));
	}
	
	public void assertEquals(String message, float a, Object b) {
		assertEquals(message, new Float(a), b);
	}

	public void assertEquals(float a, Object b) {
		assertEquals(new Float(a), b);
	}
	
	public void assertEquals(String message, float a, float b) {
		assertEquals(message, new Float(a), new Float(b));
	}

	public void assertEquals(Object a, float b) {
		assertEquals(a, new Float(b));
	}
	
	public void assertEquals(String message, Object a, float b) {
		assertEquals(message, a, new Float(b));
	}

	public void assertEquals(float a, float b) {
		assertEquals(new Float(a), new Float(b));
	}
	
	public void assertEquals(String message, byte a, Object b) {
		assertEquals(message, new Byte(a), b);
	}

	public void assertEquals(byte a, Object b) {
		assertEquals(new Byte(a), b);
	}
	
	public void assertEquals(String message, byte a, byte b) {
		assertEquals(message, new Byte(a), new Byte(b));
	}

	public void assertEquals(byte a, byte b) {
		assertEquals(new Byte(a), new Byte(b));
	}
	
	public void assertEquals(String message, Object a, byte b) {
		assertEquals(message, a, new Byte(b));
	}

	public void assertEquals(Object a, byte b) {
		assertEquals(a, new Byte(b));
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
	
	
	public void assertNotSame(String message, Object a, Object b) {
		count++;
		test.assertIsNotSame(message, a, b);
	}

	public void assertNotSame(Object a, Object b) {
		count++;
		test.assertIsNotSame(a, b);
	}

	public void assertNotSame(String message, char a, Object b) {
		assertNotSame(message, new Character(a), b);
	}

	public void assertNotSame(char a, Object b) {
		assertNotSame(new Character(a), b);
	}
	
	public void assertNotSame(String message, char a, char b) {
		assertNotSame(message, new Character(a), new Character(b));
	}

	public void assertNotSame(char a, char b) {
		assertNotSame(new Character(a), new Character(b));
	}
	
	public void assertNotSame(String message, Object a, char b) {
		assertNotSame(message, a, new Character(b));
	}

	public void assertNotSame(Object a, char b) {
		assertNotSame(a, new Character(b));
	}
	
	public void assertNotSame(String message, int a, Object b) {
		assertNotSame(message, new Integer(a), b);
	}

	public void assertNotSame(int a, Object b) {
		assertNotSame(new Integer(a), b);
	}
	
	public void assertNotSame(String message, int a, int b) {
		assertNotSame(message, new Integer(a), new Integer(b));
	}

	public void assertNotSame(int a, int b) {
		assertNotSame(new Integer(a), new Integer(b));
	}
	
	public void assertNotSame(String message, Object a, int b) {
		assertNotSame(message, a, new Integer(b));
	}

	public void assertNotSame(Object a, int b) {
		assertNotSame(a, new Integer(b));
	}
	
	public void assertNotSame(String message, long a, Object b) {
		assertNotSame(message, new Long(a), b);
	}

	public void assertNotSame(long a, Object b) {
		assertNotSame(new Long(a), b);
	}
	
	public void assertNotSame(String message, long a, long b) {
		assertNotSame(message, new Long(a), new Long(b));
	}

	public void assertNotSame(long a, long b) {
		assertNotSame(new Long(a), new Long(b));
	}
	
	public void assertNotSame(String message, Object a, long b) {
		assertNotSame(message, a, new Long(b));
	}

	public void assertNotSame(Object a, long b) {
		assertNotSame(a, new Long(b));
	}
	
	public void assertNotSame(String message, double a, Object b) {
		assertNotSame(message, new Double(a), b);
	}

	public void assertNotSame(double a, Object b) {
		assertNotSame(new Double(a), b);
	}
	
	public void assertNotSame(String message, double a, double b) {
		assertNotSame(message, new Double(a), new Double(b));
	}

	public void assertNotSame(double a, double b) {
		assertNotSame(new Double(a), new Double(b));
	}
	
	public void assertNotSame(String message, Object a, double b) {
		assertNotSame(message, a, new Double(b));
	}

	public void assertNotSame(Object a, double b) {
		assertNotSame(a, new Double(b));
	}
	
	public void assertNotSame(String message, float a, Object b) {
		assertNotSame(message, new Float(a), b);
	}

	public void assertNotSame(float a, Object b) {
		assertNotSame(new Float(a), b);
	}
	
	public void assertNotSame(String message, float a, float b) {
		assertNotSame(message, new Float(a), new Float(b));
	}

	public void assertNotSame(Object a, float b) {
		assertNotSame(a, new Float(b));
	}
	
	public void assertNotSame(String message, Object a, float b) {
		assertNotSame(message, a, new Float(b));
	}

	public void assertNotSame(float a, float b) {
		assertNotSame(new Float(a), new Float(b));
	}
	
	public void assertNotSame(String message, byte a, Object b) {
		assertNotSame(message, new Byte(a), b);
	}

	public void assertNotSame(byte a, Object b) {
		assertNotSame(new Byte(a), b);
	}
	
	public void assertNotSame(String message, byte a, byte b) {
		assertNotSame(message, new Byte(a), new Byte(b));
	}

	public void assertNotSame(byte a, byte b) {
		assertNotSame(new Byte(a), new Byte(b));
	}
	
	public void assertNotSame(String message, Object a, byte b) {
		assertNotSame(message, a, new Byte(b));
	}

	public void assertNotSame(Object a, byte b) {
		assertNotSame(a, new Byte(b));
	}
	
	public void assertCollectionEquals(Collection<?> expected, Collection<?> actual) {
		ATest.assertCollectionEquals(expected, actual);
	}
}
