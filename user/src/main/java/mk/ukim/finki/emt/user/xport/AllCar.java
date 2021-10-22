package mk.ukim.finki.emt.user.xport;

import mk.ukim.finki.emt.user.domain.models.UserID;
import mk.ukim.finki.emt.user.domain.models.value_objects.Sell;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AllCar {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    // Communication point with Bounded Context 3.
    public AllCar(@Value("http://localhost:9091") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

//    public AllCar(RestTemplate restTemplate, String serverUrl) {
//        this.restTemplate = restTemplate;
//        this.serverUrl = serverUrl;
//    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }
    // Find all cars for specific user.
    public Optional<List<Sell>> findById(UserID id) {
        try {
            return Optional.ofNullable(restTemplate.exchange(uri().path("/api/cars/" + id.getId()).build().toUri(),
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Sell>>() {

                    }).getBody());
        } catch (Exception e) {
            return Optional.of(Collections.emptyList());
        }
    }

}
