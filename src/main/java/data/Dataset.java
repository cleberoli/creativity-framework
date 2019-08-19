package data;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

    List<Instance> instances;
    Integer numberOfAttributes;


    public Dataset(Integer numberOfAttributes) {
        this.instances = new ArrayList<Instance>();
        this.numberOfAttributes = numberOfAttributes;
    }

    public Integer getNumberOfAttributes() {
        return numberOfAttributes;
    }

    public void setNumberOfAttributes(Integer numberOfAttributes) {
        this.numberOfAttributes = numberOfAttributes;
    }

    public Dataset(ArrayList<Instance> instances) {
        this.instances = instances;
        this.numberOfAttributes = instances.get(0).getAttributes().size();
    }

    public void addInstance(Instance instance){
        instances.add(instance);
    }

    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(ArrayList<Instance> instances) {
        this.instances = instances;
    }

    public List<Mean> getMeans() {
        List<Mean> means = new ArrayList<Mean>();

        for (int i = 0; i < numberOfAttributes; i++) {
            means.add(new Mean());
        }

        List<Double> instanceData;
        for (Instance instance : instances) {
            instanceData = instance.getAttributes();
            for (int i = 0; i < numberOfAttributes; i++) {
                means.get(i).increment(instanceData.get(i));
            }
        }

        return means;
    }

    public List<Variance> getVariances() {
        ArrayList<Variance> variances = new ArrayList<Variance>();
        List<Double> instanceData;

        for (int i = 0; i < numberOfAttributes; i++) {
            variances.add(new Variance());
        }

        for (Instance instance : instances) {
            instanceData = instance.getAttributes();
            for (int i = 0; i < numberOfAttributes; i++) {
                variances.get(i).increment(instanceData.get(i));
            }
        }

        return variances;
    }
}
