package com.biao.retrofit.model;

import java.util.List;

/**
 * Created by benxiang on 2019/4/9.
 */

public class RoomStatus {

    /**
     * status : 1
     * data : [{"weixin_daily":"1.00","pmsroomtypeid":"dcf","room_type_id":"71","room_type":"精品大床房","daily":"0.01","weekend":"0.01","room_pic":"http://hoteldemo.rtiai.com/newhoteldemobackstage/static/upload/7d15b5bf9e1e5b94/f8ed59a86ad0b6da.jpg"},{"weixin_daily":"1.00","pmsroomtypeid":"TYDHY","room_type_id":"72","room_type":"情侣套房","daily":"0.01","weekend":"0.01","room_pic":"http://hoteldemo.rtiai.com/newhoteldemobackstage/static/upload/c7b536582eaaac7c/8553a013a1144e84.jpg"},{"weixin_daily":"0.01","pmsroomtypeid":"000","room_type_id":"66","room_type":"星座大床房","daily":"0.01","weekend":"0.01","room_pic":"http://hoteldemo.rtiai.com/newhoteldemobackstage/static/upload/4a75a1327ab2b486/8519c5e0466a5695.jpg"},{"weixin_daily":"0.01","pmsroomtypeid":"100","room_type_id":"67","room_type":"全景套房","daily":"0.01","weekend":"0.01","room_pic":"http://hoteldemo.rtiai.com/newhoteldemobackstage/static/upload/a0d1e562a6a0655f/5b5d61a0ec25b66c.jpg"},{"weixin_daily":"0.01","pmsroomtypeid":"BK","room_type_id":"68","room_type":"商务单人房","daily":"0.01","weekend":"0.01","room_pic":"http://hoteldemo.rtiai.com/newhoteldemobackstage/static/upload/3842cce49a3ea5af/552a6c5890415dac.jpg"},{"weixin_daily":"0.01","pmsroomtypeid":"bzj","room_type_id":"69","room_type":"行政双床房","daily":"0.01","weekend":"0.01","room_pic":"http://hoteldemo.rtiai.com/newhoteldemobackstage/static/upload/c950033bbead95da/0bb101fda1acad9a.jpg"},{"weixin_daily":"1.00","pmsroomtypeid":"DCA","room_type_id":"70","room_type":"标准单人间","daily":"0.01","weekend":"0.01","room_pic":"http://hoteldemo.rtiai.com/newhoteldemobackstage/static/upload/03e037de05e1f6e3/52fbac75c19a36a5.jpg"}]
     * reason :
     */

    private int status;
    private String reason;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * weixin_daily : 1.00
         * pmsroomtypeid : dcf
         * room_type_id : 71
         * room_type : 精品大床房
         * daily : 0.01
         * weekend : 0.01
         * room_pic : http://hoteldemo.rtiai.com/newhoteldemobackstage/static/upload/7d15b5bf9e1e5b94/f8ed59a86ad0b6da.jpg
         */

        private String weixin_daily;
        private String pmsroomtypeid;
        private String room_type_id;
        private String room_type;
        private String daily;
        private String weekend;
        private String room_pic;

        public String getWeixin_daily() {
            return weixin_daily;
        }

        public void setWeixin_daily(String weixin_daily) {
            this.weixin_daily = weixin_daily;
        }

        public String getPmsroomtypeid() {
            return pmsroomtypeid;
        }

        public void setPmsroomtypeid(String pmsroomtypeid) {
            this.pmsroomtypeid = pmsroomtypeid;
        }

        public String getRoom_type_id() {
            return room_type_id;
        }

        public void setRoom_type_id(String room_type_id) {
            this.room_type_id = room_type_id;
        }

        public String getRoom_type() {
            return room_type;
        }

        public void setRoom_type(String room_type) {
            this.room_type = room_type;
        }

        public String getDaily() {
            return daily;
        }

        public void setDaily(String daily) {
            this.daily = daily;
        }

        public String getWeekend() {
            return weekend;
        }

        public void setWeekend(String weekend) {
            this.weekend = weekend;
        }

        public String getRoom_pic() {
            return room_pic;
        }

        public void setRoom_pic(String room_pic) {
            this.room_pic = room_pic;
        }
    }
}
