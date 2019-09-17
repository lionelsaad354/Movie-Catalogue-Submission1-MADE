package xyz.webflutter.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Pojo implements Parcelable {
    private String judul;
    private String tanggalRilis;
    private String bahasa;
    private String status;
    private String budget;
    private String revenue;
    private String deskripsi;
    private String actor1;
    private String actor2;
    private String actor3;
    private String genre;
    private int poster;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public String getActor3() {
        return actor3;
    }

    public void setActor3(String actor3) {
        this.actor3 = actor3;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.tanggalRilis);
        dest.writeString(this.bahasa);
        dest.writeString(this.status);
        dest.writeString(this.budget);
        dest.writeString(this.revenue);
        dest.writeString(this.deskripsi);
        dest.writeString(this.actor1);
        dest.writeString(this.actor2);
        dest.writeString(this.actor3);
        dest.writeString(this.genre);
        dest.writeInt(this.poster);
    }

    public Pojo() {
    }

    protected Pojo(Parcel in) {
        this.judul = in.readString();
        this.tanggalRilis = in.readString();
        this.bahasa = in.readString();
        this.status = in.readString();
        this.budget = in.readString();
        this.revenue = in.readString();
        this.deskripsi = in.readString();
        this.actor1 = in.readString();
        this.actor2 = in.readString();
        this.actor3 = in.readString();
        this.genre = in.readString();
        this.poster = in.readInt();
    }

    public static final Parcelable.Creator<Pojo> CREATOR = new Parcelable.Creator<Pojo>() {
        @Override
        public Pojo createFromParcel(Parcel source) {
            return new Pojo(source);
        }

        @Override
        public Pojo[] newArray(int size) {
            return new Pojo[size];
        }
    };
}