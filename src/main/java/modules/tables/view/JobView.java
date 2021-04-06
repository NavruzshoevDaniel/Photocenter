package modules.tables.view;

import modules.tables.controller.JobController;
import modules.tables.entity.Job;

import javax.swing.table.DefaultTableModel;

public class JobView extends AbstractTableDataView<Job> {

    public JobView() {
        super();
        abstractTableController = new JobController(this);
    }

    @Override
    protected void initEntryForm() {
        formPanel.addTextField("outlet id");
        formPanel.addTextField("profession Id");
        formPanel.addTextField("amount");
    }
}
