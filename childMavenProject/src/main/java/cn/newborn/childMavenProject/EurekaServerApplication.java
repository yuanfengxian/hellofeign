package cn.newborn.childMavenProject;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import cn.hutool.core.util.NetUtil;
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		int port=8761;
		if(!NetUtil.isUsableLocalPort(port)) {
			System.err.printf("端口号%d被占用了，系统无法启动%n",port);
			System.exit(1);
		}
		new SpringApplicationBuilder(EurekaServerApplication.class).properties("server.port="+port).run(args);
	}
	
}
