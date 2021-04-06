package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.OutletController;
import modules.tables.entity.Outlet;

public class OutletView extends AbstractTableDataView<Outlet> {

    public OutletView() {
        super();
        abstractTableController= new OutletController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Outlet type id");
        formPanel.addNumericField("Related outlet id");
        formPanel.addTextField("Address");
    }
}
