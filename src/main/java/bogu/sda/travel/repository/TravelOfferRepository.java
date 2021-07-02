package bogu.sda.travel.repository;

import bogu.sda.travel.entity.TravelOfferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelOfferRepository extends JpaRepository<TravelOfferModel, Long> {

    @Query("from TravelOfferModel as offers join offers.destination as destinations where destinations.id=:destinationId " +
            "and offers.pricePerNight<:maxPrice")
    List<TravelOfferModel> findOffers(@Param("maxPrice") double maxPrice, @Param("destinationId") long destinationId);


}
