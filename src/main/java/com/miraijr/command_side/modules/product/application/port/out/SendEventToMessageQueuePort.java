package com.miraijr.command_side.modules.product.application.port.out;

import com.miraijr.command_side.modules.product.domain.Product;

public interface SendEventToMessageQueuePort {
  void sendProductToExternalService(Product product);
}
