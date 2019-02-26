package com.bjdvt.platform.model;

import java.util.ArrayList;
import java.util.List;

public class TabbaritemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TabbaritemExample() {
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

        public Criteria andTabbarIdIsNull() {
            addCriterion("tabbar_id is null");
            return (Criteria) this;
        }

        public Criteria andTabbarIdIsNotNull() {
            addCriterion("tabbar_id is not null");
            return (Criteria) this;
        }

        public Criteria andTabbarIdEqualTo(Integer value) {
            addCriterion("tabbar_id =", value, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdNotEqualTo(Integer value) {
            addCriterion("tabbar_id <>", value, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdGreaterThan(Integer value) {
            addCriterion("tabbar_id >", value, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tabbar_id >=", value, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdLessThan(Integer value) {
            addCriterion("tabbar_id <", value, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdLessThanOrEqualTo(Integer value) {
            addCriterion("tabbar_id <=", value, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdIn(List<Integer> values) {
            addCriterion("tabbar_id in", values, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdNotIn(List<Integer> values) {
            addCriterion("tabbar_id not in", values, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdBetween(Integer value1, Integer value2) {
            addCriterion("tabbar_id between", value1, value2, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andTabbarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tabbar_id not between", value1, value2, "tabbarId");
            return (Criteria) this;
        }

        public Criteria andPagePathIsNull() {
            addCriterion("page_path is null");
            return (Criteria) this;
        }

        public Criteria andPagePathIsNotNull() {
            addCriterion("page_path is not null");
            return (Criteria) this;
        }

        public Criteria andPagePathEqualTo(String value) {
            addCriterion("page_path =", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotEqualTo(String value) {
            addCriterion("page_path <>", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathGreaterThan(String value) {
            addCriterion("page_path >", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathGreaterThanOrEqualTo(String value) {
            addCriterion("page_path >=", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLessThan(String value) {
            addCriterion("page_path <", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLessThanOrEqualTo(String value) {
            addCriterion("page_path <=", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathLike(String value) {
            addCriterion("page_path like", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotLike(String value) {
            addCriterion("page_path not like", value, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathIn(List<String> values) {
            addCriterion("page_path in", values, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotIn(List<String> values) {
            addCriterion("page_path not in", values, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathBetween(String value1, String value2) {
            addCriterion("page_path between", value1, value2, "pagePath");
            return (Criteria) this;
        }

        public Criteria andPagePathNotBetween(String value1, String value2) {
            addCriterion("page_path not between", value1, value2, "pagePath");
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

        public Criteria andIconPathIsNull() {
            addCriterion("icon_path is null");
            return (Criteria) this;
        }

        public Criteria andIconPathIsNotNull() {
            addCriterion("icon_path is not null");
            return (Criteria) this;
        }

        public Criteria andIconPathEqualTo(String value) {
            addCriterion("icon_path =", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathNotEqualTo(String value) {
            addCriterion("icon_path <>", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathGreaterThan(String value) {
            addCriterion("icon_path >", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathGreaterThanOrEqualTo(String value) {
            addCriterion("icon_path >=", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathLessThan(String value) {
            addCriterion("icon_path <", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathLessThanOrEqualTo(String value) {
            addCriterion("icon_path <=", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathLike(String value) {
            addCriterion("icon_path like", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathNotLike(String value) {
            addCriterion("icon_path not like", value, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathIn(List<String> values) {
            addCriterion("icon_path in", values, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathNotIn(List<String> values) {
            addCriterion("icon_path not in", values, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathBetween(String value1, String value2) {
            addCriterion("icon_path between", value1, value2, "iconPath");
            return (Criteria) this;
        }

        public Criteria andIconPathNotBetween(String value1, String value2) {
            addCriterion("icon_path not between", value1, value2, "iconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathIsNull() {
            addCriterion("selected_icon_path is null");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathIsNotNull() {
            addCriterion("selected_icon_path is not null");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathEqualTo(String value) {
            addCriterion("selected_icon_path =", value, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathNotEqualTo(String value) {
            addCriterion("selected_icon_path <>", value, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathGreaterThan(String value) {
            addCriterion("selected_icon_path >", value, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathGreaterThanOrEqualTo(String value) {
            addCriterion("selected_icon_path >=", value, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathLessThan(String value) {
            addCriterion("selected_icon_path <", value, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathLessThanOrEqualTo(String value) {
            addCriterion("selected_icon_path <=", value, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathLike(String value) {
            addCriterion("selected_icon_path like", value, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathNotLike(String value) {
            addCriterion("selected_icon_path not like", value, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathIn(List<String> values) {
            addCriterion("selected_icon_path in", values, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathNotIn(List<String> values) {
            addCriterion("selected_icon_path not in", values, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathBetween(String value1, String value2) {
            addCriterion("selected_icon_path between", value1, value2, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andSelectedIconPathNotBetween(String value1, String value2) {
            addCriterion("selected_icon_path not between", value1, value2, "selectedIconPath");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(String value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(String value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(String value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(String value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(String value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(String value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLike(String value) {
            addCriterion("active like", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotLike(String value) {
            addCriterion("active not like", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<String> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<String> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(String value1, String value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(String value1, String value2) {
            addCriterion("active not between", value1, value2, "active");
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