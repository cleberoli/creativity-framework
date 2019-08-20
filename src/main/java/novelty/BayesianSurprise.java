package novelty;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import parser.DatasetParser;

import data.Dataset;
import data.Instance;
import model.Artifact;


public class BayesianSurprise implements Novelty<Artifact> {

    Dataset dataset;
    DatasetParser parser;
    Double lambda;


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

    private double surprise(double data, double variance, double average) {
        if (variance == 0) {
            return 1.0;
        }

        double a = 1.0 / (2 * variance);
        double b = Math.pow(data - average, 2);
        return a * (variance + b);
    }

}