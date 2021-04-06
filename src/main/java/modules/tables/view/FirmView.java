package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.FirmController;
import modules.tables.entity.Firm;

public class FirmView extends AbstractTableDataView<Firm> {
    public FirmView() {
        super();
        abstractTableController= new FirmController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addTextField("Name");
    }
}
