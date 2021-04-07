package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.ItemController;
import modules.tables.entity.Item;

public class ItemView extends AbstractTableDataView<Item> {

    public ItemView() {
        super();
        abstractTableController = new ItemController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Firm id", 0);
        formPanel.addTextField("Product name");
        formPanel.addNumericField("Price", 0);
    }
}
