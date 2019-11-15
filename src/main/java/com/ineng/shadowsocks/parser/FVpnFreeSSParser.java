package com.ineng.shadowsocks.parser;

import java.util.List;
import java.util.Map;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TagFindingVisitor;

/**
 * http://i.freevpnss.com/#shadowsocks 密码12小时更新一次
 * 
 * @author yinheng
 *
 */
public class FVpnFreeSSParser extends FreeSSParser {

	@Override
	public Map<String, List<String>> parseFreeSSData() {
		Parser parser = null;
		try {
			parser = new Parser("http://i.freevpnss.com/#shadowsocks");
			parser.setEncoding("utf-8");

			TagFindingVisitor visitor = new TagFindingVisitor(
					new String[] { "div" });
			parser.visitAllNodesWith(visitor);
			Node[] nodes = visitor.getTags(0);

			Node node = getFreevpnssFreeNode(nodes);

			return getFreeShadowSocks(node);
		} catch (ParserException e) {
			e.printStackTrace();
		}

		return null;
	}

	private Node getFreevpnssFreeNode(Node[] nodes) {
		int index = -1;
		for (int i = 0; i < nodes.length; i++) {
			TagNode node = (TagNode) nodes[i];
			if ("shadowsocks".equals(node.getAttribute("id"))) {
				index = i;
			}

			if (index >= 0 && i == (index + 1)) {
				// System.out.println(nodes[i]);

				return node;
			}
		}

		return null;
	}

	@Override
	protected void initConfigDescs() {
		configDescs.clear();
		configDescs.put(SERVER, "服务器地址：");
		configDescs.put(SERVER_PORT, "端口：");
		configDescs.put(PASSWORD, "码：");
		configDescs.put(METHOD, "加密方式：");
	}

}
