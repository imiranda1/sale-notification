package model;

import java.util.List;

public class Sale {
    private String clientName;
    private List<Integer> projectId;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Integer> getProjectId() {
        return projectId;
    }

    public void setProjectId(List<Integer> projectId) {
        this.projectId = projectId;
    }

    public Sale(String clientName, List<Integer> projectId) {
        this.clientName = clientName;
        this.projectId = projectId;


    }
}
