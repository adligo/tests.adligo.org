package org.adligo.tests.client;

import com.google.gwt.junit.client.GWTTestCase;

public abstract class AGwtTest extends GWTTestCase {

	public AGwtTest() {
		super();
	}

	@Override
	protected void gwtSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.gwtSetUp();
		InitGwt.init();
	}

}
