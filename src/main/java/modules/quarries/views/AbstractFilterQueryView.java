package modules.quarries.views;

import commons.view.filters.FilterForm;
import commons.view.filters.SearchTextFormFilter;
import modules.quarries.dto.TableDto;
import modules.quarries.views.gui.UnmodifiableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbstractFilterQueryView implements IFilterQueryView {
    private final JFrame jFrame;
    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private final JPanel filterPanel = new JPanel(new BorderLayout());
    private final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    private final List<FilterForm> filters = new ArrayList<>();
    private final JButton executeButton = new JButton("Execute");
    private final DefaultTableModel defaultTableModel = new UnmodifiableModel();
    private final JTable table = new JTable(defaultTableModel);

    public AbstractFilterQueryView(JFrame frame) {
        this.jFrame = frame;
        configureUI();
        frame.setContentPane(mainPanel);
        frame.validate();
    }

    private void configureUI() {
        splitPane.setBottomComponent(new JScrollPane(table));
        splitPane.setTopComponent(new JScrollPane(filterPanel));
        mainPanel.add(splitPane, BorderLayout.CENTER);
        configureFilters();
        filters.forEach(filterForm -> filterPanel.add(filterForm.getPanel()));
        filterPanel.add(executeButton, BorderLayout.SOUTH);
    }

    private void configureFilters() {
        SearchTextFormFilter searchTextFormFilter = new SearchTextFormFilter(
                "Type of ordering points",
                Arrays.asList(2, 1, 2)
        );
        filters.add(searchTextFormFilter);
    }

    @Override
    public void updateTable(TableDto tableDto) {
        clearTable();
        tableDto.getColumns().forEach(defaultTableModel::addColumn);
        tableDto.getRows().forEach(row -> defaultTableModel.addRow(row.getColumns().toArray()));
    }

    private void clearTable() {
        defaultTableModel.setRowCount(0);
        defaultTableModel.setColumnCount(0);
    }
}
