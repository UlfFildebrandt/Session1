package arch.datadisplay.retrieval;

final class IdentityCreator implements IDataAggregatorCreator {

    @Override
    public IDataAggregator getInstance() {
        return new IdentityDataAggregator();
    }
}
