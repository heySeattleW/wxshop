package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

public class StylePhotoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StylePhotoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-09-12
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(String value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(String value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(String value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(String value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(String value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(String value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLike(String value) {
            addCriterion("width like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotLike(String value) {
            addCriterion("width not like", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<String> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<String> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(String value1, String value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(String value1, String value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(String value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(String value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(String value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(String value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(String value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(String value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLike(String value) {
            addCriterion("height like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotLike(String value) {
            addCriterion("height not like", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<String> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<String> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(String value1, String value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(String value1, String value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorIsNull() {
            addCriterion("background_color is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorIsNotNull() {
            addCriterion("background_color is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorEqualTo(String value) {
            addCriterion("background_color =", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorNotEqualTo(String value) {
            addCriterion("background_color <>", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorGreaterThan(String value) {
            addCriterion("background_color >", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorGreaterThanOrEqualTo(String value) {
            addCriterion("background_color >=", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorLessThan(String value) {
            addCriterion("background_color <", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorLessThanOrEqualTo(String value) {
            addCriterion("background_color <=", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorLike(String value) {
            addCriterion("background_color like", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorNotLike(String value) {
            addCriterion("background_color not like", value, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorIn(List<String> values) {
            addCriterion("background_color in", values, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorNotIn(List<String> values) {
            addCriterion("background_color not in", values, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorBetween(String value1, String value2) {
            addCriterion("background_color between", value1, value2, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andBackgroundColorNotBetween(String value1, String value2) {
            addCriterion("background_color not between", value1, value2, "backgroundColor");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftIsNull() {
            addCriterion("padding_left is null");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftIsNotNull() {
            addCriterion("padding_left is not null");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftEqualTo(String value) {
            addCriterion("padding_left =", value, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftNotEqualTo(String value) {
            addCriterion("padding_left <>", value, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftGreaterThan(String value) {
            addCriterion("padding_left >", value, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftGreaterThanOrEqualTo(String value) {
            addCriterion("padding_left >=", value, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftLessThan(String value) {
            addCriterion("padding_left <", value, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftLessThanOrEqualTo(String value) {
            addCriterion("padding_left <=", value, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftLike(String value) {
            addCriterion("padding_left like", value, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftNotLike(String value) {
            addCriterion("padding_left not like", value, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftIn(List<String> values) {
            addCriterion("padding_left in", values, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftNotIn(List<String> values) {
            addCriterion("padding_left not in", values, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftBetween(String value1, String value2) {
            addCriterion("padding_left between", value1, value2, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingLeftNotBetween(String value1, String value2) {
            addCriterion("padding_left not between", value1, value2, "paddingLeft");
            return (Criteria) this;
        }

        public Criteria andPaddingRightIsNull() {
            addCriterion("padding_right is null");
            return (Criteria) this;
        }

        public Criteria andPaddingRightIsNotNull() {
            addCriterion("padding_right is not null");
            return (Criteria) this;
        }

        public Criteria andPaddingRightEqualTo(String value) {
            addCriterion("padding_right =", value, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightNotEqualTo(String value) {
            addCriterion("padding_right <>", value, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightGreaterThan(String value) {
            addCriterion("padding_right >", value, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightGreaterThanOrEqualTo(String value) {
            addCriterion("padding_right >=", value, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightLessThan(String value) {
            addCriterion("padding_right <", value, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightLessThanOrEqualTo(String value) {
            addCriterion("padding_right <=", value, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightLike(String value) {
            addCriterion("padding_right like", value, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightNotLike(String value) {
            addCriterion("padding_right not like", value, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightIn(List<String> values) {
            addCriterion("padding_right in", values, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightNotIn(List<String> values) {
            addCriterion("padding_right not in", values, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightBetween(String value1, String value2) {
            addCriterion("padding_right between", value1, value2, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingRightNotBetween(String value1, String value2) {
            addCriterion("padding_right not between", value1, value2, "paddingRight");
            return (Criteria) this;
        }

        public Criteria andPaddingTopIsNull() {
            addCriterion("padding_top is null");
            return (Criteria) this;
        }

        public Criteria andPaddingTopIsNotNull() {
            addCriterion("padding_top is not null");
            return (Criteria) this;
        }

        public Criteria andPaddingTopEqualTo(String value) {
            addCriterion("padding_top =", value, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopNotEqualTo(String value) {
            addCriterion("padding_top <>", value, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopGreaterThan(String value) {
            addCriterion("padding_top >", value, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopGreaterThanOrEqualTo(String value) {
            addCriterion("padding_top >=", value, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopLessThan(String value) {
            addCriterion("padding_top <", value, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopLessThanOrEqualTo(String value) {
            addCriterion("padding_top <=", value, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopLike(String value) {
            addCriterion("padding_top like", value, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopNotLike(String value) {
            addCriterion("padding_top not like", value, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopIn(List<String> values) {
            addCriterion("padding_top in", values, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopNotIn(List<String> values) {
            addCriterion("padding_top not in", values, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopBetween(String value1, String value2) {
            addCriterion("padding_top between", value1, value2, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingTopNotBetween(String value1, String value2) {
            addCriterion("padding_top not between", value1, value2, "paddingTop");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomIsNull() {
            addCriterion("padding_bottom is null");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomIsNotNull() {
            addCriterion("padding_bottom is not null");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomEqualTo(String value) {
            addCriterion("padding_bottom =", value, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomNotEqualTo(String value) {
            addCriterion("padding_bottom <>", value, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomGreaterThan(String value) {
            addCriterion("padding_bottom >", value, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomGreaterThanOrEqualTo(String value) {
            addCriterion("padding_bottom >=", value, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomLessThan(String value) {
            addCriterion("padding_bottom <", value, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomLessThanOrEqualTo(String value) {
            addCriterion("padding_bottom <=", value, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomLike(String value) {
            addCriterion("padding_bottom like", value, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomNotLike(String value) {
            addCriterion("padding_bottom not like", value, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomIn(List<String> values) {
            addCriterion("padding_bottom in", values, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomNotIn(List<String> values) {
            addCriterion("padding_bottom not in", values, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomBetween(String value1, String value2) {
            addCriterion("padding_bottom between", value1, value2, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andPaddingBottomNotBetween(String value1, String value2) {
            addCriterion("padding_bottom not between", value1, value2, "paddingBottom");
            return (Criteria) this;
        }

        public Criteria andOpacityIsNull() {
            addCriterion("opacity is null");
            return (Criteria) this;
        }

        public Criteria andOpacityIsNotNull() {
            addCriterion("opacity is not null");
            return (Criteria) this;
        }

        public Criteria andOpacityEqualTo(String value) {
            addCriterion("opacity =", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityNotEqualTo(String value) {
            addCriterion("opacity <>", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityGreaterThan(String value) {
            addCriterion("opacity >", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityGreaterThanOrEqualTo(String value) {
            addCriterion("opacity >=", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityLessThan(String value) {
            addCriterion("opacity <", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityLessThanOrEqualTo(String value) {
            addCriterion("opacity <=", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityLike(String value) {
            addCriterion("opacity like", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityNotLike(String value) {
            addCriterion("opacity not like", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityIn(List<String> values) {
            addCriterion("opacity in", values, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityNotIn(List<String> values) {
            addCriterion("opacity not in", values, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityBetween(String value1, String value2) {
            addCriterion("opacity between", value1, value2, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityNotBetween(String value1, String value2) {
            addCriterion("opacity not between", value1, value2, "opacity");
            return (Criteria) this;
        }

        public Criteria andRadiusIsNull() {
            addCriterion("radius is null");
            return (Criteria) this;
        }

        public Criteria andRadiusIsNotNull() {
            addCriterion("radius is not null");
            return (Criteria) this;
        }

        public Criteria andRadiusEqualTo(String value) {
            addCriterion("radius =", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotEqualTo(String value) {
            addCriterion("radius <>", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusGreaterThan(String value) {
            addCriterion("radius >", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusGreaterThanOrEqualTo(String value) {
            addCriterion("radius >=", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusLessThan(String value) {
            addCriterion("radius <", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusLessThanOrEqualTo(String value) {
            addCriterion("radius <=", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusLike(String value) {
            addCriterion("radius like", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotLike(String value) {
            addCriterion("radius not like", value, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusIn(List<String> values) {
            addCriterion("radius in", values, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotIn(List<String> values) {
            addCriterion("radius not in", values, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusBetween(String value1, String value2) {
            addCriterion("radius between", value1, value2, "radius");
            return (Criteria) this;
        }

        public Criteria andRadiusNotBetween(String value1, String value2) {
            addCriterion("radius not between", value1, value2, "radius");
            return (Criteria) this;
        }

        public Criteria andShapeIsNull() {
            addCriterion("shape is null");
            return (Criteria) this;
        }

        public Criteria andShapeIsNotNull() {
            addCriterion("shape is not null");
            return (Criteria) this;
        }

        public Criteria andShapeEqualTo(String value) {
            addCriterion("shape =", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotEqualTo(String value) {
            addCriterion("shape <>", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeGreaterThan(String value) {
            addCriterion("shape >", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeGreaterThanOrEqualTo(String value) {
            addCriterion("shape >=", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLessThan(String value) {
            addCriterion("shape <", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLessThanOrEqualTo(String value) {
            addCriterion("shape <=", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeLike(String value) {
            addCriterion("shape like", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotLike(String value) {
            addCriterion("shape not like", value, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeIn(List<String> values) {
            addCriterion("shape in", values, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotIn(List<String> values) {
            addCriterion("shape not in", values, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeBetween(String value1, String value2) {
            addCriterion("shape between", value1, value2, "shape");
            return (Criteria) this;
        }

        public Criteria andShapeNotBetween(String value1, String value2) {
            addCriterion("shape not between", value1, value2, "shape");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolIsNull() {
            addCriterion("style_photocol is null");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolIsNotNull() {
            addCriterion("style_photocol is not null");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolEqualTo(String value) {
            addCriterion("style_photocol =", value, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolNotEqualTo(String value) {
            addCriterion("style_photocol <>", value, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolGreaterThan(String value) {
            addCriterion("style_photocol >", value, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolGreaterThanOrEqualTo(String value) {
            addCriterion("style_photocol >=", value, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolLessThan(String value) {
            addCriterion("style_photocol <", value, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolLessThanOrEqualTo(String value) {
            addCriterion("style_photocol <=", value, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolLike(String value) {
            addCriterion("style_photocol like", value, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolNotLike(String value) {
            addCriterion("style_photocol not like", value, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolIn(List<String> values) {
            addCriterion("style_photocol in", values, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolNotIn(List<String> values) {
            addCriterion("style_photocol not in", values, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolBetween(String value1, String value2) {
            addCriterion("style_photocol between", value1, value2, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andStylePhotocolNotBetween(String value1, String value2) {
            addCriterion("style_photocol not between", value1, value2, "stylePhotocol");
            return (Criteria) this;
        }

        public Criteria andPropsIdIsNull() {
            addCriterion("props_id is null");
            return (Criteria) this;
        }

        public Criteria andPropsIdIsNotNull() {
            addCriterion("props_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropsIdEqualTo(Integer value) {
            addCriterion("props_id =", value, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdNotEqualTo(Integer value) {
            addCriterion("props_id <>", value, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdGreaterThan(Integer value) {
            addCriterion("props_id >", value, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("props_id >=", value, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdLessThan(Integer value) {
            addCriterion("props_id <", value, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdLessThanOrEqualTo(Integer value) {
            addCriterion("props_id <=", value, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdIn(List<Integer> values) {
            addCriterion("props_id in", values, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdNotIn(List<Integer> values) {
            addCriterion("props_id not in", values, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdBetween(Integer value1, Integer value2) {
            addCriterion("props_id between", value1, value2, "propsId");
            return (Criteria) this;
        }

        public Criteria andPropsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("props_id not between", value1, value2, "propsId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2018-09-12
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}