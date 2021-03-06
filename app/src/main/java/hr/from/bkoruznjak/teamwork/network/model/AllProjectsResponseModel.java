
package hr.from.bkoruznjak.teamwork.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllProjectsResponseModel {

    @SerializedName("STATUS")
    @Expose
    private String sTATUS;
    @SerializedName("projects")
    @Expose
    private List<Project> projects = null;

    public String getSTATUS() {
        return sTATUS;
    }

    public void setSTATUS(String sTATUS) {
        this.sTATUS = sTATUS;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
