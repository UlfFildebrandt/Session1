package arch.datadisplay.retrieval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import arch.datasourceinterface.DefaultDataItem;
import arch.datasourceinterface.IDataItem;
import arch.datasourceinterface.IDataSource;

final class MergeDataAggregator extends DataAggregator {

    @Override
    public List<IDataItem> get() {
        List<IDataItem> itemsList = new ArrayList<IDataItem>();
        Map<String, Integer> companyRevenueMap = new HashMap<String, Integer>();

        consolidate(companyRevenueMap);
        moveToItems(itemsList, companyRevenueMap);

        return itemsList;
    }

    private void moveToItems(List<IDataItem> itemsList, Map<String, Integer> companyRevenueMap) {
        Set<Entry<String, Integer>> entries = companyRevenueMap.entrySet();
        Iterator<Entry<String, Integer>> companyIterator = entries.iterator();
        while (companyIterator.hasNext()) {
            Entry<String, Integer> companyRevenueEntry = companyIterator.next();
            DefaultDataItem consolidatedEntry = new DefaultDataItem(companyRevenueEntry.getKey(), companyRevenueEntry.getValue());
            consolidatedEntry.setArea("Total");
            itemsList.add(consolidatedEntry);
        }
    }

    private void consolidate(Map<String, Integer> companyRevenueMap) {
        for (int dataSourcesIdx = 0; dataSourcesIdx < this.dataSources.size(); dataSourcesIdx++) {
            IDataSource dataSource = this.dataSources.get(dataSourcesIdx);

            List<IDataItem> itemsList = dataSource.getData();
            consolidateForArea(companyRevenueMap, itemsList);
        }
    }

    private void consolidateForArea(Map<String, Integer> companyRevenueMap, List<IDataItem> itemsList) {
        for (int itemIdx = 0; itemIdx < itemsList.size(); itemIdx++) {
            IDataItem item = itemsList.get(itemIdx);
            if (companyRevenueMap.containsKey(item.getCompany())) {
                addRevenueToExistingItem(companyRevenueMap, item);
            } else {
                createNewItem(companyRevenueMap, item);
            }
        }
    }

    private void createNewItem(Map<String, Integer> companyRevenueMap, IDataItem item) {
        companyRevenueMap.put(item.getCompany(), item.getRevenue());
    }

    private void addRevenueToExistingItem(Map<String, Integer> companyRevenueMap, IDataItem item) {
        Integer revenue = companyRevenueMap.get(item.getCompany());
        revenue = revenue + item.getRevenue();
        companyRevenueMap.put(item.getCompany(), revenue);
    }
}
