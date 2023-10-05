package co.edu.unisabana.parcialarquitectura.service.port;

import co.edu.unisabana.parcialarquitectura.service.model.Checkin;
import co.edu.unisabana.parcialarquitectura.service.model.Checkout;

public interface CheckpointPort {

  void saveCheckout(Checkout checkpoints);

  Checkin findLastCheckin(String driver, String facility);

  void finishCheckin(Checkin checkin);
}