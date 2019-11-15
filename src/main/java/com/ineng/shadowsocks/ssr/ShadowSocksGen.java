/**
 * @Title: ShadowSocksGen.java
 * @Package com.ineng.shadowsocks
 * @Description: TODO(用一句话描述该文件做什么)
 * @author yh
 * @date 2016年5月2日 上午11:11:00
 * @version V1.0
 */
package com.ineng.shadowsocks.ssr;

import com.ineng.shadowsocks.parser.FreeSSParser;
import com.ineng.utils.ConsoleUtil;

public class ShadowSocksGen {

	public void printPrompt() {
		int panddingLeft = 5;
		System.out.println(ConsoleUtil.getDefaultFormatLine("=", panddingLeft));
		System.out.println(ConsoleUtil.getDefaultFormatLine(" ", panddingLeft));

//		System.out.println(getDefaultFormatLine(
//				"1. http://freeshadowsocks.cf/ (change per 24 hours)",
//				panddingLeft));
//		System.out.println(getDefaultFormatLine(
//				"2. http://i.freevpnss.com/ (change per 12 hours)",
//				panddingLeft));
		System.out.println(ConsoleUtil.getDefaultFormatLine(
				"3. http://ss.ishadowx.com/ (change per 6 hours)",
				panddingLeft));

		System.out.println(ConsoleUtil.getDefaultFormatLine(" ", panddingLeft));
		System.out.println(ConsoleUtil.getDefaultFormatLine("=", panddingLeft));

		System.out.print("请选择shadowsocks来源：");
	}

	public FreeSSParser getParser(String parser) {
		return FreeSSParserFactory.getFreeSSParser(parser);
	}

	public void parseFreeSS(FreeSSParser parser, String cfgFile) {
		parser.parseFreeSS(cfgFile);
	}

}
