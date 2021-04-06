package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.PaperTypesController;
import modules.tables.entity.PaperType;

public class PaperTypeView extends AbstractTableDataView<PaperType> {

    public PaperTypeView() {
        super();
        abstractTableController = new PaperTypesController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addTextField("Name");
    }
}
