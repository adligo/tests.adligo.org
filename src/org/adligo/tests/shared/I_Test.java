package org.adligo.tests.shared;

import java.util.Collection;
import java.util.Map;

/**
 * Note this allows you to use code to assert;
 * 1) jse platform using junit 
 * 2) later on when your running gwtunit (which runs in javascript)
 * to call the same code you called on the jse platform
 * 
 * To use this class have your jse tests project
 * include a gwt xml file (ie with a client dir)
 * src/
 *    MyJunitTest.java (extends ATest)
 *    MYGwtLib.gwt.xml
 *    classes
 *        MyAssertionClass.java
 * 
 * Then to facilitate #1 MyJunitTest.java calls a method like
 *      assertSomething((I_Test) this);
 *      on MyAssertionClass.java
 *      
 * Later on in a gwtunit project with a structure like
 * src/
 *    MyGwtUnitTest.java  (extends AGwtTest also note AGwtTest was moved to the gwtunit_tests.adligo.org project) 
 *      MyGwtUnitTest.java can call MyAssertionClass.java
 * 		http://www.gwtproject.org/doc/latest/DevGuideTesting.html
 * 
 * This insures that any discrepancy between jse running your code and gwt
 *   running your code can be delt with by reusing the assertions.
 *   
 * As of this comment I have never seen any discrepancies and believe JUnit
 * should be preferred to GWTUnit for the following reasons;
 * 1) Code Coverage with ecl Emma 
 * 2) Speed (Junit starts up so much faster than GWTUnit)
 * 3) Test Encapsulation (GWTUnit tends to startup full blown http servers,
 * 		mock browsers, and all sorts of bells and whistles)
 * 
 * @author scott
 *
 */
public interface I_Test {
	public void assertIsTrue(boolean p);
	public void assertIsTrue(String message, boolean p);
	
	public void assertIsFalse(boolean p);
	public void assertIsFalse(String message, boolean p);
	
	public void assertIsEquals(String message, Object a, Object b);
	public void assertIsEquals(Object a, Object b);
	public void assertIsNotEquals(String message, Object a, Object b);
	public void assertIsNotEquals(Object a, Object b);

	
	public void assertIsNotSame(String message, Object a, Object b);
	public void assertIsNotSame(Object a, Object b);
	
	public void assertIsNull(String message,Object a);
	public void assertIsNull(Object a);
	
	public void assertIsNotNull(String message,Object a);
	public void assertIsNotNull(Object a);
	public void assertMapItemsEquals(Map<?,?> expected, Map<?,?> actual);
	public void assertCollectionItemsEquals(Collection<?> expected, Collection<?> actual);
}
