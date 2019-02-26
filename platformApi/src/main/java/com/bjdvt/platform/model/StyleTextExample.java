package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

public class StyleTextExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StyleTextExample() {
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

        public Criteria andBoldIsNull() {
            addCriterion("bold is null");
            return (Criteria) this;
        }

        public Criteria andBoldIsNotNull() {
            addCriterion("bold is not null");
            return (Criteria) this;
        }

        public Criteria andBoldEqualTo(String value) {
            addCriterion("bold =", value, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldNotEqualTo(String value) {
            addCriterion("bold <>", value, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldGreaterThan(String value) {
            addCriterion("bold >", value, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldGreaterThanOrEqualTo(String value) {
            addCriterion("bold >=", value, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldLessThan(String value) {
            addCriterion("bold <", value, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldLessThanOrEqualTo(String value) {
            addCriterion("bold <=", value, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldLike(String value) {
            addCriterion("bold like", value, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldNotLike(String value) {
            addCriterion("bold not like", value, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldIn(List<String> values) {
            addCriterion("bold in", values, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldNotIn(List<String> values) {
            addCriterion("bold not in", values, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldBetween(String value1, String value2) {
            addCriterion("bold between", value1, value2, "bold");
            return (Criteria) this;
        }

        public Criteria andBoldNotBetween(String value1, String value2) {
            addCriterion("bold not between", value1, value2, "bold");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andFontSizeIsNull() {
            addCriterion("font_size is null");
            return (Criteria) this;
        }

        public Criteria andFontSizeIsNotNull() {
            addCriterion("font_size is not null");
            return (Criteria) this;
        }

        public Criteria andFontSizeEqualTo(String value) {
            addCriterion("font_size =", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotEqualTo(String value) {
            addCriterion("font_size <>", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeGreaterThan(String value) {
            addCriterion("font_size >", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeGreaterThanOrEqualTo(String value) {
            addCriterion("font_size >=", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLessThan(String value) {
            addCriterion("font_size <", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLessThanOrEqualTo(String value) {
            addCriterion("font_size <=", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeLike(String value) {
            addCriterion("font_size like", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotLike(String value) {
            addCriterion("font_size not like", value, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeIn(List<String> values) {
            addCriterion("font_size in", values, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotIn(List<String> values) {
            addCriterion("font_size not in", values, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeBetween(String value1, String value2) {
            addCriterion("font_size between", value1, value2, "fontSize");
            return (Criteria) this;
        }

        public Criteria andFontSizeNotBetween(String value1, String value2) {
            addCriterion("font_size not between", value1, value2, "fontSize");
            return (Criteria) this;
        }

        public Criteria andAlignIsNull() {
            addCriterion("align is null");
            return (Criteria) this;
        }

        public Criteria andAlignIsNotNull() {
            addCriterion("align is not null");
            return (Criteria) this;
        }

        public Criteria andAlignEqualTo(String value) {
            addCriterion("align =", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotEqualTo(String value) {
            addCriterion("align <>", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignGreaterThan(String value) {
            addCriterion("align >", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignGreaterThanOrEqualTo(String value) {
            addCriterion("align >=", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLessThan(String value) {
            addCriterion("align <", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLessThanOrEqualTo(String value) {
            addCriterion("align <=", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignLike(String value) {
            addCriterion("align like", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotLike(String value) {
            addCriterion("align not like", value, "align");
            return (Criteria) this;
        }

        public Criteria andAlignIn(List<String> values) {
            addCriterion("align in", values, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotIn(List<String> values) {
            addCriterion("align not in", values, "align");
            return (Criteria) this;
        }

        public Criteria andAlignBetween(String value1, String value2) {
            addCriterion("align between", value1, value2, "align");
            return (Criteria) this;
        }

        public Criteria andAlignNotBetween(String value1, String value2) {
            addCriterion("align not between", value1, value2, "align");
            return (Criteria) this;
        }

        public Criteria andItalicIsNull() {
            addCriterion("italic is null");
            return (Criteria) this;
        }

        public Criteria andItalicIsNotNull() {
            addCriterion("italic is not null");
            return (Criteria) this;
        }

        public Criteria andItalicEqualTo(String value) {
            addCriterion("italic =", value, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicNotEqualTo(String value) {
            addCriterion("italic <>", value, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicGreaterThan(String value) {
            addCriterion("italic >", value, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicGreaterThanOrEqualTo(String value) {
            addCriterion("italic >=", value, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicLessThan(String value) {
            addCriterion("italic <", value, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicLessThanOrEqualTo(String value) {
            addCriterion("italic <=", value, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicLike(String value) {
            addCriterion("italic like", value, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicNotLike(String value) {
            addCriterion("italic not like", value, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicIn(List<String> values) {
            addCriterion("italic in", values, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicNotIn(List<String> values) {
            addCriterion("italic not in", values, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicBetween(String value1, String value2) {
            addCriterion("italic between", value1, value2, "italic");
            return (Criteria) this;
        }

        public Criteria andItalicNotBetween(String value1, String value2) {
            addCriterion("italic not between", value1, value2, "italic");
            return (Criteria) this;
        }

        public Criteria andUnderlineIsNull() {
            addCriterion("underline is null");
            return (Criteria) this;
        }

        public Criteria andUnderlineIsNotNull() {
            addCriterion("underline is not null");
            return (Criteria) this;
        }

        public Criteria andUnderlineEqualTo(String value) {
            addCriterion("underline =", value, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineNotEqualTo(String value) {
            addCriterion("underline <>", value, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineGreaterThan(String value) {
            addCriterion("underline >", value, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineGreaterThanOrEqualTo(String value) {
            addCriterion("underline >=", value, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineLessThan(String value) {
            addCriterion("underline <", value, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineLessThanOrEqualTo(String value) {
            addCriterion("underline <=", value, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineLike(String value) {
            addCriterion("underline like", value, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineNotLike(String value) {
            addCriterion("underline not like", value, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineIn(List<String> values) {
            addCriterion("underline in", values, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineNotIn(List<String> values) {
            addCriterion("underline not in", values, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineBetween(String value1, String value2) {
            addCriterion("underline between", value1, value2, "underline");
            return (Criteria) this;
        }

        public Criteria andUnderlineNotBetween(String value1, String value2) {
            addCriterion("underline not between", value1, value2, "underline");
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

        public Criteria andLineHeightIsNull() {
            addCriterion("line_height is null");
            return (Criteria) this;
        }

        public Criteria andLineHeightIsNotNull() {
            addCriterion("line_height is not null");
            return (Criteria) this;
        }

        public Criteria andLineHeightEqualTo(String value) {
            addCriterion("line_height =", value, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightNotEqualTo(String value) {
            addCriterion("line_height <>", value, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightGreaterThan(String value) {
            addCriterion("line_height >", value, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightGreaterThanOrEqualTo(String value) {
            addCriterion("line_height >=", value, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightLessThan(String value) {
            addCriterion("line_height <", value, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightLessThanOrEqualTo(String value) {
            addCriterion("line_height <=", value, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightLike(String value) {
            addCriterion("line_height like", value, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightNotLike(String value) {
            addCriterion("line_height not like", value, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightIn(List<String> values) {
            addCriterion("line_height in", values, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightNotIn(List<String> values) {
            addCriterion("line_height not in", values, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightBetween(String value1, String value2) {
            addCriterion("line_height between", value1, value2, "lineHeight");
            return (Criteria) this;
        }

        public Criteria andLineHeightNotBetween(String value1, String value2) {
            addCriterion("line_height not between", value1, value2, "lineHeight");
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