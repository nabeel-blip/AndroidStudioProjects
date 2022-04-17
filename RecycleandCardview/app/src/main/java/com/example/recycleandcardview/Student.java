package com.example.recycleandcardview;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    private int image;
    private String name;
    private String RollNo;
    private String department;

    public Student( String name, String department,int image ,String Roll ) {
        this.name = name;
        this.image = (image !=0 ? image:R.drawable.images);
        this.department = department;
        this.RollNo = Roll;
    }

    protected Student(Parcel in) {
        image = in.readInt();
        name = in.readString();
        RollNo = in.readString();
        department = in.readString();
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String rollNo) {
        RollNo = rollNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int
    getImage() {
        return image;
    }

    public void setImage(int image ) {
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(name);
        parcel.writeString(RollNo);
        parcel.writeString(department);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
