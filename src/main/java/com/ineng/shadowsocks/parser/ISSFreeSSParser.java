package com.ineng.shadowsocks.parser;

import com.ineng.shadowsocks.model.Section;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.PrototypicalNodeFactory;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TagFindingVisitor;

import java.util.List;
import java.util.Map;

/**
 * http://www.ishadowsocks.net/#free 密码6小时更新一次
 * 
 * @author yinheng
 *
 */
public class ISSFreeSSParser extends FreeSSParser {

	@Override
	public Map<String, List<String>> parseFreeSSData() {
		Parser parser = null;
		try {
			parser = new Parser("http://ss.ishadowx.com/");
			parser.setEncoding("utf-8");

			PrototypicalNodeFactory factory = new PrototypicalNodeFactory();
			factory.registerTag(new Section());
			parser.setNodeFactory(factory);

			TagFindingVisitor visitor = new TagFindingVisitor(
					new String[] { "div" });
			parser.visitAllNodesWith(visitor);
			Node[] nodes = visitor.getTags(0);

			Node node = getIShadowsocksFreeNode(nodes);

			return getFreeShadowSocks(node);
		} catch (ParserException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void initConfigDescs() {
		configDescs.clear();
		configDescs.put(SERVER, "IP Address:");
		configDescs.put(SERVER_PORT, "Port：");
		configDescs.put(PASSWORD, "Password:");
		configDescs.put(METHOD, "Method:");
	}

	private Node getIShadowsocksFreeNode(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			TagNode node = (TagNode) nodes[i];
			String _class = node.getAttribute("class");
			if (_class != null && _class.contains("portfolio-items")) {
				System.out.println(node);
				return node;
			}
		}

		return null;
	}
}
