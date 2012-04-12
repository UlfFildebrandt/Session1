package arch.datadisplay.retrieval;

import java.util.HashMap;

public class DataAggregatorFactory {

    private static HashMap<String, IDataAggregatorCreator> AnalysisFunctionMap = new HashMap<String, IDataAggregatorCreator>();
    public static final String IDENTITY = "identity";
    public static final String MERGE = "merge";
    
    static {
        AnalysisFunctionMap.put(DataAggregatorFactory.IDENTITY, new IdentityCreator());
        AnalysisFunctionMap.put(DataAggregatorFactory.MERGE, new MergeCreator());
    }

    private DataAggregatorFactory() {
    }

    public static IDataAggregator getInstance(String type) {
        if (!AnalysisFunctionMap.containsKey(type))
            throw new IllegalArgumentException();

        return AnalysisFunctionMap.get(type).getInstance();
    }

}
