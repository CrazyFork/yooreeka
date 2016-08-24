package iweb2.ch4.clustering.hierarchical;

import iweb2.ch4.model.Cluster;
import iweb2.ch4.model.DataPoint;

import java.util.ArrayList;
import java.util.List;

/** A hierarchical agglomerative clustering algorithm based on single link */
public class SingleLinkAlgorithm {

    private DataPoint[] elements;
    private double[][] a;
    
    // Hierarchical Agglomerative Algorithm
    public SingleLinkAlgorithm(DataPoint[] elements, double[][] adjacencyMatrix) {
        this.elements = elements;
        this.a = adjacencyMatrix;
    }
    
    public Dendrogram cluster() {
        Dendrogram dnd = new Dendrogram("Distance");
        double d = 0;

        // initially load all elements as individual clusters
        List<Cluster> initialClusters = new ArrayList<Cluster>();
        for(DataPoint e : elements) {
            Cluster c = new Cluster(e);
            initialClusters.add(c);
        }
        
        dnd.addLevel(String.valueOf(d), initialClusters);

        d = 1.0;
        
        int k = initialClusters.size();
        
        while( k > 1 ) { // until all data merge to 1 cluster
            int oldK = k;
            List<Cluster> clusters = buildClusters(d);
            k = clusters.size();

            if( oldK != k ) { // add new level once there's new cluster change
                dnd.addLevel(String.valueOf(d), clusters);
            }

            d = d + 1;
        }

        return dnd;
    }
    
    // Implements Single Link Technique
    private List<Cluster> buildClusters(double distanceThreshold) {
        boolean[] usedElementFlags = new boolean[elements.length];
        List<Cluster> clusters = new ArrayList<Cluster>();
        for(int i = 0, n = a.length; i < n; i++) {
            List<DataPoint> clusterPoints = new ArrayList<DataPoint>();
            //只比较矩阵 左上到右下 对角线 上侧的数据, 每个点(feature)彼此之间的距离, 
            //之所以这么做因为对角线两侧的数据是重复的
            for(int j = i, k = a.length; j < k; j++) {
                if( a[i][j] <= distanceThreshold && usedElementFlags[j] == false ) {
                    clusterPoints.add(elements[j]);
                    usedElementFlags[j] = true;
                }
            }
            if( clusterPoints.size() > 0 ) {
                Cluster c = new Cluster(clusterPoints);
                clusters.add(c);
            }
        }
        return clusters;
    }
    
    public static void main(String[] args) {
        //Define data
        DataPoint[] elements = new DataPoint[5];
        elements[0] = new DataPoint("A", new double[] {});
        elements[1] = new DataPoint("B", new double[] {});
        elements[2] = new DataPoint("C", new double[] {});
        elements[3] = new DataPoint("D", new double[] {});
        elements[4] = new DataPoint("E", new double[] {});

        double[][] a = new double[][] {
            {0,1,2,2,3},
            {1,0,2,4,3},
            {2,2,0,1,5},
            {2,4,1,0,3},
            {3,3,5,3,0}
        };
        
        SingleLinkAlgorithm ca = new SingleLinkAlgorithm(elements, a);
        Dendrogram dnd = ca.cluster();
        dnd.printAll();
        //dnd.print(3);
    }
}
