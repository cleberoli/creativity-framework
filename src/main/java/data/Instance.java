package data;

import java.util.ArrayList;
import java.util.List;

public class Instance {

    List<Double> attributes;


    public Instance() {
        this.attributes = new ArrayList<Double>();
    }

    public Instance(List<Double> instanceData) {
        this.attributes = instanceData;
    }

    public Instance(double[] instanceData) {
        this.attributes = new ArrayList<Double>();

        for (Double data : instanceData) {
            attributes.add(data);
        }
    }

    public List<Double> getAttributes() {
        return attributes;
    }

    public void addAttribute(Double data) {
        this.attributes.add(data);
    }

    public void addAttributes(List<Double> data) {
        this.attributes.addAll(data);
    }

    @Override
    public String toString() {
        return attributes.toString();
    }

}