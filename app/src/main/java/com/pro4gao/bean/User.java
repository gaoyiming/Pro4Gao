package com.pro4gao.bean;

/**
 * Created by gao on 2016/1/5.
 */
public class User {
    private String goods_id;//  商品编号
    private String page_total;//总页数
    private String goods_name; //产品名称
    private String store_name; //店铺名称
    private String goods_salenum;//产品销量
    private String goods_price;//产品价格
    private String goods_marketpritce;// 市场价
    private String geval_scores;// 评分
    private String goods_image; //图片名称
    private String goods_image_url;//图片地址
    private String is_special; //是否是电子券1是 0否

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }
}
