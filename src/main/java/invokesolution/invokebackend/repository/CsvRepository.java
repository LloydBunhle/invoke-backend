package invokesolution.invokebackend.repository;

import invokesolution.invokebackend.model.GasPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvRepository extends JpaRepository<GasPrice, Long> {
}
