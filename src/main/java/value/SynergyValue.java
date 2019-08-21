package value;

import data.SynergyGraph;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.SparseMultigraph;
import model.Artifact;
import model.ArtifactItem;

import java.util.Collection;


public class SynergyValue implements Value {

    private SynergyGraph synergyGraph;


    public SynergyValue(SynergyGraph synergyGraph) {
        this.synergyGraph = synergyGraph;
    }

    public Double getValue(Artifact artifact) {
        synergyGraph.setGraph(new SparseMultigraph<ArtifactItem, Integer>());
        synergyGraph.addVertex(artifact);
        synergyGraph.addEdges(artifact);

        return 0.5*(kc() + p());
    }

    private Double p() {
        int e = synergyGraph.getGraph().getEdgeCount();
        int n = synergyGraph.getGraph().getVertexCount();
        return 1.0 * e / (n * (n - 1));
    }

    private Double kc() {
        DijkstraShortestPath<ArtifactItem, Integer> djk = new DijkstraShortestPath(synergyGraph.getGraph());
        Collection<ArtifactItem> vertices = synergyGraph.getGraph().getVertices();
        int vertexCount = synergyGraph.getGraph().getVertexCount();
        int paths = 0;

        for (ArtifactItem v1 : vertices) {
            for (ArtifactItem v2 : vertices) {
                if (!v1.equals(v2)) {
                    if (djk.getDistance(v1, v2) != null) {
                        paths++;
                    }
                }
            }
        }

        return (paths) / (1.0 * vertexCount * (vertexCount - 1));
    }


    public SynergyGraph getSynergyGraph() {
        return synergyGraph;
    }

    public void setSynergyGraph(SynergyGraph synergyGraph) {
        this.synergyGraph = synergyGraph;
    }

}