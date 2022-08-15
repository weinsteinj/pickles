package com.techelevator.model;



public class GeocodeResponse {
    private Results results;
    private String status;

    public GeocodeResponse(Results results, String status ) {
        this.results = results;
        this.status = status;
    }
    public GeocodeResponse () {}

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
