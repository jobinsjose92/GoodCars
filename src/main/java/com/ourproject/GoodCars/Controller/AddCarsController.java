package com.ourproject.GoodCars.Controller;

import com.ourproject.GoodCars.Data.VehicleRepo;
import com.ourproject.GoodCars.Model.cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class AddCarsController {

    private VehicleRepo vehicleRepo;
    public static String uploadDirectory = System.getProperty("user.dir")+ "/src/main/webapp/imagedata";

@Autowired
    public AddCarsController(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }
@GetMapping
    public String addCars(Model model)
{
    model.addAttribute("cars",new cars());
return "index";
}

@PostMapping
    public String handleCarForm(@ModelAttribute("cars") cars car, @RequestParam("img") MultipartFile file) {

    StringBuilder fileNames = new StringBuilder();
    String filename = car.getNumber() + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
    Path fileNameAndPath = Paths.get(uploadDirectory,filename);
    try {
        Files.write(fileNameAndPath,file.getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    }
    car.setPhoto(filename);

    this.vehicleRepo.save(car);

    return "redirect:/cars/view";

}

@GetMapping("/view")
    public String viewCars(Model model) {
    List<cars> car = (List<cars>) this.vehicleRepo.findAll();
    model.addAttribute("displaycars",car);
    return "view";
}

    @GetMapping("/adminview")
    public String adminviewCars(Model model) {
        List<cars> car = (List<cars>) this.vehicleRepo.findAll();
        model.addAttribute("viewcar",car);
        return "adminview";
    }

@GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id)
{

    this.vehicleRepo.deleteById(id);

return "redirect:/cars/adminview";
}





}
