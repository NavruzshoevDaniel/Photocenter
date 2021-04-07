package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.PrintPricesController;
import modules.tables.entity.PrintPrice;

public class PrintPriceView extends AbstractTableDataView<PrintPrice> {
    public PrintPriceView() {
        super();
        abstractTableController= new PrintPricesController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Paper size id", 0);
        formPanel.addNumericField("Paper type id", 0);
        formPanel.addNumericField("Price", 0);
    }
}
