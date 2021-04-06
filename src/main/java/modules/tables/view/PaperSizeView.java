package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.PaperSizeController;
import modules.tables.entity.PaperSize;


public class PaperSizeView extends AbstractTableDataView<PaperSize> {

    public PaperSizeView() {
        super();
        abstractTableController = new PaperSizeController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addTextField("Name");
    }
}
