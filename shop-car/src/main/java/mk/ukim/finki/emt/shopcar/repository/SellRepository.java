package mk.ukim.finki.emt.shopcar.repository;

import mk.ukim.finki.emt.shopcar.domain.models.Sell;
import mk.ukim.finki.emt.shopcar.domain.models.SellID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, SellID> {

}
