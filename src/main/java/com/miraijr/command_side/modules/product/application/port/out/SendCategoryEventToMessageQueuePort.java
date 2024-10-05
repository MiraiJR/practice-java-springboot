package com.miraijr.command_side.modules.product.application.port.out;

import com.miraijr.command_side.modules.product.domain.Category;

public interface SendCategoryEventToMessageQueuePort {
    void sendCategoryToExternalService(Category category);
}
