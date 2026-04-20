package com.example.thigk2trantrunghung;

public class LandScape {
    String landImageFileName;
    String landCation;

    public LandScape(String landImageFileName, String landCation) {
        this.landImageFileName = landImageFileName;
        this.landCation = landCation;
    }

    public String getLandCation() {
        return landCation;
    }

    public void setLandCation(String landCation) {
        this.landCation = landCation;
    }

    public String getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }
}
