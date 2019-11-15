package com.ineng.shadowsocks.ssr;

import com.ineng.shadowsocks.parser.FreeSSParser;
import com.ineng.shadowsocks.parser.ISSFreeSSParser;

public class FreeSSParserFactory {

	public static FreeSSParser getFreeSSParser(String signature) {
//		if ("1".equals(signature)) {
//			return new FSSFreeSSParser();
//		} else if ("2".equals(signature)) {
//			return new FVpnFreeSSParser();
//		} else {
			return new ISSFreeSSParser();
//		}
	}
}
