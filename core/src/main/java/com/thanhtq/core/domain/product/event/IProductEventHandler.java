package com.thanhtq.core.domain.product.event;

import com.thanhtq.core.domain.core.Event;
import com.thanhtq.core.domain.core.EventHandler;

public interface IProductEventHandler extends EventHandler {

    void created(Event event);
    void updated(Event event);
    void delete(Event event);
}
