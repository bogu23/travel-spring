package bogu.sda.travel.controller;

import bogu.sda.travel.entity.CustomerModel;
import bogu.sda.travel.entity.TravelDestinationModel;
import bogu.sda.travel.entity.TravelOfferModel;
import bogu.sda.travel.service.TravelOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OfferController {

    @Autowired
    private TravelOfferService travelOfferService;

    @GetMapping("reservations")
    public String getReservations(@RequestParam ("id") long id, Model model) {
        List<CustomerModel> customers = travelOfferService.getCustomers(id);
        model.addAttribute("customers", customers);
        return "client-page";
    }

    @GetMapping("addOfferPage")
    public String addOfferPage(@RequestParam ("id") long id, Model model) {
        TravelOfferModel travelOfferModel = new TravelOfferModel();
        TravelDestinationModel travelDestinationModel = new TravelDestinationModel();
        travelDestinationModel.setId(id);
        travelOfferModel.setDestination(travelDestinationModel);
        model.addAttribute("newOffer", travelOfferModel);

        return "add-offer-page";
    }

    @PostMapping("addOffer")
    public String addOffer(@ModelAttribute TravelOfferModel travelOfferModel) {
        travelOfferService.addOffer(travelOfferModel);

        return "redirect:/getDestinations";
    }


}
