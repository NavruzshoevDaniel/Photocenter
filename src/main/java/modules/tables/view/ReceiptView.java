package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.ReceiptController;
import modules.tables.entity.Receipt;

public class ReceiptView extends AbstractTableDataView<Receipt> {
    public ReceiptView() {
        super();
        abstractTableController= new ReceiptController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Client id", 0);
        formPanel.addNumericField("Outlet id", 0);
        formPanel.addTextField("Current date");
        formPanel.addNumericField("Total", 0d);
    }
}
