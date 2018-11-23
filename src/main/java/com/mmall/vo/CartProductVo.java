package com.mmall.vo;

import java.math.BigDecimal;

/**
 * @BelongsProject: cmall
 * @BelongsPackage: com.mmall.vo
 * @Author: 爱迪生
 * @CreateTime: 2018-11-09 13:46
 * @Description: 购物车商品vo
 */
public class CartProductVo {

    //结合了产品和购物车的一个抽象对象
    private Integer id;

    private Integer userId;

    private Integer productId;

    private Integer quantity;//购物车商品数量

    private String productName;//商品名称

    private String productSubtitle;//商品副标题

    private String productMainImage;//产品主图

    private BigDecimal productPrice;

    private String productStatus;//商品状态.1-在售 2-下架 3-删除

    private BigDecimal productTotalPrice;

    private Integer productStock;//商品库存

    private Integer productChecker;//此商品是否勾选

    private String limitQuantity;//限制数量的一个返回结果

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSubtitle() {
        return productSubtitle;
    }

    public void setProductSubtitle(String productSubtitle) {
        this.productSubtitle = productSubtitle;
    }

    public String getProductMainImage() {
        return productMainImage;
    }

    public void setProductMainImage(String productMainImage) {
        this.productMainImage = productMainImage;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getProductChecker() {
        return productChecker;
    }

    public void setProductChecker(Integer productChecker) {
        this.productChecker = productChecker;
    }

    public String getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(String limitQuantity) {
        this.limitQuantity = limitQuantity;
    }
}
