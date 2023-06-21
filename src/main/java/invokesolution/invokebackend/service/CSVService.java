package invokesolution.invokebackend.service;

import com.opencsv.CSVReader;
import invokesolution.invokebackend.model.GasPrice;
import invokesolution.invokebackend.repository.CsvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CSVService {
    private final CsvRepository csvRepository;

    @Autowired
    public CSVService(CsvRepository csvRepository) {
        this.csvRepository = csvRepository;
    }

    public void readCSVFile(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                String date = line[0];
                String price = line[1];

                GasPrice gasPrice = new GasPrice();
                gasPrice.setDate(date);
                gasPrice.setPrice(price);


                csvRepository.save(gasPrice);
            }
        } catch (Exception e) {
            // Handle any exceptions here
            e.printStackTrace();
        }
    }

    public ResponseEntity<?> getAllGasPrice(){
        try{
            List<GasPrice> allData = csvRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(allData));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Optional.of("No Content Found"));
        }
    }
}
