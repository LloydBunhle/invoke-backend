package invokesolution.invokebackend.controllers;

import invokesolution.invokebackend.model.GasPrice;
import invokesolution.invokebackend.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CSVController {
    private final CSVService csvService;

    @Autowired
    public CSVController(CSVService csvService) {
        this.csvService = csvService;
    }
       @GetMapping("/gas")
       public String importEmployees() {
          String filePath = "src/main/resources/static/daily_csv.csv";
           csvService.readCSVFile(filePath);
          return "Gas imported successfully.";
       }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGasPrice(){
        return  csvService.getAllGasPrice();
    }
}
