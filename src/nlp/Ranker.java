package nlp;

/**
 * Ranker an absturct class for calculating rank score of all sentences
 * Right now there are two implementations
 * PageRankRanker using pagerank algorithom and HitsRanker using hits
 * algorithom.
 */
public interface Ranker {
    /**
     * Given the Weight matrix A
     * return the vec needed after doing iterate algorithm.
     */
    public double[] getRankVec(double[][] A);
}