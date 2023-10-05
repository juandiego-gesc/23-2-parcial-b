package co.edu.unisabana.parcialarquitectura.integration;

import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles(profiles = "test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class GateControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void Given_Checkpoint_When_checkout_Then_Succesful() {

        CheckpointDTO checkpointDTO = new CheckpointDTO( "Facility", "Driver", 1);

        restTemplate.postForEntity("/checkpoint/checkout", checkpointDTO, String.class);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("/checkpoint/checkout", checkpointDTO, String.class);

        Assertions.assertEquals( "Checkout successful", stringResponseEntity.getBody());

    }
}