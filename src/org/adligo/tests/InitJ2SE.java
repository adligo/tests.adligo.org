package org.adligo.tests;

import org.adligo.i.log.client.LogPlatform;
import org.adligo.j2se.util.J2SEPlatform;

public class InitJ2SE {
	 private static final boolean init = false;
	  
	  public static synchronized void init(){
		  if (!init) {
			try {
				J2SEPlatform.init();
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
