package pl.java.data.base.helloW.hibernateStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootConfiguration
public class SpringApplicationStarter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringApplicationStarter.class, args);
        SpringApplicationStarter p = context.getBean(SpringApplicationStarter.class);
        p.start();
    }

    @Autowired
    private SpringCostumerRepository customerRepository;
    private void start() {
        //customerRepository.save();
    }
}
