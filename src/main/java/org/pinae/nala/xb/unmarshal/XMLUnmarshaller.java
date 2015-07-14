package org.pinae.nala.xb.unmarshal;

import java.io.InputStream;
import java.io.InputStreamReader;

import org.pinae.nala.xb.exception.UnmarshalException;
import org.pinae.nala.xb.resource.NodeConfig;
import org.pinae.nala.xb.unmarshal.parser.XMLParser;


/**
 * 实现XML与对象间的绑定, 主要针对XML的输入流
 * 
 * @author Huiyugeng
 *
 */
public class XMLUnmarshaller extends BasicUnmarshaller {
	private XMLParser xmlParser = new XMLParser();
	private NodeConfig config;
	
	/**
	 * 构造函数
	 * 
	 * @param xml 需要绑定的xml输入流
	 * @throws UnmarshalException 解组异常
	 */
	public XMLUnmarshaller(InputStreamReader xml) throws UnmarshalException{
		config = xmlParser.parser(xml);
	}
	
	/**
	 * 构造函数
	 * 
	 * @param xml 需要绑定的xml输入流
	 * @throws UnmarshalException 解组异常
	 */
	public XMLUnmarshaller(InputStream xml) throws UnmarshalException{
		config = xmlParser.parser(new InputStreamReader(xml));
	}
	
	public Object unmarshal() throws UnmarshalException{
		if(config!=null){
			return super.creteObject(config);
		}else{
			throw new UnmarshalException("Couldn't get XML information");
		}
	}

	

}