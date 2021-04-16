package modules.quarries.views.factory;

import commons.view.factory.ViewFactory;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class QueriesViewFactory extends ViewFactory {
    private static final Path CONFIG_TABLE_FILE = Paths.get("queriesViews.properties");

    private QueriesViewFactory() {
        super();
    }

    @Override
    protected Path getConfigPath() {
        return CONFIG_TABLE_FILE;
    }

    public static QueriesViewFactory getInstance() {
        return QueriesViewFactory.Handle.INSTANCE;
    }

    private static class Handle {
        private static final QueriesViewFactory INSTANCE = new QueriesViewFactory();
    }

}
