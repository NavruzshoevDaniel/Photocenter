package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.SaleOrderController;
import modules.tables.entity.SaleOrder;

public class SaleOrderView extends AbstractTableDataView<SaleOrder> {
    public SaleOrderView() {
        super();
        abstractTableController = new SaleOrderController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Product ID", 0);
        formPanel.addNumericField("Amount", 0);
    }
}
