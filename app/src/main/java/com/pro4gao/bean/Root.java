package com.pro4gao.bean;

import java.util.List;

/**
 * Created by gao on 2016/1/8.
 */
public class Root {

    /**
     * code : 200
     * hasmore : true
     * page_total : 8
     * data : {"services_list":[{"is_activity":"0","services_id":"187","services_name":"精油指压（芳香spa）","store_id":"55","store_name":"留指间玉养生馆 (亚运村店)","services_price":"398.00","services_time":"90","services_marketprice":"398.00","services_image":"2015/12/55_05041131154362678.png","services_salenum":"2","geval_scores":"5.0","evaluation_count":null,"latitude":"39.99554","longitude":"116.41795","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/55/2015/12/55_05041131154362678_360.png"},{"is_activity":"0","services_id":"186","services_name":"中医足底","store_id":"73","store_name":"华夏良子（北三环店）","services_price":"188.00","services_time":"60","services_marketprice":"288.00","services_image":"2015/11/73_05017834106426820.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.966965","longitude":"116.32906","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/73/2015/11/73_05017834106426820_360.jpg"},{"is_activity":"0","services_id":"185","services_name":"尚SPA","store_id":"73","store_name":"华夏良子（北三环店）","services_price":"318.00","services_time":"80","services_marketprice":"498.00","services_image":"2015/12/73_05041149511629406.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.966965","longitude":"116.32906","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/73/2015/12/73_05041149511629406_360.jpg"},{"is_activity":"0","services_id":"184","services_name":"尚SPA","store_id":"72","store_name":"华夏良子（北京二店）","services_price":"318.00","services_time":"80","services_marketprice":"498.00","services_image":"2015/12/72_05041148351851344.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.900135","longitude":"116.32422","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/72/2015/12/72_05041148351851344_360.jpg"},{"is_activity":"0","services_id":"182","services_name":"中医足底","store_id":"72","store_name":"华夏良子（北京二店）","services_price":"188.00","services_time":"60","services_marketprice":"288.00","services_image":"2015/11/72_05017825154061032.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.900135","longitude":"116.32422","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/72/2015/11/72_05017825154061032_360.jpg"},{"is_activity":"0","services_id":"181","services_name":"尚SPA","store_id":"71","store_name":"华夏良子（朝阳公园店）","services_price":"318.00","services_time":"80","services_marketprice":"498.00","services_image":"2015/11/71_05017821243976508.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.936604","longitude":"116.47461","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/71/2015/11/71_05017821243976508_360.jpg"},{"is_activity":"0","services_id":"180","services_name":"中医足底","store_id":"71","store_name":"华夏良子（朝阳公园店）","services_price":"188.00","services_time":"60","services_marketprice":"288.00","services_image":"2015/11/71_05017819794702711.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.936604","longitude":"116.47461","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/71/2015/11/71_05017819794702711_360.jpg"},{"is_activity":"0","services_id":"179","services_name":"中医足底","store_id":"70","store_name":"华夏良子（国贸店）","services_price":"188.00","services_time":"60","services_marketprice":"288.00","services_image":"2015/11/70_05017800272872818.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.909107","longitude":"116.46304","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/70/2015/11/70_05017800272872818_360.jpg"},{"is_activity":"0","services_id":"178","services_name":"尚SPA","store_id":"70","store_name":"华夏良子（国贸店）","services_price":"318.00","services_time":"80","services_marketprice":"498.00","services_image":"2015/12/70_05041147793201621.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.909107","longitude":"116.46304","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/70/2015/12/70_05041147793201621_360.jpg"},{"is_activity":"0","services_id":"177","services_name":"足部全息","store_id":"70","store_name":"华夏良子（国贸店）","services_price":"138.00","services_time":"70","services_marketprice":"218.00","services_image":"2015/11/70_05017797468588300.jpg","services_salenum":"0","geval_scores":"5.0","evaluation_count":null,"latitude":"39.909107","longitude":"116.46304","services_image_url":"http://www.kanglt.com/data/upload/shop/store/services/70/2015/11/70_05017797468588300_360.jpg"}]}
     */

    private int code;
    private boolean hasmore;
    private int page_total;
    private DataEntity data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public void setPage_total(int page_total) {
        this.page_total = page_total;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public boolean isHasmore() {
        return hasmore;
    }

    public int getPage_total() {
        return page_total;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        /**
         * is_activity : 0
         * services_id : 187
         * services_name : 精油指压（芳香spa）
         * store_id : 55
         * store_name : 留指间玉养生馆 (亚运村店)
         * services_price : 398.00
         * services_time : 90
         * services_marketprice : 398.00
         * services_image : 2015/12/55_05041131154362678.png
         * services_salenum : 2
         * geval_scores : 5.0
         * evaluation_count : null
         * latitude : 39.99554
         * longitude : 116.41795
         * services_image_url : http://www.kanglt.com/data/upload/shop/store/services/55/2015/12/55_05041131154362678_360.png
         */

        private List<ServicesListEntity> services_list;

        public void setServices_list(List<ServicesListEntity> services_list) {
            this.services_list = services_list;
        }

        public List<ServicesListEntity> getServices_list() {
            return services_list;
        }

        public static class ServicesListEntity {
            private String is_activity;
            private String services_id;
            private String services_name;
            private String store_id;
            private String store_name;
            private String services_price;
            private String services_time;
            private String services_marketprice;
            private String services_image;
            private String services_salenum;
            private String geval_scores;
            private Object evaluation_count;
            private String latitude;
            private String longitude;
            private String services_image_url;

            public void setIs_activity(String is_activity) {
                this.is_activity = is_activity;
            }

            public void setServices_id(String services_id) {
                this.services_id = services_id;
            }

            public void setServices_name(String services_name) {
                this.services_name = services_name;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public void setServices_price(String services_price) {
                this.services_price = services_price;
            }

            public void setServices_time(String services_time) {
                this.services_time = services_time;
            }

            public void setServices_marketprice(String services_marketprice) {
                this.services_marketprice = services_marketprice;
            }

            public void setServices_image(String services_image) {
                this.services_image = services_image;
            }

            public void setServices_salenum(String services_salenum) {
                this.services_salenum = services_salenum;
            }

            public void setGeval_scores(String geval_scores) {
                this.geval_scores = geval_scores;
            }

            public void setEvaluation_count(Object evaluation_count) {
                this.evaluation_count = evaluation_count;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public void setServices_image_url(String services_image_url) {
                this.services_image_url = services_image_url;
            }

            public String getIs_activity() {
                return is_activity;
            }

            public String getServices_id() {
                return services_id;
            }

            public String getServices_name() {
                return services_name;
            }

            public String getStore_id() {
                return store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public String getServices_price() {
                return services_price;
            }

            public String getServices_time() {
                return services_time;
            }

            public String getServices_marketprice() {
                return services_marketprice;
            }

            public String getServices_image() {
                return services_image;
            }

            public String getServices_salenum() {
                return services_salenum;
            }

            public String getGeval_scores() {
                return geval_scores;
            }

            public Object getEvaluation_count() {
                return evaluation_count;
            }

            public String getLatitude() {
                return latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public String getServices_image_url() {
                return services_image_url;
            }
        }
    }
}
