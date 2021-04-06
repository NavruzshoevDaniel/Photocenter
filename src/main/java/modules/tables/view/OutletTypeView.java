package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.OutletTypesController;
import modules.tables.entity.OutletType;

public class OutletTypeView extends AbstractTableDataView<OutletType> {

    public OutletTypeView() {
        super();
        abstractTableController = new OutletTypesController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addTextField("Name");
    }
}
