package vb.AutomationFramework;

import org.apache.log4j.Logger;


public class ConsoleLogs {
	static Logger log = Logger.getLogger(ConsoleLogs.class.getName());

	public static void INFOPass(String info) {
		System.out.println("PASS:"+BuildObjrep.TestCaseHashmap.get("TestStepID") + "  "+info);
		log.info(info);
	
	}

	public static void INFOFail(String info) {
		System.out.println("FAIL:  "+BuildObjrep.TestCaseHashmap.get("TestStepID") +" "+ info);

		log.info(info);
	}
	public static void Skip(String info) {
		System.out.println("Skip:  "+BuildObjrep.TestCaseHashmap.get("TestStepID") +" "+ info);

		log.info(info);
	}

	public static void fatal(String info) {
		// TODO Auto-generated method stub
		System.out.println("Fatal:  "+BuildObjrep.TestCaseHashmap.get("TestStepID") +" "+ info);
		log.info(info);
		
	}
	
	public static void Warn(String info) {
		System.out.println("WARN:  "+BuildObjrep.TestCaseHashmap.get("TestStepID") +" "+ info);

		log.info(info);
	}

	
}
