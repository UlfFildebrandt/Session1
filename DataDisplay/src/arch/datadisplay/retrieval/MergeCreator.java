package arch.datadisplay.retrieval;

final class MergeCreator implements IDataAggregatorCreator {

    @Override
    public IDataAggregator getInstance() {
        return new MergeDataAggregator();
    }
}
