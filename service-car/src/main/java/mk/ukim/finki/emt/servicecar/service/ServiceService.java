package mk.ukim.finki.emt.servicecar.service;

import mk.ukim.finki.emt.servicecar.domain.model.Service;
import mk.ukim.finki.emt.servicecar.domain.model.ServiceId;
import mk.ukim.finki.emt.servicecar.domain.repository.ServiceRepository;
import mk.ukim.finki.emt.servicecar.service.forms.ServiceForm;

import java.util.List;
import java.util.Optional;

public interface ServiceService {

    List<Service> findAll();

    Optional<Service> findById(ServiceId id);

}


