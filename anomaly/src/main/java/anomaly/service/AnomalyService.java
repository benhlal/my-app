package anomaly.service;

import anomaly.controller.request.AnomalyCheckRequest;
import anomaly.controller.response.AnomalyCheckResponse;
import anomaly.model.Anomaly;
import anomaly.repository.AnomalyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class AnomalyService {
    private final ModelMapper mapper;
    private final AnomalyRepository anomalyRepository;

    public void checkAnomalies(AnomalyCheckRequest anomalyCheckRequest) {

        anomalyRepository.findAll();
    }

    public AnomalyCheckResponse hasCreatedAnomaly(Integer customerId) {
        Anomaly anomaly = anomalyRepository.save(
                Anomaly.builder()
                        .creator(String.valueOf(customerId))
                        .creationDate(LocalDate.now())
                        .title("DQH")
                        .description("this is a anomaly description")
                        .build());
       return mapper.map(anomaly,AnomalyCheckResponse.class);}
}
