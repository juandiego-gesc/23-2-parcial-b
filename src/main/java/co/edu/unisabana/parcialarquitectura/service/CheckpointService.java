package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcialarquitectura.service.model.Checkin;
import co.edu.unisabana.parcialarquitectura.service.model.Checkout;
import co.edu.unisabana.parcialarquitectura.service.port.CheckpointDAO;
import org.springframework.stereotype.Service;


@Service
public class CheckpointService {

  final private CheckpointDAO checkpointDAO;

  public CheckpointService(CheckpointDAO checkpointDAO) {
    this.checkpointDAO = checkpointDAO;
  }

  public void checkout(CheckpointDTO checkpoint) {
    Checkin lastCheckin = checkpointDAO.findLastCheckin(checkpoint.driver, checkpoint.facility);
    if (lastCheckin == null) {
      throw new IllegalArgumentException("don't exist previously check in");
    }
    if (checkpoint.dayOfMonth > 30 || checkpoint.dayOfMonth < 1) {
      throw new IllegalArgumentException("Invalid date");
    }
    Checkout checkout = new Checkout(checkpoint.facility, checkpoint.driver, checkpoint.dayOfMonth);
    checkpointDAO.saveCheckout(checkout);
  }
}
