package com.ineng.shadowsocks;

import com.ineng.shadowsocks.ssr.SSRHandler;
import com.ineng.shadowsocks.ssr.ShadowSocksGen;
import com.ineng.utils.ConsoleUtil;

public class Main {

    public static void main(String[] args) {
//        genFreeSS(args);
        ssr(args);
    }

    private static void ssr(String[] args) {
        SSRHandler ssrHandler = new SSRHandler();
        ssrHandler.printPrompt();
        ssrHandler.handle(ConsoleUtil.getInput());
    }

    private static void genFreeSS(String[] args) {
        String cfgFile = null;
        if (null == args || args.length == 0) {
            cfgFile = ClassLoader.getSystemResource("").getPath() + "gui-config.json";
            System.out.println("未设置shadowsocks配置文件路径，将使用默认路径 " + cfgFile);
        } else {
            cfgFile = args[0];
        }

        ShadowSocksGen gen = new ShadowSocksGen();
        gen.printPrompt();
        gen.parseFreeSS(gen.getParser(ConsoleUtil.getInput()), cfgFile);
    }

}