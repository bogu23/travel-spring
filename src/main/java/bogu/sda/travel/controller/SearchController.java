package bogu.sda.travel.controller;

import bogu.sda.travel.data.SearchOfferData;
import bogu.sda.travel.entity.TravelDestinationModel;
import bogu.sda.travel.entity.TravelOfferModel;
import bogu.sda.travel.service.DestinationService;
import bogu.sda.travel.service.TravelOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private TravelOfferService offerService;

    @GetMapping("")
    public String viewOfferPage(Model model) {
        List<TravelDestinationModel> destinations = destinationService.getAll();
        model.addAttribute("destinations", destinations);
        model.addAttribute("searchOffer", new SearchOfferData());
        return "index";
    }

    @PostMapping("searchOffer")
    public String searchOffer(@ModelAttribute SearchOfferData searchOfferData, Model model) {

        //apelam serviciul care ne returneaza lista de oferte cu pretul mai mic decat maximul
        List<TravelOfferModel> offerModels = offerService.findOffers(searchOfferData.getMaxPrice(), searchOfferData.getDestinationId());
        model.addAttribute("offers", offerModels);

        List<TravelDestinationModel> destinations = destinationService.getAll();
        model.addAttribute("destinations", destinations);
        model.addAttribute("searchOffer", searchOfferData);

        return "index";
    }
}
