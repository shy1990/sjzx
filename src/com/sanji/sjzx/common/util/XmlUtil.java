package com.sanji.sjzx.common.util;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XmlUtil {
	/**
	 * 取得xml文件的根节点名称，即消息名称�?
	 * 
	 * @param xmlStr
	 *            xml内容
	 * @return String 返回名称
	 */
	public static String getRootName(String xmlStr) throws Exception {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new StringReader(xmlStr));
		Element root = doc.getRootElement();
		return root.getName();
	}

	/**
	 * 把xml文件转换为map形式，其中key为有值的节点名称，并以其�?��的祖先节点为前缀，用
	 * "."相连接�?如：SubscribeServiceReq.Send_Address.Address_Info.DeviceType
	 * 
	 * @param xmlStr
	 *            xml内容
	 * @return Map 转换为map返回
	 */
	public static Map<String, String> xml2Map(String xmlStr)
			throws JDOMException, IOException {
		Map<String, String> rtnMap = new HashMap<String, String>();
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new StringReader(xmlStr));
		// 得到根节�?
		Element root = doc.getRootElement();
		String rootName = root.getName();
		rtnMap.put("root.name", rootName);
		// 调用递归函数，得到所有最底层元素的名称和值，加入map�?
		convert(root, rtnMap, rootName);
		return rtnMap;
	}

	/**
	 * 递归函数，找出最下层的节点并加入到map中，由xml2Map方法调用�?
	 * 
	 * @param e
	 *            xml节点，包括根节点
	 * @param map
	 *            目标map
	 * @param lastname
	 *            从根节点到上�?��节点名称连接的字�?
	 */
	public static void convert(Element e, Map<String, String> map,
			String lastname) {
		if (e.getAttributes().size() > 0) {
			Iterator it_attr = e.getAttributes().iterator();
			while (it_attr.hasNext()) {
				Attribute attribute = (Attribute) it_attr.next();
				String attrname = attribute.getName();
				String attrvalue = e.getAttributeValue(attrname);
				map.put(lastname + "." + attrname, attrvalue);
			}
		}
		List children = e.getChildren();
		Iterator it = children.iterator();
		while (it.hasNext()) {
			Element child = (Element) it.next();
			String name = lastname + "." + child.getName();
			// 如果有子节点，则递归调用
			if (child.getChildren().size() > 0) {
				convert(child, map, name);
			} else {
				// 如果没有子节点，则把值加入map
				map.put(name, child.getText());
				// 如果该节点有属�?，则把所有的属�?值也加入map
				if (child.getAttributes().size() > 0) {
					Iterator attr = child.getAttributes().iterator();
					while (attr.hasNext()) {
						Attribute attribute = (Attribute) attr.next();
						String attrname = attribute.getName();
						String attrvalue = child.getAttributeValue(attrname);
						map.put(name + "." + attrname, attrvalue);
					}
				}
			}
		}
	}

	/**
	 * 把xml文件转换为list形式，其中每个元素是�?��map，map中的key为有值的节点名称，并以其�?��的祖先节点为前缀，用
	 * "."相连接�?如：SubscribeServiceReq.Send_Address.Address_Info.DeviceType
	 * 
	 * @param xmlStr
	 *            xml内容
	 * @return Map 转换为map返回
	 */
	public static List<Map<String, String>> xml2List(String xmlStr)
			throws JDOMException, IOException {
		List<Map<String, String>> rtnList = new ArrayList<Map<String, String>>();
		Map<String, String> rtnMap = new HashMap<String, String>();
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new StringReader(xmlStr));
		// 得到根节�?
		Element root = doc.getRootElement();
		String rootName = root.getName();
		rtnMap.put("root.name", rootName);
		// 调用递归函数，得到所有最底层元素的名称和值，加入map�?
		convert2List(root, rtnMap, rootName, rtnList);
		if (rtnList.size() == 0)
			rtnList.add(rtnMap);
		return rtnList;
	}

	/**
	 * 递归函数，找出最下层的节点并加入到map中，如果有相同的节点，则加入list中， 由xml2List方法调用�?
	 * 
	 * @param e
	 *            xml节点，包括根节点
	 * @param map
	 *            目标map
	 * @param lastname
	 *            从根节点到上�?��节点名称连接的字�?
	 * @param list
	 *            相同节点生成map放入list�?
	 */
	public static void convert2List(Element e, Map<String, String> map,
			String lastname, List<Map<String, String>> list) {
		if (e.getAttributes().size() > 0) {
			Iterator it_attr = e.getAttributes().iterator();
			while (it_attr.hasNext()) {
				Attribute attribute = (Attribute) it_attr.next();
				String attrname = attribute.getName();
				String attrvalue = e.getAttributeValue(attrname);
				map.put(lastname + "." + attrname, attrvalue);
			}
		}
		List children = e.getChildren();
		Iterator it = children.iterator();
		while (it.hasNext()) {
			Element child = (Element) it.next();
			String name = lastname + "." + child.getName();
			// 如果有子节点，则递归调用
			if (child.getChildren().size() > 0) {
				convert(child, map, name);
			} else {
				// 如果没有子节点，则把值加入map
				map.put(name, child.getText());
				// 如果该节点有属�?，则把所有的属�?值也加入map
				if (child.getAttributes().size() > 0) {
					Iterator attr = child.getAttributes().iterator();
					while (attr.hasNext()) {
						Attribute attribute = (Attribute) attr.next();
						String attrname = attribute.getName();
						String attrvalue = child.getAttributeValue(attrname);
						map.put(name + "." + attrname, attrvalue);
					}
				}
			}
			// 如果有相同节点，则加入list中，不�?虑子节点中又有相同节点的情况
			if (e.getChildren(child.getName()).size() > 1) {
				Map<String, String> aMap = new HashMap<String, String>();
				aMap.putAll(map);
				list.add(aMap);
				map = new HashMap<String, String>();
				map.put("root.name", aMap.get("root.name"));
			}
		}
	}

	/**
	 * 打印map 的所有key和value
	 * 
	 * @param map
	 */
	public static void printMap(Map<String, String> map) {
		Iterator<String> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(key + ":" + map.get(key));
		}
	}

	/**
	 * 格式化xml
	 * 
	 * @param xmlStr
	 * @param encode
	 * @return String
	 * @date Apr 30, 2008
	 * @SuppressWarnings("deprecation") public static String formatXml(String
	 *                                  xmlStr, String encode ) {
	 * 
	 *                                  SAXBuilder sb = new SAXBuilder(); Reader
	 *                                  reader = new StringReader(xmlStr);
	 * 
	 *                                  Document doc = null; try { doc =
	 *                                  sb.build(reader); } catch (Exception e)
	 *                                  { //do nosth }
	 * 
	 *                                  XMLOutputter outputter = new
	 *                                  XMLOutputter(Format.getPrettyFormat());
	 *                                  outputter.setEncoding(encode); String
	 *                                  result = "" ; if(null != doc){ result =
	 *                                  outputter.outputString(doc); }
	 * 
	 *                                  return result; }
	 */
}