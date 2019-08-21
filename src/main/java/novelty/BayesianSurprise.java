package novelty;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import parser.DatasetParser;

import data.Dataset;
import data.Instance;
import model.Artifact;


public class BayesianSurprise implements Novelty {

    private Dataset dataset;
    private DatasetParser parser;
    private Double lambda;


    public BayesianSurprise(Dataset dataset, DatasetParser parser, Double lambda) {
        this.dataset = dataset;
        this.parser = parser;
        this.lambda = lambda;
    }

    public Double getNovelty(Artifact artifact) {
        Instance instance = parser.getInstance(artifact);
        Double surprise = 0.0;

        List<Mean> means = dataset.getMeans();
        List<Variance> variances = dataset.getVariances();
        List<Double> data = instance.getAttributes();

        for (int i = 0; i < dataset.getNumberOfAttributes(); i++) {
            Double d = data.get(i);
            Mean mean = means.get(i);
            Double meanResult = mean.getResult();
            mean.increment(d);

            Variance variance = variances.get(i);
            Double varianceResult = variance.getResult();
            variance.increment(d);

            surprise += surprise(d, varianceResult, meanResult);
        }

        return 1.0 - Math.exp(-lambda * surprise);
    }

    private Double surprise(Double data, Double variance, Double average) {
        if (variance == 0) {
            return 1.0;
        }

        Double a = 1.0 / (2 * variance);
        Double b = Math.pow(data - average, 2);
        return a * (variance + b);
    }


    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public DatasetParser getParser() {
        return parser;
    }

    public void setParser(DatasetParser parser) {
        this.parser = parser;
    }

    public Double getLambda() {
        return lambda;
    }

    public void setLambda(Double lambda) {
        this.lambda = lambda;
    }

}