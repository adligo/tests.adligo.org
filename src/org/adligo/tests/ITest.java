package org.adligo.tests;



import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

	
  /**
	 * tries to be intelligent and tell you which ones are missing
	 * in the error message for junit
	 * @param expected
	 * @param actual
	 */
	public void assertCollectionItemsEquals(Collection<?> expected, Collection<?> actual) {
		ATest.assertCollectionEquals(expected, actual);
 	}

	public static void assertCollectionEquals(Collection<?> expected, Collection<?> actual) {
		
		if (expected.size() == 0) {
			TestCase.assertEquals("The expected results are empty and the actual results contain " +
					actual, 0, actual.size());
		}
		Set<Object> a = new HashSet<Object>();
		a.addAll(expected);
		a.removeAll(actual);
		
		if (a.size() > 0) {
			TestCase.assertTrue("the expected objects " + a  + " were not contained in the actual results", false);
		} 
		a = new HashSet<Object>();
		a.addAll(actual);
		a.removeAll(expected);
		if (a.size() > 0) {
			TestCase.assertTrue("the actual objects contained the following extras " + a , false);
		}
		
		TestCase.assertEquals(expected.size(), actual.size());
		
	}
	
	/**
	 * tries to be intelligent and tell you which ones are missing
	 * in the error message for junit
	 * @param expected
	 * @param actual
	 */
	public void assertMapItemsEquals(Map<?,?> expected, Map<?,?> actual) {
		ATest.assertMapEquals(expected, actual);
 	}
	
	public static void assertMapEquals(Map<?,?> expected, Map<?,?> actual) {
		
		if (expected.size() == 0) {
			TestCase.assertEquals("The expected results are empty and the actual results contain " +
					actual, 0, actual.size());
		}
		
		Set<Object> a = new HashSet<Object>();
		a.addAll(expected.keySet());
		a.removeAll(actual.keySet());
		
		if (a.size() > 0) {
			TestCase.assertTrue("the expected Map keys " + a  + " were not contained in the actual results", false);
		}
		a = new HashSet<Object>();
		a.addAll(actual.keySet());
		a.removeAll(expected.keySet());
		if (a.size() > 0) {
			TestCase.assertTrue("the actual Map keys contained the following extras " + a , false);
		}
		
		TestCase.assertEquals("The Map sizes don't match ", 
				expected.size(), actual.size());
		
		Set<?> keys = expected.keySet(); 
		Iterator<?> it = keys.iterator();
		while (it.hasNext()) {
			Object key = it.next();
			Object valExpected = expected.get(key);
			Object valActual = actual.get(key);
			TestCase.assertEquals("The values in the maps for key " + key + " didn't match.", 
					valExpected, valActual);
			
		}
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