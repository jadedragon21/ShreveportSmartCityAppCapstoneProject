package com.tts.capstone.SmartShreveCity.MapApp.controller;



import com.tts.capstone.SmartShreveCity.MapApp.model.Location;
import com.tts.capstone.SmartShreveCity.MapApp.service.MapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MapController {

    private MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping(value="/weather")
    public String getDefaultMap(Model model) {
//        Location location = new Location();
//        location.setCity("Hartford");
//        location.setState("Connecticut");
//        mapService.addCoordinates(location);
//        System.out.println(location);
//        log.info("This is my location: {}", location);
        model.addAttribute(new Location());
        return "mappyweather.html";
    }

    @PostMapping(value="/weather")
    public String getMapForLocation(Location location, Model model) {
        mapService.addCoordinates(location);
        model.addAttribute(location);
        return "mappyweather.html";
    }


}
