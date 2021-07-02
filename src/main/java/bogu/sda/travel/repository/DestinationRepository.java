package bogu.sda.travel.repository;

import bogu.sda.travel.entity.TravelDestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<TravelDestinationModel, Long> {


}
