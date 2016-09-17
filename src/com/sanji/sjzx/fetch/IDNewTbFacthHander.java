package com.sanji.sjzx.fetch;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.Bullet;
import org.htmlparser.tags.HeadingTag;
import org.htmlparser.tags.Span;
import org.htmlparser.tags.TableHeader;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

public class IDNewTbFacthHander extends FecthHandler {

	public IDNewTbFacthHander(FecthHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public FectResult fecth(String url) {
		FectResult result = null;
		try {
			Parser parse = new Parser(url);
			AndFilter nameFilter = new AndFilter(new NodeClassFilter(
					HeadingTag.class), new CssSelectorNodeFilter(".ptitle"));
			HasAttributeFilter paramParent = new HasAttributeFilter("id",
					"newTb");
			NodeFilter[] filters = { nameFilter, paramParent };
			NodeList nodeList = parse.parse(new OrFilter(filters));

			result = new FectResult(nodeList.elementAt(0).toPlainTextString());

			NodeList paramNodes = nodeList
					.elementAt(1)
					.getChildren()
					.extractAllNodesThatMatch(
							new NodeClassFilter(TableTag.class));
			for (int i = 0; i < paramNodes.size(); i++) {
				TableTag table = (TableTag) paramNodes.elementAt(i);

				TableHeader tableHeader = table.getRow(0).getHeaders()[0];
				String firstLeve = tableHeader.toPlainTextString();

				NodeList paramList = new NodeList();
				table.collectInto(paramList, new NodeClassFilter(Bullet.class));
				for (int j = 0; j < paramList.size(); j++) {
					NodeList spans = paramList
							.elementAt(j)
							.getChildren()
							.extractAllNodesThatMatch(
									new NodeClassFilter(Span.class));
					String secendLeve = spans.elementAt(0).toPlainTextString();
					String value = spans.elementAt(1).toPlainTextString();
					result.setParams(firstLeve, secendLeve, value);
				}
			}
		} catch (Exception e) {
			System.out.println(this.getClass() + " 不能抓取");
			if (this.nextHandler != null) {
				result = this.nextHandler.fecth(url);
			} else {
				System.out.println("抓不了。");
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String url = "http://detail.zol.com.cn/274/273715/param.shtml";
		FecthHandler fecth = new IDNewTbFacthHander(null);
		FectResult result = fecth.fecth(url);
		System.out.println(result);
	}
}
