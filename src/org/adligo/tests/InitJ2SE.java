package org.adligo.tests;

import org.adligo.i.log.client.LogPlatform;
import org.adligo.jse.util.JSEPlatform;

public class InitJ2SE {
	 private static final boolean init = false;
	  
	  public static synchronized void init(){
		  if (!init) {
			try {
				JSEPlatform.init();
				if (!LogPlatform.isInit()) {
					LogPlatform.init();
				}
			} catch (Exception x) {
				x.printStackTrace();
			}
		  } 
	  }
	  
	  static {
		  init();
	  }
}
