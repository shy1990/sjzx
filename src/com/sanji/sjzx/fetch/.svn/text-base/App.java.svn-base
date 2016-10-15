package com.sanji.sjzx.fetch;

import java.util.Map;

import com.sanji.sjzx.model.Goods;



/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		String url = "http://detail.zol.com.cn/392/391257/param.shtml";
		FecthHandler fecth=new IDNewTbFacthHander(null);
		FectResult result = fecth.fecth(url);
		System.out.println("手机："+result.getName());
		Double screenSize = Double.parseDouble(result.getParams().get("屏幕").get("主屏尺寸").replace("英寸", ""));
		System.out.println("screenSize==="+screenSize);
/*		for (String key1 : result.getParams().keySet()) {
			System.out.println("+============="+key1+"=============");
			Map<String, String> map=result.getParams().get(key1);
			for (String key2 : map.keySet()) {
				System.out.println(key2+":"+map.get(key2));
			}
		}*/
		String a = "good morning";
		a = a.replace("克", "");
		System.out.println("a==="+a);
		System.out.println();
		String aa = "1086p";
		aa = aa.replace("px", "");
		System.out.println("aa==="+aa);
		System.out.println();
		String si = null;
		String un = si==null?null:si;
		System.out.println("un===="+un);
		System.out.println();
		Goods goods = new Goods();
		goods.setWarrantyTime(null);
		System.out.println();
		//String param = result.getParams().get("小白").get("小白");
		Map<String, String> map = result.getParams().get("基本参数");
		if(null != map && map.size()>0){
			String param = map.get("小白");
			String cellphoneType = param == null?"":param;
			//goods.setCellphoneType(cellphoneType);
			System.out.println("cellphoneType===="+cellphoneType);
		}else {
			System.out.println("是空的。。。。。。。。。");
		}
	}
}
