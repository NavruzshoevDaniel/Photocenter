package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.StorageController;
import modules.tables.entity.Storage;

public class StorageView extends AbstractTableDataView<Storage>{
    public StorageView() {
        super();
        abstractTableController= new StorageController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Id", 0);
        formPanel.addNumericField("Outlet id", 0);
        formPanel.addNumericField("Item id", 0);
        formPanel.addNumericField("Balance", 0);
    }
}
