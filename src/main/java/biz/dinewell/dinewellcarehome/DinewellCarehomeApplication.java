package biz.dinewell.dinewellcarehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DinewellCarehomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DinewellCarehomeApplication.class, args);
    }
}
