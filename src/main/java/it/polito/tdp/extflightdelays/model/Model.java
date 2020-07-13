package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private List<Airport> aereoporti;
	
	public Model () {
		this.dao = new ExtFlightDelaysDAO();
	}
	
	public void creaGrafo(int mediaM) {
		this.grafo = new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		this.aereoporti= new ArrayList<>(dao.loadAllAirports().values());
		Graphs.addAllVertices(this.grafo, aereoporti);
		
		
		for(Arco a: dao.getArchi()) {
			if(a.getMedia()>mediaM) {
				Graphs.addEdge(this.grafo, a.getaA() , a.getaP(), a.getMedia());
			}
		}
		System.out.println(grafo.edgeSet().size());
		//return grafo;
	}
	
	public Graph<Airport, DefaultWeightedEdge> getGrafo(int media) {
	
		creaGrafo(media);
		
		return this.grafo;
	}
	
	public int getSizeV(int media) {
		//this.getGrafo(media);
		
		return this.grafo.vertexSet().size();
	}
	
	public int getSizeA(int media) {
		//this.getGrafo(media);
		
		return this.grafo.edgeSet().size();
	}
	
}
