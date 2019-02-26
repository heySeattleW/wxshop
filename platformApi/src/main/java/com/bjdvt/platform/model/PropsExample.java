package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

public class PropsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropsExample() {
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
     * @date 2018-09-13
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

        public Criteria andComponentIdIsNull() {
            addCriterion("component_id is null");
            return (Criteria) this;
        }

        public Criteria andComponentIdIsNotNull() {
            addCriterion("component_id is not null");
            return (Criteria) this;
        }

        public Criteria andComponentIdEqualTo(Integer value) {
            addCriterion("component_id =", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdNotEqualTo(Integer value) {
            addCriterion("component_id <>", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdGreaterThan(Integer value) {
            addCriterion("component_id >", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("component_id >=", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdLessThan(Integer value) {
            addCriterion("component_id <", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdLessThanOrEqualTo(Integer value) {
            addCriterion("component_id <=", value, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdIn(List<Integer> values) {
            addCriterion("component_id in", values, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdNotIn(List<Integer> values) {
            addCriterion("component_id not in", values, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdBetween(Integer value1, Integer value2) {
            addCriterion("component_id between", value1, value2, "componentId");
            return (Criteria) this;
        }

        public Criteria andComponentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("component_id not between", value1, value2, "componentId");
            return (Criteria) this;
        }

        public Criteria andSrcIsNull() {
            addCriterion("src is null");
            return (Criteria) this;
        }

        public Criteria andSrcIsNotNull() {
            addCriterion("src is not null");
            return (Criteria) this;
        }

        public Criteria andSrcEqualTo(Integer value) {
            addCriterion("src =", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotEqualTo(Integer value) {
            addCriterion("src <>", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcGreaterThan(Integer value) {
            addCriterion("src >", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcGreaterThanOrEqualTo(Integer value) {
            addCriterion("src >=", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcLessThan(Integer value) {
            addCriterion("src <", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcLessThanOrEqualTo(Integer value) {
            addCriterion("src <=", value, "src");
            return (Criteria) this;
        }

        public Criteria andSrcIn(List<Integer> values) {
            addCriterion("src in", values, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotIn(List<Integer> values) {
            addCriterion("src not in", values, "src");
            return (Criteria) this;
        }

        public Criteria andSrcBetween(Integer value1, Integer value2) {
            addCriterion("src between", value1, value2, "src");
            return (Criteria) this;
        }

        public Criteria andSrcNotBetween(Integer value1, Integer value2) {
            addCriterion("src not between", value1, value2, "src");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("text is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("text is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("text =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("text <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("text >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("text >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("text <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("text <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("text like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("text not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("text in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("text not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("text between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("text not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("subtitle is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("subtitle =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("subtitle <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("subtitle >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("subtitle >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("subtitle <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("subtitle <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("subtitle like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("subtitle not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("subtitle in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("subtitle not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("subtitle between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("subtitle not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleIsNull() {
            addCriterion("style_title is null");
            return (Criteria) this;
        }

        public Criteria andStyleTitleIsNotNull() {
            addCriterion("style_title is not null");
            return (Criteria) this;
        }

        public Criteria andStyleTitleEqualTo(String value) {
            addCriterion("style_title =", value, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleNotEqualTo(String value) {
            addCriterion("style_title <>", value, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleGreaterThan(String value) {
            addCriterion("style_title >", value, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("style_title >=", value, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleLessThan(String value) {
            addCriterion("style_title <", value, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleLessThanOrEqualTo(String value) {
            addCriterion("style_title <=", value, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleLike(String value) {
            addCriterion("style_title like", value, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleNotLike(String value) {
            addCriterion("style_title not like", value, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleIn(List<String> values) {
            addCriterion("style_title in", values, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleNotIn(List<String> values) {
            addCriterion("style_title not in", values, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleBetween(String value1, String value2) {
            addCriterion("style_title between", value1, value2, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleTitleNotBetween(String value1, String value2) {
            addCriterion("style_title not between", value1, value2, "styleTitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleIsNull() {
            addCriterion("style_subtitle is null");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleIsNotNull() {
            addCriterion("style_subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleEqualTo(String value) {
            addCriterion("style_subtitle =", value, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleNotEqualTo(String value) {
            addCriterion("style_subtitle <>", value, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleGreaterThan(String value) {
            addCriterion("style_subtitle >", value, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("style_subtitle >=", value, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleLessThan(String value) {
            addCriterion("style_subtitle <", value, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleLessThanOrEqualTo(String value) {
            addCriterion("style_subtitle <=", value, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleLike(String value) {
            addCriterion("style_subtitle like", value, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleNotLike(String value) {
            addCriterion("style_subtitle not like", value, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleIn(List<String> values) {
            addCriterion("style_subtitle in", values, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleNotIn(List<String> values) {
            addCriterion("style_subtitle not in", values, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleBetween(String value1, String value2) {
            addCriterion("style_subtitle between", value1, value2, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleSubtitleNotBetween(String value1, String value2) {
            addCriterion("style_subtitle not between", value1, value2, "styleSubtitle");
            return (Criteria) this;
        }

        public Criteria andStyleHeightIsNull() {
            addCriterion("style_height is null");
            return (Criteria) this;
        }

        public Criteria andStyleHeightIsNotNull() {
            addCriterion("style_height is not null");
            return (Criteria) this;
        }

        public Criteria andStyleHeightEqualTo(String value) {
            addCriterion("style_height =", value, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightNotEqualTo(String value) {
            addCriterion("style_height <>", value, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightGreaterThan(String value) {
            addCriterion("style_height >", value, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightGreaterThanOrEqualTo(String value) {
            addCriterion("style_height >=", value, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightLessThan(String value) {
            addCriterion("style_height <", value, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightLessThanOrEqualTo(String value) {
            addCriterion("style_height <=", value, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightLike(String value) {
            addCriterion("style_height like", value, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightNotLike(String value) {
            addCriterion("style_height not like", value, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightIn(List<String> values) {
            addCriterion("style_height in", values, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightNotIn(List<String> values) {
            addCriterion("style_height not in", values, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightBetween(String value1, String value2) {
            addCriterion("style_height between", value1, value2, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleHeightNotBetween(String value1, String value2) {
            addCriterion("style_height not between", value1, value2, "styleHeight");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorIsNull() {
            addCriterion("style_background_color is null");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorIsNotNull() {
            addCriterion("style_background_color is not null");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorEqualTo(String value) {
            addCriterion("style_background_color =", value, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorNotEqualTo(String value) {
            addCriterion("style_background_color <>", value, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorGreaterThan(String value) {
            addCriterion("style_background_color >", value, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorGreaterThanOrEqualTo(String value) {
            addCriterion("style_background_color >=", value, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorLessThan(String value) {
            addCriterion("style_background_color <", value, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorLessThanOrEqualTo(String value) {
            addCriterion("style_background_color <=", value, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorLike(String value) {
            addCriterion("style_background_color like", value, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorNotLike(String value) {
            addCriterion("style_background_color not like", value, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorIn(List<String> values) {
            addCriterion("style_background_color in", values, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorNotIn(List<String> values) {
            addCriterion("style_background_color not in", values, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorBetween(String value1, String value2) {
            addCriterion("style_background_color between", value1, value2, "styleBackgroundColor");
            return (Criteria) this;
        }

        public Criteria andStyleBackgroundColorNotBetween(String value1, String value2) {
            addCriterion("style_background_color not between", value1, value2, "styleBackgroundColor");
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
     * @date 2018-09-13
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