package org.adligo.tests.client;

import org.adligo.gwt.util.client.GwtPlatform;
import org.adligo.i.log.client.LogPlatform;

public class InitGwt {
	private static final boolean init = false;
	  
	  public static synchronized void init(){
		  if (!init) {
			try {
				GwtPlatform.init();
				LogPlatform.init();
			} catch (Exception x) {
				x.printStackTrace();
			}
		  } 
	  }
	  
	  static {
		  init();
	  }
}
