package child.data.service;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.NumberUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class App 
{
    public static void main( String[] args )
    {
    	 int port=0;
    	 int defaultPort= 8081;
    	 Future<Integer> fu = ThreadUtil.execAsync(() -> {
    		 int p = 0;
             System.out.println("请于5秒钟内输入端口号, 推荐  8001 、 8002  或者  8003，超过5秒将默认使用 " + defaultPort);
    		 Scanner sc = new Scanner(System.in);
    		while(true) {
	    		 String input = sc.nextLine();
	    		if(!NumberUtil.isInteger(input)) {
	    			 System.err.println("只能是数字");
	    			 continue;
	    		}else {
	    			p =  Convert.toInt(input);
	    			sc.close();
	    			break;
	    		}
    		}
             return p;
    	 });
    	 try {
    		 port = fu.get(5, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			port = defaultPort;
		}
    	 if(!NetUtil.isUsableLocalPort(port)) {
             System.err.printf("端口%d被占用了，无法启动%n", port );
             System.exit(1);
         }
          
         new SpringApplicationBuilder(App.class).properties("server.port=" + port).run(args);
    }
    @Bean
    public Sampler defaultSampler() {
    	return Sampler.ALWAYS_SAMPLE;
    }
}
