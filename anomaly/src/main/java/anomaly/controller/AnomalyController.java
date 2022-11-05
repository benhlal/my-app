package anomaly.controller;

import anomaly.controller.response.AnomalyCheckResponse;
import anomaly.service.AnomalyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/v1/anomalies")
@RestController
public record AnomalyController(AnomalyService anomalyService) {

    @GetMapping("/check/{customerId}")
    public AnomalyCheckResponse check(@PathVariable Integer customerId) {
        log.info("Anomaly request {} ", customerId);
        return anomalyService.hasCreatedAnomaly(customerId);
    }
}
