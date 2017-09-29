package hr.from.bkoruznjak.teamwork.detail;

import android.os.Parcel;
import android.os.Parcelable;

import hr.from.bkoruznjak.teamwork.network.model.Project;

/**
 * Created by bkoruznjak on 28/09/2017.
 */

public class ProjectDetail implements Parcelable {

    public static final String KEY = "ProjectDetail";
    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_ARCHIVE = "inactive";
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ProjectDetail createFromParcel(Parcel in) {
            return new ProjectDetail(in);
        }

        public ProjectDetail[] newArray(int size) {
            return new ProjectDetail[size];
        }
    };
    private long mId;
    private String mName;
    private String mDescription;
    private String mStartDate;
    private String mEndDate;
    private String mStatus;

    // Constructor
    public ProjectDetail(Project project) {
        this.mId = Long.valueOf(project.getId());
        this.mName = project.getName();
        this.mDescription = project.getDescription();
        this.mStatus = project.getStatus();
        this.mStartDate = project.getStartDate();
        this.mEndDate = project.getEndDate();
    }

    // Parcelling part
    public ProjectDetail(Parcel in) {
        this.mId = in.readLong();
        this.mName = in.readString();
        this.mDescription = in.readString();
        this.mStatus = in.readString();
        this.mStartDate = in.readString();
        this.mEndDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeLong(this.mId);
        destination.writeString(this.mName);
        destination.writeString(this.mDescription);
        destination.writeString(this.mStatus);
        destination.writeString(this.mStartDate);
        destination.writeString(this.mEndDate);
    }

    @Override
    public String toString() {
        return "ProjectDetail{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mStartDate='" + mStartDate + '\'' +
                ", mEndDate='" + mEndDate + '\'' +
                ", mStatus='" + mStatus + '\'' +
                '}';
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public String getStatus() {
        return mStatus;
    }
}
