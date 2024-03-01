package edu.miu.cs544.programmingtest2.config;

import edu.miu.cs544.programmingtest2.aspect.AspectJLogging;
import edu.miu.cs544.programmingtest2.service.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@Profile({"development", "default"})
@ComponentScan(basePackages = "edu.miu.cs544.programmingtest2")
public class SpringConfig {

    @Bean
    public DateService dateService() {
        return new DateService();
    }

    @Bean
    public FileLogger fileLogger() {
        return new FileLogger();
    }

    @Bean
    public MsSqlManager msSqlManager() {
        return new MsSqlManager();
    }

    @Bean
    public EmailSystem emailSystem() {
        return  new EmailSystem(dateService());
    }

    @Bean
    public MySqlManager mySqlManager() {
        return new MySqlManager();
    }

    @Bean
    public StudentCRUD studentCRUD() {
        return  new StudentCRUD(mySqlManager());
    }

    @Bean
    public AspectJLogging aspectJLogging() {
        return new AspectJLogging(fileLogger());
    }

    @Bean
    @Profile("production")
    public StudentCRUD studentCRUD_prod() {
        return new StudentCRUD(msSqlManager());
    }
}
