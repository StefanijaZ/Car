package mk.ukim.finki.emt.servicecar.domain.model;


import lombok.Setter;
import mk.ukim.finki.emt.servicecar.domain.valueobjects.CarId;
import mk.ukim.finki.emt.servicecar.domain.valueobjects.MechanicId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;


//Entoty for sevice a car
@Entity
@Setter
@Table(name="service")
public class Service extends AbstractEntity<ServiceId> {

    @Column(name = "service_date", nullable = false)
    private Date dateService;

    @Column(name = "next_service_date", nullable = false)
    private Date nextServiceDate;

    @Column(name = "service_details", nullable = false)
    private String serviceDetails;

    @AttributeOverride(name="id", column = @Column(name="car_id", nullable = false))
    private CarId carId;

    @AttributeOverride(name="id", column = @Column(name="mechanic_id", nullable = false))
    private MechanicId mechanicId;

    private Service() {
        super(ServiceId.randomId(ServiceId.class));
    }

    public Service(Date dateService, Date nextServiceDate, String serviceDetails, CarId carId, MechanicId mechanicId) {
        super(ServiceId.randomId(ServiceId.class));
        this.dateService = dateService;
        this.nextServiceDate = nextServiceDate;
        this.serviceDetails = serviceDetails;
        this.carId = carId;
        this.mechanicId = mechanicId;
    }


}
