package com.ineng.shadowsocks.model;

import com.alibaba.fastjson.JSON;

public class SSRConfig {
    /**
     * group : doub.io/sszhfx/
     * remarks : 加拿大
     * server : 64.137.198.70
     * server_port : 1544
     * local_address : 127.0.0.1
     * local_port : 1080
     * password : doub.io/sszhfx/*doub.ws/sszhfx/*1544
     * timeout : 500
     * udp_timeout : 60
     * method : chacha20
     * protocol : auth_sha1_v4
     * obfs : tls1.2_ticket_auth
     * obfs_param :
     * dns_ipv6 : false
     * connect_verbose_info : 1
     * redirect :
     * fast_open : true
     */

    private String group;
    private String remarks;
    private String server;
    private int server_port;
    private String local_address = "127.0.0.1";
    private int local_port = 1080;
    private String password;
    private int timeout = 500;
    private int udp_timeout = 60;
    private String method;
    private String protocol;
    private String obfs;
    private String obfs_param;
    private boolean dns_ipv6 = false;
    private int connect_verbose_info = 1;
    private String redirect;
    private boolean fast_open = true;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getServer_port() {
        return server_port;
    }

    public void setServer_port(int server_port) {
        this.server_port = server_port;
    }

    public String getLocal_address() {
        return local_address;
    }

    public void setLocal_address(String local_address) {
        this.local_address = local_address;
    }

    public int getLocal_port() {
        return local_port;
    }

    public void setLocal_port(int local_port) {
        this.local_port = local_port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getUdp_timeout() {
        return udp_timeout;
    }

    public void setUdp_timeout(int udp_timeout) {
        this.udp_timeout = udp_timeout;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getObfs() {
        return obfs;
    }

    public void setObfs(String obfs) {
        this.obfs = obfs;
    }

    public String getObfs_param() {
        return obfs_param;
    }

    public void setObfs_param(String obfs_param) {
        this.obfs_param = obfs_param;
    }

    public boolean isDns_ipv6() {
        return dns_ipv6;
    }

    public void setDns_ipv6(boolean dns_ipv6) {
        this.dns_ipv6 = dns_ipv6;
    }

    public int getConnect_verbose_info() {
        return connect_verbose_info;
    }

    public void setConnect_verbose_info(int connect_verbose_info) {
        this.connect_verbose_info = connect_verbose_info;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public boolean isFast_open() {
        return fast_open;
    }

    public void setFast_open(boolean fast_open) {
        this.fast_open = fast_open;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
