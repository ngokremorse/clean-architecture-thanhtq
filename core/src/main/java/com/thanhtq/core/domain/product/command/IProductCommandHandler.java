package com.thanhtq.core.domain.product.command;

import com.thanhtq.core.domain.core.Command;
import com.thanhtq.core.domain.core.CommandHandler;

public interface IProductCommandHandler extends CommandHandler {

    void create(Command command);
    void update(Command command);
    void delete(Command command);
}
