package bogu.sda.travel.service;

import bogu.sda.travel.entity.CustomerModel;
import bogu.sda.travel.entity.TravelOfferModel;
import bogu.sda.travel.repository.TravelOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelOfferService {

    @Autowired
    private TravelOfferRepository travelOfferRepository;

    public List<CustomerModel> getCustomers(long id) {
        Optional<TravelOfferModel> offerFound = travelOfferRepository.findById(id);
        TravelOfferModel travelOfferModel = offerFound.get();
        List<CustomerModel> customerModels = travelOfferModel.getCustomers();
        return customerModels;
    }

    public void addOffer(TravelOfferModel travelOfferModel) {
        travelOfferRepository.save(travelOfferModel);
    }

    public List<TravelOfferModel> findOffers(double maxPrice, long destinationId) {
        return travelOfferRepository.findOffers(maxPrice, destinationId);
    }
}
