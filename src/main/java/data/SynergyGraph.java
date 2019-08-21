package data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uci.ics.jung.graph.Graph;

import model.Artifact;
import model.ArtifactItem;
import model.ArtifactValue;


public class SynergyGraph {

    private Map<ArtifactValue, List<ArtifactValue>> valueSynergy;
    private Graph<ArtifactItem, Integer> graph;
    private static SynergyGraph instance = null;


    private SynergyGraph() {}

    private SynergyGraph(HashMap<ArtifactValue, List<ArtifactValue>> synergyGraph) {
        valueSynergy = synergyGraph;
    }

    public static synchronized SynergyGraph getInstance(HashMap<ArtifactValue, List<ArtifactValue>> synergyGraph) {
        if (instance == null) {
            instance = new SynergyGraph(synergyGraph);
        }

        return instance;
    }

    public void addVertex(Artifact artifact) {
        for (ArtifactItem item : artifact.getItems()) {
            graph.addVertex(item);
        }
    }

    public void addEdges(Artifact artifact) {
        Integer edges = 0;
        ArtifactValue uValue, vValue;

        for (ArtifactItem u : artifact.getItems()) {
            uValue = u.getValue();

            for (ArtifactItem v : artifact.getItems()) {
                vValue = v.getValue();

                if (isSynergic(uValue, vValue)) {
                    graph.addEdge(edges++, u, v);
                }
            }
        }
    }

    private boolean isSynergic(ArtifactValue uValue, ArtifactValue vValue) {
        return valueSynergy.get(uValue.toString()).contains(vValue.toString());
    }


    public Map<ArtifactValue, List<ArtifactValue>> getValueSynergy() {
        return valueSynergy;
    }

    public void setValueSynergy(Map<ArtifactValue, List<ArtifactValue>> valueSynergy) {
        this.valueSynergy = valueSynergy;
    }

    public Graph<ArtifactItem, Integer> getGraph() {
        return graph;
    }

    public void setGraph(Graph<ArtifactItem, Integer> graph) {
        this.graph = graph;
    }

}