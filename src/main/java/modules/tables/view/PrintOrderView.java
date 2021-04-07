package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.PrintOrdersController;
import modules.tables.entity.PrintOrder;

public class PrintOrderView extends AbstractTableDataView<PrintOrder>{
    public PrintOrderView() {
        super();
        abstractTableController= new PrintOrdersController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Order id",0);
        formPanel.addNumericField("Discount",0);
    }
}
