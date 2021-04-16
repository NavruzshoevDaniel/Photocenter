package commons.sqlbuilder;

public class SubSelectBuilder extends SelectBuilder {

    private final String alias;

    public SubSelectBuilder(String alias) {
        this.alias = alias;
    }

    protected SubSelectBuilder(SubSelectBuilder other) {
        super(other);
        this.alias = other.alias;
    }

    @Override
    public SubSelectBuilder clone() {
        return new SubSelectBuilder(this);
    }

    @Override
    public String toString() {
        return "(" +
                super.toString() +
                ") as " +
                alias;
    }
}
