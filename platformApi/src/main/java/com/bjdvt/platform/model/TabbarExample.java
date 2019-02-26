package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

public class TabbarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabbarExample() {
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
     * @date 2018-10-09
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

        public Criteria andSelectedColorIsNull() {
            addCriterion("selected_color is null");
            return (Criteria) this;
        }

        public Criteria andSelectedColorIsNotNull() {
            addCriterion("selected_color is not null");
            return (Criteria) this;
        }

        public Criteria andSelectedColorEqualTo(String value) {
            addCriterion("selected_color =", value, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorNotEqualTo(String value) {
            addCriterion("selected_color <>", value, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorGreaterThan(String value) {
            addCriterion("selected_color >", value, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorGreaterThanOrEqualTo(String value) {
            addCriterion("selected_color >=", value, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorLessThan(String value) {
            addCriterion("selected_color <", value, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorLessThanOrEqualTo(String value) {
            addCriterion("selected_color <=", value, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorLike(String value) {
            addCriterion("selected_color like", value, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorNotLike(String value) {
            addCriterion("selected_color not like", value, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorIn(List<String> values) {
            addCriterion("selected_color in", values, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorNotIn(List<String> values) {
            addCriterion("selected_color not in", values, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorBetween(String value1, String value2) {
            addCriterion("selected_color between", value1, value2, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andSelectedColorNotBetween(String value1, String value2) {
            addCriterion("selected_color not between", value1, value2, "selectedColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorIsNull() {
            addCriterion("backgroun_color is null");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorIsNotNull() {
            addCriterion("backgroun_color is not null");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorEqualTo(String value) {
            addCriterion("backgroun_color =", value, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorNotEqualTo(String value) {
            addCriterion("backgroun_color <>", value, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorGreaterThan(String value) {
            addCriterion("backgroun_color >", value, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorGreaterThanOrEqualTo(String value) {
            addCriterion("backgroun_color >=", value, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorLessThan(String value) {
            addCriterion("backgroun_color <", value, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorLessThanOrEqualTo(String value) {
            addCriterion("backgroun_color <=", value, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorLike(String value) {
            addCriterion("backgroun_color like", value, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorNotLike(String value) {
            addCriterion("backgroun_color not like", value, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorIn(List<String> values) {
            addCriterion("backgroun_color in", values, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorNotIn(List<String> values) {
            addCriterion("backgroun_color not in", values, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorBetween(String value1, String value2) {
            addCriterion("backgroun_color between", value1, value2, "backgrounColor");
            return (Criteria) this;
        }

        public Criteria andBackgrounColorNotBetween(String value1, String value2) {
            addCriterion("backgroun_color not between", value1, value2, "backgrounColor");
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
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
     * @date 2018-10-09
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