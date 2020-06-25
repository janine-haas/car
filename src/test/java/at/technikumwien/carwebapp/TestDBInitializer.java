package at.technikumwien.carwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Profile("test")
public class TestDBInitializer {

    @Autowired
    private CarRepository carRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationEvent(){
        carRepository.saveAll(
                List.of(
                        new Car(
                                null,
                                "My Car",
                                "Mini",
                                LocalDate.of(1990, 1, 1),
                                true
                        ),
                        new Car(
                                null,
                                "cool Car",
                                "BMW",
                                LocalDate.of(1990, 2, 1),
                                true
                        )
                )
        );
    }
}
