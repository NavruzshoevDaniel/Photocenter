package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.PrintDiscountController;
import modules.tables.entity.PrintDiscount;

public class PrintDiscountView extends AbstractTableDataView<PrintDiscount> {
    public PrintDiscountView() {
        super();
        abstractTableController = new PrintDiscountController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Photo amount");
        formPanel.addNumericField("Discount");
    }
}
