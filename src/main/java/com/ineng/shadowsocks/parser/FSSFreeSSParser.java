package com.ineng.shadowsocks.parser;

import java.util.List;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TagFindingVisitor;

/**
 * http://freeshadowsocks.cf/
 * 
 * @author yinheng
 *
 */
public class FSSFreeSSParser extends FreeSSParser {

	@Override
	public Map<String, List<String>> parseFreeSSData() {
		Parser parser = null;
		try {
			parser = new Parser("http://freeshadowsocks.cf/");
			parser.setEncoding("utf-8");

			TagFindingVisitor visitor = new TagFindingVisitor(
					new String[] { "div" });
			parser.visitAllNodesWith(visitor);
			Node[] nodes = visitor.getTags(0);

			Node node = getFreeSSNode(nodes);

			return getFreeShadowSocks(node);
		} catch (ParserException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Node getFreeSSNode(Node[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			TagNode node = (TagNode) nodes[i];
			if ("row".equals(node.getAttribute("class"))) {
				// System.out.println(node);
				return node;
			}
		}

		return null;
	}

	@Override
	protected void initConfigDescs() {
		configDescs.clear();
		configDescs.put(SERVER, "服务器地址:");
		configDescs.put(SERVER_PORT, "端口:");
		configDescs.put(PASSWORD, "密码:");
		configDescs.put(METHOD, "加密方式:");
		configDescs.put(STATUS, "状态:");
	}
}
