package com.cs.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.cs.constants.FrameworkConstants;
import com.cs.enums.ConfigProperties;
import com.cs.exceptions.InvalidPathForPropertyFileException;
import com.cs.exceptions.PropertyFileUsageException;
import com.cs.listeners.ListenerClass;

public final class PropertyUtils {

	private PropertyUtils() {}
	
	private static Properties property                 = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	
	// static block should not make use DisplayLogUtils methods as it tries to read config.properties which is the 
	// same objective of static method, so goes in indefinite loop
	// static block has a problem in handling exception, you have to terminate the program
	// else create a method for this static block and call in getValue method - 
	// if CONFIGMapis null then only call static block method, else only read the CONFIGMAP
	static {
//		DisplayLogUtils.displayLog("Begin of PropertyUtils using static block ->" + ListenerClass.executionOrdercounter++);
		System.out.println("Static block => Begin of PropertyUtils using static block ->" + ListenerClass.executionOrdercounter++);
		
		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())) 
		{
			property.load(fis);
			/*
			 * for(Object key: property.keySet()) CONFIGMAP.put(String.valueOf(key),
			 * String.valueOf(property.get(key)));
			 * OR
			 */		
			for(Map.Entry<Object, Object> entry: property.entrySet())
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
 		} 
		catch (IOException e1) 
		{
			System.out.println("ERROR=> Error in loading " + FrameworkConstants.getConfigFilePath());

			// even though we raise runtime exception, code will not stop as static block does not have 
			// parent to catch this exception, it will continue execution of the  program
			// and raise an different error 
			// throw new InvalidPathForPropertyFileException("Please check the path of config file");
			e1.printStackTrace();
			System.exit(1);
			
		} 
		
		
		System.out.println("Staticblock => end of PropertyUtils using static block ->" + ListenerClass.executionOrdercounter);
		
 //		DisplayLogUtils.displayLog("end of PropertyUtils using static block ->" + ListenerClass.executionOrdercounter);

	}
/*	
	public static String get(ConfigProperties url) throws Exception
	{
		// we are not making use of config.properties -> browser parameter
		// but browser value is read from DATA sheet of testdata.xlsx
		DisplayLogUtils.displayLog("Begin of PropertyUtils.get() ->" + ListenerClass.executionOrdercounter++);

		if (Objects.isNull(url.name().toLowerCase()))
			throw new Exception("Property name: " + url + " not found, please check config.properties file under folder: "+ System.getProperty("user.dir")+ "/src/test/resources/config");
		if (Objects.isNull(CONFIGMAP.get(url.name().toLowerCase())))   //or url.toString().toLowercase() 
			throw new Exception("Property name: " + url + " is null, please check config.properties file under folder: "+ System.getProperty("user.dir")+ "/src/test/resources/config");
		
		DisplayLogUtils.displayLog("End of PropertyUtils.get() ->" + ListenerClass.executionOrdercounter);
		return CONFIGMAP.get(url.name().toLowerCase());
	}
*/	
	public static String getValue(ConfigProperties key)  
	{
//      goes in loop when this function is called in static block: while collecting key,values in static block, we are trying to read from config again - goes in loop forever		
//		DisplayLogUtils.displayLog("Begin of PropertyUtils.getValue() ->" + ListenerClass.executionOrdercounter++);

		String value = "";
		value = property.getProperty(key.name().toLowerCase());
		if (Objects.isNull(value)   || Objects.isNull(key.name().toLowerCase()) )
			throw new PropertyFileUsageException("Property name: " + key.name().toString() + " either not found or set a null value, "
					+ "please check file under folder: "+ System.getProperty("user.dir")+ "/src/test/resources/config/config.properties");

		
//		DisplayLogUtils.displayLog("End of PropertyUtils.getValue() ->" + ListenerClass.executionOrdercounter);

		return value;
	}
}