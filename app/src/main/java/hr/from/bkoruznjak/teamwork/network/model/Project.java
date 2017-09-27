
package hr.from.bkoruznjak.teamwork.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Project {

    @SerializedName("replyByEmailEnabled")
    @Expose
    private Boolean replyByEmailEnabled;
    @SerializedName("starred")
    @Expose
    private Boolean starred;
    @SerializedName("show-announcement")
    @Expose
    private Boolean showAnnouncement;
    @SerializedName("harvest-timers-enabled")
    @Expose
    private Boolean harvestTimersEnabled;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("subStatus")
    @Expose
    private String subStatus;
    @SerializedName("defaultPrivacy")
    @Expose
    private String defaultPrivacy;
    @SerializedName("integrations")
    @Expose
    private Integrations integrations;
    @SerializedName("created-on")
    @Expose
    private String createdOn;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("filesAutoNewVersion")
    @Expose
    private Boolean filesAutoNewVersion;
    @SerializedName("overview-start-page")
    @Expose
    private String overviewStartPage;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("last-changed-on")
    @Expose
    private String lastChangedOn;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("defaults")
    @Expose
    private Defaults defaults;
    @SerializedName("company")
    @Expose
    private Company company;
    @SerializedName("tasks-start-page")
    @Expose
    private String tasksStartPage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("privacyEnabled")
    @Expose
    private Boolean privacyEnabled;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("announcement")
    @Expose
    private String announcement;
    @SerializedName("isProjectAdmin")
    @Expose
    private Boolean isProjectAdmin;
    @SerializedName("start-page")
    @Expose
    private String startPage;
    @SerializedName("notifyeveryone")
    @Expose
    private Boolean notifyeveryone;
    @SerializedName("boardData")
    @Expose
    private BoardData boardData;
    @SerializedName("announcementHTML")
    @Expose
    private String announcementHTML;

    public Boolean getReplyByEmailEnabled() {
        return replyByEmailEnabled;
    }

    public void setReplyByEmailEnabled(Boolean replyByEmailEnabled) {
        this.replyByEmailEnabled = replyByEmailEnabled;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    public Boolean getShowAnnouncement() {
        return showAnnouncement;
    }

    public void setShowAnnouncement(Boolean showAnnouncement) {
        this.showAnnouncement = showAnnouncement;
    }

    public Boolean getHarvestTimersEnabled() {
        return harvestTimersEnabled;
    }

    public void setHarvestTimersEnabled(Boolean harvestTimersEnabled) {
        this.harvestTimersEnabled = harvestTimersEnabled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getDefaultPrivacy() {
        return defaultPrivacy;
    }

    public void setDefaultPrivacy(String defaultPrivacy) {
        this.defaultPrivacy = defaultPrivacy;
    }

    public Integrations getIntegrations() {
        return integrations;
    }

    public void setIntegrations(Integrations integrations) {
        this.integrations = integrations;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getFilesAutoNewVersion() {
        return filesAutoNewVersion;
    }

    public void setFilesAutoNewVersion(Boolean filesAutoNewVersion) {
        this.filesAutoNewVersion = filesAutoNewVersion;
    }

    public String getOverviewStartPage() {
        return overviewStartPage;
    }

    public void setOverviewStartPage(String overviewStartPage) {
        this.overviewStartPage = overviewStartPage;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastChangedOn() {
        return lastChangedOn;
    }

    public void setLastChangedOn(String lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Defaults getDefaults() {
        return defaults;
    }

    public void setDefaults(Defaults defaults) {
        this.defaults = defaults;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getTasksStartPage() {
        return tasksStartPage;
    }

    public void setTasksStartPage(String tasksStartPage) {
        this.tasksStartPage = tasksStartPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPrivacyEnabled() {
        return privacyEnabled;
    }

    public void setPrivacyEnabled(Boolean privacyEnabled) {
        this.privacyEnabled = privacyEnabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public Boolean getIsProjectAdmin() {
        return isProjectAdmin;
    }

    public void setIsProjectAdmin(Boolean isProjectAdmin) {
        this.isProjectAdmin = isProjectAdmin;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }

    public Boolean getNotifyeveryone() {
        return notifyeveryone;
    }

    public void setNotifyeveryone(Boolean notifyeveryone) {
        this.notifyeveryone = notifyeveryone;
    }

    public BoardData getBoardData() {
        return boardData;
    }

    public void setBoardData(BoardData boardData) {
        this.boardData = boardData;
    }

    public String getAnnouncementHTML() {
        return announcementHTML;
    }

    public void setAnnouncementHTML(String announcementHTML) {
        this.announcementHTML = announcementHTML;
    }

}
