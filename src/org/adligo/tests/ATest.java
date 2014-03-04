package org.adligo.tests;



import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.adligo.i.log.shared.Log;
import org.adligo.i.log.shared.LogFactory;
import org.adligo.jse.util.JSECommonInit;

/**
 *  Title:
 * Description:   This is the default testing api for Adligo if you are writeing a test
 *               for the adligo code extend this class and use
 *               the methods in this class for your test assertions
 *
 *               Do not use the JUnit Asssert methods, for your assertions!
 *               The problem with these methods is that you they don't know when your
 *               events have finised occuring! Or the threads that your code may light up
 *               finish.
 *
 *               This class was written because the other multi threaded testers that I saw
 *               were relying on the fact that you were going to light up your threads inside the
 *               test, but what if the code you are testing lights up the threads?
 *               So here we are go ATest go
 *               
 * @deprecated NOTE this class it self is not really depricated, however it has a deprication
 *    warning because the AAssertion class should be extended instead as it is a better
 *    base class replacement for JUnit.
 *    This class will be declared final in sometime by 2018 or so, and the deprication 
 *    flag will be removed after the code base is switched over to AAssertions.
 *    
 * @author scott
 *
 */
public class ATest extends TestCase implements I_Test {
  static Log log = LogFactory.getLog(ATest.class);
  private boolean bLastTestFinished = false;
  private boolean bLastOne = false;
  private boolean bHasCalledWaiter = false;
  String sError = null;
  String sTestName;
  
  static {
	  JSECommonInit.callLogDebug(ATest.class.getName());
  }
  
  public ATest() {
	  super();
  }
  
  public ATest(String s) {
    super(s.substring(s.lastIndexOf(".") + 1 ,s.length()));
    sTestName = s;
  }

  /* call this at the end of each test method that you call!
   * if you are useing a events style test
  */
  public void waiter() {
    bHasCalledWaiter = true;
    while (!bLastTestFinished || bLastOne) {
      try {
        if (log.isInfoEnabled()) {
          log.info("*WAITING For " + super.getName() + " Events to finish ");
        }
        bLastOne = false;
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        Thread.yield();
        Thread.sleep(2000);
      } catch (InterruptedException x) {
    	  log.error(x.getMessage(), x);
    	  assertTrue(x.getMessage(), false);
      }
    }
    if (sError != null) {
      super.assertTrue(sError, false);
    }
  }

  public void logStart() {
    log.warn("test " + sTestName + " is starting\n\n\n\n\n");
  }
  
  public void setLastTestFinished() {
    bLastOne = true;
    bLastTestFinished = true;
    log.warn("test " + sTestName + " is finished");
  }

  public void setError(String s) {
    sError = s;
    if (!bHasCalledWaiter) {
      super.assertTrue(sError, false);
    }
    System.out.println("test " + sTestName + ".setError reports \n" + s);
    setLastTestFinished();
  }


  /**
   * checks to see if the int pi is in the int array iTestOne
   * also returns true if iTestOne contains a -1
   */
  public static boolean testThis(int [] iTestOne, int pi) {
    for (int i = 0; i < iTestOne.length; i++) {
      if (iTestOne[i] == -1 || iTestOne[i] == pi) {
        return true;
      }
    }
    return false;

  }
	
	/**
	 * tries to be intelligent and tell you which ones are missing
	 * in the error message for junit
	 * @param expected
	 * @param actual
	 */
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
		if (log.isDebugEnabled()) {
			log.debug("actual objects " + actual);
			log.debug("expected objects " + expected);
		}
		
	}
	
	/**
	 * tries to be intelligent and tell you which ones are missing
	 * in the error message for junit
	 * @param expected
	 * @param actual
	 */
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
		if (log.isDebugEnabled()) {
			log.debug("actual objects " + actual);
			log.debug("expected objects " + expected);
		}
		
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
}