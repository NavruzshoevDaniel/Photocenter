package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.ProfessionController;
import modules.tables.entity.Profession;

public class ProfessionView extends AbstractTableDataView<Profession>{
    public ProfessionView() {
       super();
       abstractTableController= new ProfessionController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addTextField("Profession");
    }
}
