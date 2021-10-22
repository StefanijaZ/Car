package mk.ukim.finki.emt.servicecar.domain.repository;

import mk.ukim.finki.emt.servicecar.domain.model.Service;
import mk.ukim.finki.emt.servicecar.domain.model.ServiceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, ServiceId> {

}
