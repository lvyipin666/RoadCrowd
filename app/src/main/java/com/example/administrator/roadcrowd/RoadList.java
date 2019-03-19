package com.example.administrator.roadcrowd;

import java.util.List;

public class RoadList {
    List<Road> list;

    public List<Road> getList() {
        return list;
    }

    public void setList(List<Road> list) {
        this.list = list;
    }

    public static class Road{
        private String roadid;
        private String roadname;
        private String status;

        public String getRoadid() {
            return roadid;
        }

        public void setRoadid(String roadid) {
            this.roadid = roadid;
        }

        public String getRoadname() {
            return roadname;
        }

        public void setRoadname(String roadname) {
            this.roadname = roadname;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

}
