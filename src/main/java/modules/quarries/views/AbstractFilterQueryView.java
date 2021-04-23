package modules.quarries.views;

import app.MainFrame;
import commons.sqlbuilder.Operation;
import commons.view.filters.FilterForm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import modules.quarries.controllers.IFilterQueryController;
import modules.quarries.dto.SearchCriteria;
import modules.quarries.dto.TableDto;
import modules.quarries.mappers.IQueryMapper;
import modules.quarries.views.gui.UnmodifiableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractFilterQueryView implements IFilterQueryView {
    private final JFrame jFrame;
    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private final JPanel filterPanel = new JPanel(new BorderLayout());
    private final JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
    private final List<ContainerFilter> filters = new ArrayList<>();
    private final JButton executeButton = new JButton("Запустить");
    private final DefaultTableModel defaultTableModel = new UnmodifiableModel();
    private final JTable table = new JTable(defaultTableModel);
    private final IFilterQueryController controller;

    protected AbstractFilterQueryView(IFilterQueryController controller) {
        this.jFrame = MainFrame.getMainFrame();
        this.controller = controller;
        configureUI();
        jFrame.setContentPane(mainPanel);
        jFrame.validate();
    }

    private void configureUI() {
        table.getTableHeader().setBackground(Color.CYAN);
        table.getTableHeader().setReorderingAllowed(false);

        splitPane.setBottomComponent(new JScrollPane(table));
        splitPane.setTopComponent(new JScrollPane(filterPanel));
        mainPanel.add(splitPane, BorderLayout.CENTER);
        configureFilters(filters);
        filters.forEach(filterForm -> filterPanel.add(filterForm.getFilterForm().getPanel()));
        filterPanel.add(executeButton, BorderLayout.SOUTH);
        executeButton.addActionListener(e -> {
            List<SearchCriteria> criteriaList = filters.stream()
                    .filter(ContainerFilter::isSelected)
                    .map(this::createCriteria)
                    .collect(Collectors.toList());
            controller.postSearchCriteria(criteriaList);
        });
    }

    private SearchCriteria createCriteria(ContainerFilter containerFilter) {
        IQueryMapper queryMapper = containerFilter.queryMapper;
        Operation operation = containerFilter.operation;
        Object value = containerFilter.filterForm.getValue();
        return new SearchCriteria(queryMapper, operation, value);
    }

    protected abstract void configureFilters(List<ContainerFilter> containerFilters);

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

    @Getter
    @AllArgsConstructor
    protected static class ContainerFilter {
        private final IQueryMapper queryMapper;
        private final FilterForm filterForm;
        private final Operation operation;

        public boolean isSelected(){
            return filterForm.isSelected();
        }
    }
}
