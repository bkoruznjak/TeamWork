package hr.from.bkoruznjak.teamwork.detail;

import android.os.Parcel;
import android.os.Parcelable;

import hr.from.bkoruznjak.teamwork.network.model.Project;

/**
 * Created by bkoruznjak on 28/09/2017.
 */

public class ProjectDetail implements Parcelable {

    public static final String KEY = "ProjectDetail";
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

    // Constructor
    public ProjectDetail(Project project) {
        this.mId = Long.valueOf(project.getId());
        this.mName = project.getName();
        this.mDescription = project.getDescription();
    }

    // Parcelling part
    public ProjectDetail(Parcel in) {
        this.mId = in.readLong();
        this.mName = in.readString();
        this.mDescription = in.readString();
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
    }

    @Override
    public String toString() {
        return "ProjectDetail{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDescription='" + mDescription + '\'' +
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
}
