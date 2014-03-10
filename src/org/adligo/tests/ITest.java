package org.adligo.tests;



import junit.framework.TestCase;

import org.adligo.tests.shared.I_Test;

/**
 *  Title:
 * Description:   This is a basic impl of I_Test
 *          
 * @author scott
 *
 */
public abstract class ITest extends TestCase implements I_Test {
	private String sTestName;
  
  
  public ITest() {
	  super();
  }
  
  public ITest(String s) {
    super(s.substring(s.lastIndexOf(".") + 1 ,s.length()));
    sTestName = s;
  }

	
	

	@Override
	public void assertIsEquals(Object a, Object b) {
		assertEquals(a, b);
	}

	@Override
	public void assertIsEquals(String message, Object a, Object b) {
		assertEquals(message, a, b);
	}

	@Override
	public void assertIsFalse(boolean p) {
		assertFalse(p);
	}

	@Override
	public void assertIsFalse(String message, boolean p) {
		assertFalse(message, p);
	}

	@Override
	public void assertIsNotNull(Object a) {
		assertNotNull(a);
	}

	@Override
	public void assertIsNotNull(String message, Object a) {
		assertNotNull(message, a);
	}

	@Override
	public void assertIsNull(Object a) {
		assertNull(a);
	}

	@Override
	public void assertIsNull(String message, Object a) {
		assertNull(message, a);
	}

	@Override
	public void assertIsTrue(boolean p) {
		assertTrue(p);
	}

	@Override
	public void assertIsTrue(String message, boolean p) {
		assertTrue(message, p);
	}

	@Override
	public void assertIsNotSame(String message, Object a, Object b) {
		assertNotSame(message,  a, b);
	}

	@Override
	public void assertIsNotSame(Object a, Object b) {
		assertNotSame(a, b);
	}

	@Override
	public void assertIsNotEquals(String message, Object a, Object b) {
		assertFalse(message, a.equals(b));
	}

	@Override
	public void assertIsNotEquals(Object a, Object b) {
		assertFalse("Expected the following not to be equal;\n" + a + "\n" + b, a.equals(b));
	}
}