package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.JobController;
import modules.tables.entity.Job;

public class JobView extends AbstractTableDataView<Job> {

    public JobView() {
        super();
        abstractTableController = new JobController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        this.formPanel.addTextField("outlet id");
        this.formPanel.addTextField("profession Id");
        this.formPanel.addTextField("amount");
    }
}
