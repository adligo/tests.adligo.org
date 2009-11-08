package org.adligo.tests.client;

import com.google.gwt.junit.client.GWTTestCase;

public abstract class AGwtTest extends GWTTestCase implements I_Test {

	public AGwtTest() {
		super();
	}

	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		InitGwt.init();
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
	public String getModuleName() {
		// TODO Auto-generated method stub
		return null;
	}

}
