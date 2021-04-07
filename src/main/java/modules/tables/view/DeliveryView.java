package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.DeliveryController;
import modules.tables.entity.Delivery;

public class DeliveryView extends AbstractTableDataView<Delivery> {
    public DeliveryView() {
        super();
        abstractTableController= new DeliveryController(this) ;
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Outlet id", 0);
        formPanel.addNumericField("Item id", 0);
        formPanel.addNumericField("Vendor id", 0);
        formPanel.addNumericField("Amount", 0);
        formPanel.addTextField("Delivery date");
        formPanel.addNumericField("Purchase price",0.0);
    }
}
