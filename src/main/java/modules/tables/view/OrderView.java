package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.OrderController;
import modules.tables.entity.Order;

public class OrderView extends AbstractTableDataView<Order> {
    public OrderView() {
        super();
        abstractTableController = new OrderController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Receipt id", 0);
        formPanel.addBooleanField("Is urgent");
    }
}
