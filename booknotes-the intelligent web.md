# terms:


* Euclidean Distance:

    In mathematics, the Euclidean distance or Euclidean metric is the "ordinary" (i.e. straight-line)
    distance between two points in Euclidean space




## Chapter 04  -  Clustering: grouping things together



what this chapter tell:


what is clustering:

* the hard part

>This isn’t a conclusion that applies specifically to clustering, and you should always keep it in mind when designing intelligent applications. Clustering is the hardest case, because there’s no direct measure of success that the machine can use. Clusters aren’t known a priori; if they were you wouldn’t need a clustering algorithm to begin with! This is why clustering belongs in the category of machine learning known as unsuper- vised learning.

ceriterias

Members of a cluster should be very similar to each other (their neighbors) and very dissimilar to the
members of any other cluster in the entire set.



types of clustering methods:

    Clustering algorithms based on cluster structure:
      Hierarchical algorithms:

        agglomerative hierarchical:
          algorithms follows a bottom-up approach—starting with individual elements and forming
          clusters by associating them with other elements from the bottom up toward
          the global (super) cluster.


          The agglomerative algorithms differ with respect to two things:
            * The approach that they use for merging clusters at each step of the iteration
            * The definition of the adjacency matrix

        divisive hierarchical algorithms:
          follows a top-down approach—it starts with the global (super) cluster and
          proceeds by dividing the data into smaller clusters.  

      Partition

    Clustering algorithms based on data type and structure:
      Grid based

      Categorical:

      Constrained:


    Clustering algorithms based on data size:

      ...







key sections:

  4.2 An overview of clustering algorithms







notes:

* page.127 试图通过 Euclidean Distance 来计算相似性, 但是由于每个维度的数据没有normalize, 导致有些维度的数据
会掩盖其他维度的数据


* In the end, it’s the nature of the data that determines the success of the algorithms.
