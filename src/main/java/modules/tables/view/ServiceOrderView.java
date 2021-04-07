package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.ServiceOrderController;
import modules.tables.entity.ServiceOrder;

public class ServiceOrderView extends AbstractTableDataView<ServiceOrder> {
    public ServiceOrderView() {
        super();
        abstractTableController= new ServiceOrderController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Order id", 0);
        formPanel.addNumericField("Service type id", 0);
    }
}
