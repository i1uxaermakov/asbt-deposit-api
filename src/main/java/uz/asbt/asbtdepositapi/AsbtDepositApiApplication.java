package uz.asbt.asbtdepositapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class AsbtDepositApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsbtDepositApiApplication.class, args);
	}

//	@Bean
//	@Order(Ordered.HIGHEST_PRECEDENCE)
//	CharacterEncodingFilter characterEncodingFilter() {
//		CharacterEncodingFilter filter = new CharacterEncodingFilter();
//		filter.setEncoding("UTF-8");
//		filter.setForceEncoding(true);
//		return filter;
//	}
}
