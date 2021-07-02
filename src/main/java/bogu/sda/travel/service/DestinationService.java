package bogu.sda.travel.service;

import bogu.sda.travel.entity.TravelDestinationModel;
import bogu.sda.travel.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<TravelDestinationModel> getAll() {
        return destinationRepository.findAll();
    }

    public void addDestination(TravelDestinationModel travelDestinationModel) {
        destinationRepository.save(travelDestinationModel);
    }

    public TravelDestinationModel getById(long id) {
        Optional<TravelDestinationModel> travelDestinationModelOptional = destinationRepository.findById(id);
        return travelDestinationModelOptional.get();
    }

    public void editDestination(TravelDestinationModel travelDestinationModel) {
        destinationRepository.save(travelDestinationModel);
    }

    public void remove(long id) {
        destinationRepository.deleteById(id);
    }
}
