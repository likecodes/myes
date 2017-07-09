import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by leo on 2017/7/3.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.uxunchina.changsha"})
@MapperScan("com.uxunchina.changsha.*.*.dao")
public class PartyBuildApplication {

    public static void main(String[] args) {

        SpringApplication.run(PartyBuildApplication.class, args);
    }
}
