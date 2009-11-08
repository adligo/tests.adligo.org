package org.adligo.tests.client;

/**
 * for co mingleing of GWT Tests and regular Junit tests
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
	
	public void assertIsNull(String message,Object a);
	public void assertIsNull(Object a);
	
	public void assertIsNotNull(String message,Object a);
	public void assertIsNotNull(Object a);
}
