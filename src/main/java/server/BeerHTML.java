package server;

import models.Beer;
import models.BeerStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/beerlist")
public class BeerHTML {
    @GetMapping
    public String beerList (Model model) {
        Collection<Beer> beers = BeerStorage.beerList.values();
        List<Beer> beerList = new ArrayList<>(beers);

        model.addAttribute("beerlist", beerList);
        return "all_beer";
    }

    @GetMapping("/new")
    public String beerList () {
        return "create_beer";
    }

    @GetMapping("/{id}/edit")
    public String beerList (
            @PathVariable("id") int id,
            Model model
    ) {
        Beer beer = BeerStorage.beerList.get(id);

        model.addAttribute("id", beer.id);
        model.addAttribute("name", beer.name);
        model.addAttribute("abv", beer.abv);

        return "edit_beer";
    }
}