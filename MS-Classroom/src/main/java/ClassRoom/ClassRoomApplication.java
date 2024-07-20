package ClassRoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ClassRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassRoomApplication.class, args);
    }

}
