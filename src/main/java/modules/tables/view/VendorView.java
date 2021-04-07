package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.VendorsController;
import modules.tables.entity.Vendor;

public class VendorView extends AbstractTableDataView<Vendor>{
    public VendorView() {
        super();
        abstractTableController= new VendorsController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addTextField("Name");
    }
}
