package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.ServiceTypeController;
import modules.tables.entity.ServiceType;

public class ServiceTypeView extends AbstractTableDataView<ServiceType> {
    public ServiceTypeView() {
        super();
        abstractTableController = new ServiceTypeController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addTextField("Name");
        formPanel.addNumericField("Price", 0d);
    }
}
