package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

public class StyleButtonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StyleButtonExample() {
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

        public Criteria andInnerColorIsNull() {
            addCriterion("inner_color is null");
            return (Criteria) this;
        }

        public Criteria andInnerColorIsNotNull() {
            addCriterion("inner_color is not null");
            return (Criteria) this;
        }

        public Criteria andInnerColorEqualTo(String value) {
            addCriterion("inner_color =", value, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorNotEqualTo(String value) {
            addCriterion("inner_color <>", value, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorGreaterThan(String value) {
            addCriterion("inner_color >", value, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorGreaterThanOrEqualTo(String value) {
            addCriterion("inner_color >=", value, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorLessThan(String value) {
            addCriterion("inner_color <", value, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorLessThanOrEqualTo(String value) {
            addCriterion("inner_color <=", value, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorLike(String value) {
            addCriterion("inner_color like", value, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorNotLike(String value) {
            addCriterion("inner_color not like", value, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorIn(List<String> values) {
            addCriterion("inner_color in", values, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorNotIn(List<String> values) {
            addCriterion("inner_color not in", values, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorBetween(String value1, String value2) {
            addCriterion("inner_color between", value1, value2, "innerColor");
            return (Criteria) this;
        }

        public Criteria andInnerColorNotBetween(String value1, String value2) {
            addCriterion("inner_color not between", value1, value2, "innerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorIsNull() {
            addCriterion("outer_color is null");
            return (Criteria) this;
        }

        public Criteria andOuterColorIsNotNull() {
            addCriterion("outer_color is not null");
            return (Criteria) this;
        }

        public Criteria andOuterColorEqualTo(String value) {
            addCriterion("outer_color =", value, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorNotEqualTo(String value) {
            addCriterion("outer_color <>", value, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorGreaterThan(String value) {
            addCriterion("outer_color >", value, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorGreaterThanOrEqualTo(String value) {
            addCriterion("outer_color >=", value, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorLessThan(String value) {
            addCriterion("outer_color <", value, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorLessThanOrEqualTo(String value) {
            addCriterion("outer_color <=", value, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorLike(String value) {
            addCriterion("outer_color like", value, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorNotLike(String value) {
            addCriterion("outer_color not like", value, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorIn(List<String> values) {
            addCriterion("outer_color in", values, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorNotIn(List<String> values) {
            addCriterion("outer_color not in", values, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorBetween(String value1, String value2) {
            addCriterion("outer_color between", value1, value2, "outerColor");
            return (Criteria) this;
        }

        public Criteria andOuterColorNotBetween(String value1, String value2) {
            addCriterion("outer_color not between", value1, value2, "outerColor");
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

        public Criteria andOpacityEqualTo(Integer value) {
            addCriterion("opacity =", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityNotEqualTo(Integer value) {
            addCriterion("opacity <>", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityGreaterThan(Integer value) {
            addCriterion("opacity >", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityGreaterThanOrEqualTo(Integer value) {
            addCriterion("opacity >=", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityLessThan(Integer value) {
            addCriterion("opacity <", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityLessThanOrEqualTo(Integer value) {
            addCriterion("opacity <=", value, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityIn(List<Integer> values) {
            addCriterion("opacity in", values, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityNotIn(List<Integer> values) {
            addCriterion("opacity not in", values, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityBetween(Integer value1, Integer value2) {
            addCriterion("opacity between", value1, value2, "opacity");
            return (Criteria) this;
        }

        public Criteria andOpacityNotBetween(Integer value1, Integer value2) {
            addCriterion("opacity not between", value1, value2, "opacity");
            return (Criteria) this;
        }

        public Criteria andFixTopIsNull() {
            addCriterion("fix_top is null");
            return (Criteria) this;
        }

        public Criteria andFixTopIsNotNull() {
            addCriterion("fix_top is not null");
            return (Criteria) this;
        }

        public Criteria andFixTopEqualTo(String value) {
            addCriterion("fix_top =", value, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopNotEqualTo(String value) {
            addCriterion("fix_top <>", value, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopGreaterThan(String value) {
            addCriterion("fix_top >", value, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopGreaterThanOrEqualTo(String value) {
            addCriterion("fix_top >=", value, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopLessThan(String value) {
            addCriterion("fix_top <", value, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopLessThanOrEqualTo(String value) {
            addCriterion("fix_top <=", value, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopLike(String value) {
            addCriterion("fix_top like", value, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopNotLike(String value) {
            addCriterion("fix_top not like", value, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopIn(List<String> values) {
            addCriterion("fix_top in", values, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopNotIn(List<String> values) {
            addCriterion("fix_top not in", values, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopBetween(String value1, String value2) {
            addCriterion("fix_top between", value1, value2, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixTopNotBetween(String value1, String value2) {
            addCriterion("fix_top not between", value1, value2, "fixTop");
            return (Criteria) this;
        }

        public Criteria andFixBottomIsNull() {
            addCriterion("fix_bottom is null");
            return (Criteria) this;
        }

        public Criteria andFixBottomIsNotNull() {
            addCriterion("fix_bottom is not null");
            return (Criteria) this;
        }

        public Criteria andFixBottomEqualTo(String value) {
            addCriterion("fix_bottom =", value, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomNotEqualTo(String value) {
            addCriterion("fix_bottom <>", value, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomGreaterThan(String value) {
            addCriterion("fix_bottom >", value, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomGreaterThanOrEqualTo(String value) {
            addCriterion("fix_bottom >=", value, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomLessThan(String value) {
            addCriterion("fix_bottom <", value, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomLessThanOrEqualTo(String value) {
            addCriterion("fix_bottom <=", value, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomLike(String value) {
            addCriterion("fix_bottom like", value, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomNotLike(String value) {
            addCriterion("fix_bottom not like", value, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomIn(List<String> values) {
            addCriterion("fix_bottom in", values, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomNotIn(List<String> values) {
            addCriterion("fix_bottom not in", values, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomBetween(String value1, String value2) {
            addCriterion("fix_bottom between", value1, value2, "fixBottom");
            return (Criteria) this;
        }

        public Criteria andFixBottomNotBetween(String value1, String value2) {
            addCriterion("fix_bottom not between", value1, value2, "fixBottom");
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