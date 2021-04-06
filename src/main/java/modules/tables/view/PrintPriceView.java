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
        formPanel.addNumericField("Paper size id");
        formPanel.addNumericField("Paper type id");
        formPanel.addNumericField("Price");
    }
}
