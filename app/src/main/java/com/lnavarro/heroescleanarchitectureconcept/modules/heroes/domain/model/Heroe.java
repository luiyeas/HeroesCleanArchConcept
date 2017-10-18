package com.lnavarro.heroescleanarchitectureconcept.modules.heroes.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luis on 17/10/17.
 */

public class Heroe implements Parcelable{

    private String name;

    private String photo;

    private String realName;

    private String height;

    private String power;

    private String abilities;

    private String groups;

    protected Heroe(Parcel in) {
        name = in.readString();
        photo = in.readString();
        realName = in.readString();
        height = in.readString();
        power = in.readString();
        abilities = in.readString();
        groups = in.readString();
    }

    public static final Creator<Heroe> CREATOR = new Creator<Heroe>() {
        @Override
        public Heroe createFromParcel(Parcel in) {
            return new Heroe(in);
        }

        @Override
        public Heroe[] newArray(int size) {
            return new Heroe[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(photo);
        dest.writeString(realName);
        dest.writeString(height);
        dest.writeString(power);
        dest.writeString(abilities);
        dest.writeString(groups);
    }
}
