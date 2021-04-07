package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.DeveloperOrderController;
import modules.tables.entity.DeveloperOrder;

public class DeveloperOrderView extends AbstractTableDataView<DeveloperOrder> {
    public DeveloperOrderView() {
        super();
        abstractTableController = new DeveloperOrderController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Film receipt id", 0);
    }
}
