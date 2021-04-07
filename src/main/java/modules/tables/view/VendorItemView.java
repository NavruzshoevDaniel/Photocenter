package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.VendorItemsController;
import modules.tables.entity.VendorItem;

public class VendorItemView extends AbstractTableDataView<VendorItem>{
    public VendorItemView() {
        super();
        abstractTableController= new VendorItemsController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Vendor id", 0);
        formPanel.addNumericField("Item id", 0);
    }
}
