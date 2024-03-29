package parser;

import java.util.HashMap;
import java.util.Map;

import data.Instance;
import model.Artifact;
import model.ArtifactItem;


public abstract class DatasetParser {

    protected Map<String, Integer> attributes;


    public DatasetParser() {
        this.attributes = new HashMap<String, Integer>();
        addAttributes();
    }

    public Instance getInstance(Artifact artifact) {
        String attributeName;
        double[] dataInstance = new double[attributes.size()];

        for (ArtifactItem item : artifact.getItems()) {
            attributeName = (item.getFeature() + ":" + item.getValue()).toLowerCase();
            dataInstance[attributes.get(attributeName)]++;
        }

        return new Instance(dataInstance);
    }

    public Integer getNumberOfAttributes(){
        return attributes.size();
    }

    public abstract void addAttributes();


    public Map<String, Integer> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Integer> attributes) {
        this.attributes = attributes;
    }

}