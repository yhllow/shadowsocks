package com.ineng.shadowsocks.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ineng.utils.FileUtil;
import com.ineng.utils.StringUtil;
import org.htmlparser.Node;
import org.htmlparser.filters.StringFilter;
import org.htmlparser.util.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FreeSSParser {
	final String CONFIGS = "configs";
	final String SERVER = "server";
	final String SERVER_PORT = "server_port";
	final String PASSWORD = "password";
	final String METHOD = "method";
	final String STATUS = "status";
	final String REMARKS = "remarks";

	final Map<String, String> configDescs = new HashMap<String, String>();

	protected abstract void initConfigDescs();

	public abstract Map<String, List<String>> parseFreeSSData();

	public void parseFreeSS(String cfgFile) {
		initConfigDescs();
		modifyConfigs(cfgFile, parseFreeSSData());
	}

	Map<String, List<String>> getFreeShadowSocks(Node node) {
		if (null == node) {
			System.out.println("免费节点未找到！！！");
			return null;
		}

		Map<String, List<String>> configValues = new HashMap<String, List<String>>();
		configValues.put(SERVER,
				getFreeShadowSocksItems(node, configDescs.get(SERVER)));
		configValues.put(SERVER_PORT,
				getFreeShadowSocksItems(node, configDescs.get(SERVER_PORT)));
		configValues.put(PASSWORD,
				getFreeShadowSocksItems(node, configDescs.get(PASSWORD)));
		configValues.put(METHOD,
				getFreeShadowSocksItems(node, configDescs.get(METHOD)));

		return configValues;
	}

	private List<String> getFreeShadowSocksItems(Node node, String itemName) {
		List<String> itemValues = new ArrayList<String>();

		NodeList list = new NodeList();
		StringFilter filter = new StringFilter(itemName);
		node.collectInto(list, filter);

		System.out.println("===============" + itemName + "==============");
		for (int i = 0; i < list.size(); i++) {
			Node subNode = list.elementAt(i);
			String itemValue = StringUtil.substringAfter(subNode.getText(),itemName);
			if ("".equals(itemValue)) {
				Node nextTxt = subNode.getNextSibling().getFirstChild();
				itemValue = (nextTxt != null) ? nextTxt.getText() : "";
			}
			System.out.println(itemValue);
			itemValues.add(itemValue);
		}

		return itemValues;
	}

	private void modifyConfigs(String cfgFile,
			Map<String, List<String>> configValues) {
		String cfgContent = FileUtil.readFile(cfgFile);
		JSONObject cfgObj = JSONObject.parseObject(cfgContent);
		cfgObj.put(CONFIGS, getConfigs(configValues));

		FileUtil.writeFile(cfgFile, JSONObject.toJSONString(cfgObj, true));
	}

	private JSONArray getConfigs(Map<String, List<String>> configValues) {
		JSONArray configs = new JSONArray();
		List<String> servers = configValues.get(SERVER);
		List<String> serverPorts = configValues.get(SERVER_PORT);
		List<String> passwords = configValues.get(PASSWORD);
		List<String> methods = configValues.get(METHOD);
		JSONObject config = null;
		for (int i = 0; i < servers.size(); i++) {
			if (getValue(passwords.get(i)) != null) {
				config = new JSONObject();
				config.put(SERVER, getValue(servers.get(i)));
				config.put(SERVER_PORT, getIntValue(serverPorts.get(i)));
				config.put(PASSWORD, getValue(passwords.get(i)));
				config.put(METHOD, getValue(methods.get(i)));
				config.put(REMARKS, "");

				configs.add(config);
			}
		}

		return configs;
	}

	private String getValue(String input) {
		return StringUtil.isNotBlank(input) ? input : null;
	}

	private int getIntValue(String input) {
		return StringUtil.isNotBlank(input) ? Integer.valueOf(input) : 0;
	}
}
