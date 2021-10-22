package mk.ukim.finki.emt.servicecar.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.servicecar.domain.model.ServiceId;
import mk.ukim.finki.emt.servicecar.domain.repository.ServiceRepository;
import mk.ukim.finki.emt.servicecar.service.ServiceService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<mk.ukim.finki.emt.servicecar.domain.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<mk.ukim.finki.emt.servicecar.domain.model.Service> findById(ServiceId id) {
        return serviceRepository.findById(id);
    }

}

