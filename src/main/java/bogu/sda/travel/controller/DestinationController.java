package bogu.sda.travel.controller;

import bogu.sda.travel.entity.CountryModel;
import bogu.sda.travel.entity.TravelDestinationModel;
import bogu.sda.travel.entity.TravelOfferModel;
import bogu.sda.travel.entity.UserModel;
import bogu.sda.travel.service.CountryService;
import bogu.sda.travel.service.DestinationService;
import bogu.sda.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserService userService;

    @GetMapping("getDestinations")
    public String getDestinations(Model model) {
        List<TravelDestinationModel> destinations = destinationService.getAll();
        model.addAttribute("title", "Titlul paginii");
        model.addAttribute("phoneNumber", "0784 112 112");
        model.addAttribute("destinations", destinations);
        UserModel userModel = userService.getCurrentUser();
        model.addAttribute("logout", userModel);
        return "travel-page";
    }

    @GetMapping("addDestinationPage")
    public String getAddDestinationPage(Model model) {
        List<CountryModel> countryModelList = countryService.getAll();
        model.addAttribute("destination", new TravelDestinationModel());
        model.addAttribute("countries", countryModelList);

        return "add-destination-page";
    }

    @PostMapping("addDestination")
    public String addDestination(@ModelAttribute TravelDestinationModel travelDestinationModel) {
        destinationService.addDestination(travelDestinationModel);

        return "redirect:/getDestinations";
    }

    @GetMapping("editDestinationPage")
    public String getEditDestinationPage(@RequestParam("id") long id, Model model) {
        TravelDestinationModel travelDestinationModel = destinationService.getById(id);
        List<CountryModel> countryModelList = countryService.getAll();

        model.addAttribute("destination", travelDestinationModel);
        model.addAttribute(countryModelList);

        return "edit-destination-page";
    }

    @PostMapping("editDestination")
    public String editDestination(@ModelAttribute TravelDestinationModel travelDestinationModel) {
        destinationService.editDestination(travelDestinationModel);
        return "redirect:/getDestinations";
    }

    @GetMapping("deleteDestination")
    public String deleteDestination(@RequestParam("id") long id, Model model) {
        destinationService.remove(id);
        return "redirect:/getDestinations";
    }

    @GetMapping("offers")
    public String viewOffers(@RequestParam ("id") long id, Model model) {
        TravelDestinationModel destination = destinationService.getById(id);
        List<TravelOfferModel> offers = destination.getOffers();
        model.addAttribute("offers", offers);

        return "view-offers-page";
    }

}




















