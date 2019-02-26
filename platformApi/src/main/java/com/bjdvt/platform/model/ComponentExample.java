package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

public class ComponentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComponentExample() {
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

        public Criteria andSectionidIsNull() {
            addCriterion("sectionId is null");
            return (Criteria) this;
        }

        public Criteria andSectionidIsNotNull() {
            addCriterion("sectionId is not null");
            return (Criteria) this;
        }

        public Criteria andSectionidEqualTo(Integer value) {
            addCriterion("sectionId =", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotEqualTo(Integer value) {
            addCriterion("sectionId <>", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThan(Integer value) {
            addCriterion("sectionId >", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sectionId >=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThan(Integer value) {
            addCriterion("sectionId <", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidLessThanOrEqualTo(Integer value) {
            addCriterion("sectionId <=", value, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidIn(List<Integer> values) {
            addCriterion("sectionId in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotIn(List<Integer> values) {
            addCriterion("sectionId not in", values, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidBetween(Integer value1, Integer value2) {
            addCriterion("sectionId between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andSectionidNotBetween(Integer value1, Integer value2) {
            addCriterion("sectionId not between", value1, value2, "sectionid");
            return (Criteria) this;
        }

        public Criteria andComponentIsNull() {
            addCriterion("component is null");
            return (Criteria) this;
        }

        public Criteria andComponentIsNotNull() {
            addCriterion("component is not null");
            return (Criteria) this;
        }

        public Criteria andComponentEqualTo(Integer value) {
            addCriterion("component =", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotEqualTo(Integer value) {
            addCriterion("component <>", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentGreaterThan(Integer value) {
            addCriterion("component >", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentGreaterThanOrEqualTo(Integer value) {
            addCriterion("component >=", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLessThan(Integer value) {
            addCriterion("component <", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentLessThanOrEqualTo(Integer value) {
            addCriterion("component <=", value, "component");
            return (Criteria) this;
        }

        public Criteria andComponentIn(List<Integer> values) {
            addCriterion("component in", values, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotIn(List<Integer> values) {
            addCriterion("component not in", values, "component");
            return (Criteria) this;
        }

        public Criteria andComponentBetween(Integer value1, Integer value2) {
            addCriterion("component between", value1, value2, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNotBetween(Integer value1, Integer value2) {
            addCriterion("component not between", value1, value2, "component");
            return (Criteria) this;
        }

        public Criteria andComponentNameIsNull() {
            addCriterion("component_name is null");
            return (Criteria) this;
        }

        public Criteria andComponentNameIsNotNull() {
            addCriterion("component_name is not null");
            return (Criteria) this;
        }

        public Criteria andComponentNameEqualTo(String value) {
            addCriterion("component_name =", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotEqualTo(String value) {
            addCriterion("component_name <>", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameGreaterThan(String value) {
            addCriterion("component_name >", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameGreaterThanOrEqualTo(String value) {
            addCriterion("component_name >=", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLessThan(String value) {
            addCriterion("component_name <", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLessThanOrEqualTo(String value) {
            addCriterion("component_name <=", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameLike(String value) {
            addCriterion("component_name like", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotLike(String value) {
            addCriterion("component_name not like", value, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameIn(List<String> values) {
            addCriterion("component_name in", values, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotIn(List<String> values) {
            addCriterion("component_name not in", values, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameBetween(String value1, String value2) {
            addCriterion("component_name between", value1, value2, "componentName");
            return (Criteria) this;
        }

        public Criteria andComponentNameNotBetween(String value1, String value2) {
            addCriterion("component_name not between", value1, value2, "componentName");
            return (Criteria) this;
        }

        public Criteria andPageIdIsNull() {
            addCriterion("page_id is null");
            return (Criteria) this;
        }

        public Criteria andPageIdIsNotNull() {
            addCriterion("page_id is not null");
            return (Criteria) this;
        }

        public Criteria andPageIdEqualTo(String value) {
            addCriterion("page_id =", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotEqualTo(String value) {
            addCriterion("page_id <>", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdGreaterThan(String value) {
            addCriterion("page_id >", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdGreaterThanOrEqualTo(String value) {
            addCriterion("page_id >=", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLessThan(String value) {
            addCriterion("page_id <", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLessThanOrEqualTo(String value) {
            addCriterion("page_id <=", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdLike(String value) {
            addCriterion("page_id like", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotLike(String value) {
            addCriterion("page_id not like", value, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdIn(List<String> values) {
            addCriterion("page_id in", values, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotIn(List<String> values) {
            addCriterion("page_id not in", values, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdBetween(String value1, String value2) {
            addCriterion("page_id between", value1, value2, "pageId");
            return (Criteria) this;
        }

        public Criteria andPageIdNotBetween(String value1, String value2) {
            addCriterion("page_id not between", value1, value2, "pageId");
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