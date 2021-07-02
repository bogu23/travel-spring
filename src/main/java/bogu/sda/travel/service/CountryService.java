package bogu.sda.travel.service;

import bogu.sda.travel.entity.CountryModel;
import bogu.sda.travel.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public void addCountry(CountryModel countryModel) {
        countryRepository.save(countryModel);
    }

    public List<CountryModel> getAll() {
        List<CountryModel> countryModelList = countryRepository.findAll();
        return countryModelList;
    }



}
