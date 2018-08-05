package server;

import com.google.gson.Gson;
import models.Beer;
import models.BeerStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.management.MonitorInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/api/beerlist")
public class BeerAPI {

    @PostMapping
    @ResponseBody
    public ModelAndView createBeer(
            @RequestParam("name") String name,
            @RequestParam("abv") float abv
    ) {
        Beer beer = new Beer(name, abv);
        BeerStorage.beerList.put(beer.id, beer);
        return new ModelAndView("redirect:/beerlist");
    }

    @GetMapping
    @ResponseBody
    public List<Beer> getAllBeer() {
        Collection<Beer> beerList = BeerStorage.beerList.values();
        return new ArrayList<>(beerList);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Beer getOneBeer(@PathVariable("id") int id) {
        Beer result = BeerStorage.beerList.get(id);
        return result;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Beer updateBeer(
            @PathVariable("id") int id,
            @RequestBody String body
    ) {
        Gson gson = new Gson();
        Beer newBeer = gson.fromJson(body, Beer.class);

        Beer beer = BeerStorage.beerList.get(id);
        beer.name = newBeer.name;
        beer.abv = newBeer.abv;
        return beer;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Beer deleteBeer(@PathVariable("id") int id) {
        Beer beer = BeerStorage.beerList.get(id);
        BeerStorage.beerList.remove(id);
        return beer;
    }
}