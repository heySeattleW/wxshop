package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

public class StyleBoxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StyleBoxExample() {
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

        public Criteria andBorderStyleIsNull() {
            addCriterion("border_style is null");
            return (Criteria) this;
        }

        public Criteria andBorderStyleIsNotNull() {
            addCriterion("border_style is not null");
            return (Criteria) this;
        }

        public Criteria andBorderStyleEqualTo(String value) {
            addCriterion("border_style =", value, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleNotEqualTo(String value) {
            addCriterion("border_style <>", value, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleGreaterThan(String value) {
            addCriterion("border_style >", value, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleGreaterThanOrEqualTo(String value) {
            addCriterion("border_style >=", value, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleLessThan(String value) {
            addCriterion("border_style <", value, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleLessThanOrEqualTo(String value) {
            addCriterion("border_style <=", value, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleLike(String value) {
            addCriterion("border_style like", value, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleNotLike(String value) {
            addCriterion("border_style not like", value, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleIn(List<String> values) {
            addCriterion("border_style in", values, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleNotIn(List<String> values) {
            addCriterion("border_style not in", values, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleBetween(String value1, String value2) {
            addCriterion("border_style between", value1, value2, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderStyleNotBetween(String value1, String value2) {
            addCriterion("border_style not between", value1, value2, "borderStyle");
            return (Criteria) this;
        }

        public Criteria andBorderWidthIsNull() {
            addCriterion("border_width is null");
            return (Criteria) this;
        }

        public Criteria andBorderWidthIsNotNull() {
            addCriterion("border_width is not null");
            return (Criteria) this;
        }

        public Criteria andBorderWidthEqualTo(String value) {
            addCriterion("border_width =", value, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthNotEqualTo(String value) {
            addCriterion("border_width <>", value, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthGreaterThan(String value) {
            addCriterion("border_width >", value, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthGreaterThanOrEqualTo(String value) {
            addCriterion("border_width >=", value, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthLessThan(String value) {
            addCriterion("border_width <", value, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthLessThanOrEqualTo(String value) {
            addCriterion("border_width <=", value, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthLike(String value) {
            addCriterion("border_width like", value, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthNotLike(String value) {
            addCriterion("border_width not like", value, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthIn(List<String> values) {
            addCriterion("border_width in", values, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthNotIn(List<String> values) {
            addCriterion("border_width not in", values, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthBetween(String value1, String value2) {
            addCriterion("border_width between", value1, value2, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderWidthNotBetween(String value1, String value2) {
            addCriterion("border_width not between", value1, value2, "borderWidth");
            return (Criteria) this;
        }

        public Criteria andBorderColorIsNull() {
            addCriterion("border_color is null");
            return (Criteria) this;
        }

        public Criteria andBorderColorIsNotNull() {
            addCriterion("border_color is not null");
            return (Criteria) this;
        }

        public Criteria andBorderColorEqualTo(String value) {
            addCriterion("border_color =", value, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorNotEqualTo(String value) {
            addCriterion("border_color <>", value, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorGreaterThan(String value) {
            addCriterion("border_color >", value, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorGreaterThanOrEqualTo(String value) {
            addCriterion("border_color >=", value, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorLessThan(String value) {
            addCriterion("border_color <", value, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorLessThanOrEqualTo(String value) {
            addCriterion("border_color <=", value, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorLike(String value) {
            addCriterion("border_color like", value, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorNotLike(String value) {
            addCriterion("border_color not like", value, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorIn(List<String> values) {
            addCriterion("border_color in", values, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorNotIn(List<String> values) {
            addCriterion("border_color not in", values, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorBetween(String value1, String value2) {
            addCriterion("border_color between", value1, value2, "borderColor");
            return (Criteria) this;
        }

        public Criteria andBorderColorNotBetween(String value1, String value2) {
            addCriterion("border_color not between", value1, value2, "borderColor");
            return (Criteria) this;
        }

        public Criteria andShadowIsNull() {
            addCriterion("shadow is null");
            return (Criteria) this;
        }

        public Criteria andShadowIsNotNull() {
            addCriterion("shadow is not null");
            return (Criteria) this;
        }

        public Criteria andShadowEqualTo(String value) {
            addCriterion("shadow =", value, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowNotEqualTo(String value) {
            addCriterion("shadow <>", value, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowGreaterThan(String value) {
            addCriterion("shadow >", value, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowGreaterThanOrEqualTo(String value) {
            addCriterion("shadow >=", value, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowLessThan(String value) {
            addCriterion("shadow <", value, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowLessThanOrEqualTo(String value) {
            addCriterion("shadow <=", value, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowLike(String value) {
            addCriterion("shadow like", value, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowNotLike(String value) {
            addCriterion("shadow not like", value, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowIn(List<String> values) {
            addCriterion("shadow in", values, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowNotIn(List<String> values) {
            addCriterion("shadow not in", values, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowBetween(String value1, String value2) {
            addCriterion("shadow between", value1, value2, "shadow");
            return (Criteria) this;
        }

        public Criteria andShadowNotBetween(String value1, String value2) {
            addCriterion("shadow not between", value1, value2, "shadow");
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