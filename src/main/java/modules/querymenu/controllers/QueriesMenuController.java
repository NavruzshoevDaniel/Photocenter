package modules.querymenu.controllers;

import modules.querymenu.entity.IQuarries;
import modules.querymenu.router.IQuarriesRouter;
import modules.querymenu.router.QueriesRouter;
import modules.querymenu.view.IQueriesMenuView;
import modules.quarries.views.AbstractFilterQueryView;

public class QueriesMenuController implements IQueriesMenuController {
    private final IQuarries quarries;
    private final IQueriesMenuView queriesMenuView;
    private final IQuarriesRouter router= new QueriesRouter();

    public QueriesMenuController(IQuarries quarries, IQueriesMenuView queriesMenuView) {
        this.quarries = quarries;
        this.queriesMenuView = queriesMenuView;
    }

    @Override
    public void init() {
        queriesMenuView.addQuarriesList(quarries.getQuarriesNames());
    }

    @Override
    public void routeToQuery(String query) {
        AbstractFilterQueryView abstractFilterQueryView = new AbstractFilterQueryView(queriesMenuView.getJFrame());
    }

    @Override
    public void routeToMenu() {
        router.routeToMenu(queriesMenuView.getJFrame());
    }
}
