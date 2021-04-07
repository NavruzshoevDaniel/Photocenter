package modules.tables.view;

import commons.view.EntryFormView;
import modules.tables.controller.FramesController;
import modules.tables.entity.Frame;

public class FrameView extends AbstractTableDataView<Frame>{
    public FrameView() {
        super();
        abstractTableController= new FramesController(this);
    }

    @Override
    protected void initEntryForm(EntryFormView formPanel) {
        formPanel.addNumericField("Print order id",0);
        formPanel.addNumericField("Paper size id",0);
        formPanel.addNumericField("Paper type id",0);
        formPanel.addTextField("Frame code");
        formPanel.addNumericField("Amount",0);
    }
}
