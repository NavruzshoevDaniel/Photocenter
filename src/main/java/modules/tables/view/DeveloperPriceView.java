package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.DeveloperPricesController;
import modules.tables.entity.DeveloperPrice;

public class DeveloperPriceView extends AbstractTableDataView<DeveloperPrice>{
    public DeveloperPriceView() {
        super();
        abstractTableController= new DeveloperPricesController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addTextField("Price name");
        formPanel.addNumericField("Price",0d);
    }
}
