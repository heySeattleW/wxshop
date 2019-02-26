package com.platform.entity.example;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 实体
 * 表名 nideshop_repair
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-11-21 09:25:22
 */
public class RepairExample extends AbstractExample  {
    private static final long serialVersionUID = 1L;

    @Override
    public Criteria or() {
        return (Criteria)super.or();
    }

    @Override
    public Criteria createCriteria() {
        return (Criteria)super.createCriteria();
    }

    @Override
    protected Criteria createCriteriaInternal() {
        return new Criteria();
    }

    public class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }

                public Criteria andAftersalesIdIsNull() {
            addCriterion("aftersales_id is null");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdIsNotNull() {
            addCriterion("aftersales_id is not null");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdEqualTo(Integer value) {
            addCriterion("aftersales_id =", value, "aftersalesId");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdNotEqualTo(Integer value) {
            addCriterion("aftersales_id <>", value, "aftersalesId");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdGreaterThan(Integer value) {
            addCriterion("aftersales_id >", value, "aftersalesId");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("aftersales_id >=", value, "aftersalesId");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdLessThan(Integer value) {
            addCriterion("aftersales_id <", value, "aftersalesId");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdLessThanOrEqualTo(Integer value) {
            addCriterion("aftersales_id <=", value, "aftersalesId");
            return (Criteria) this;
        }
            public Criteria andAftersalesIdIn(List<Integer> values) {
            addCriterion("aftersales_id in", values, "aftersalesId");
            return (Criteria) this;
        }

        public Criteria andaftersalesIdNotIn(List<Integer> values) {
            addCriterion("aftersales_id not in", values, "aftersalesId");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdBetween(Integer value1, Integer value2) {
            addCriterion("aftersales_id between", value1, value2, "aftersalesId");
            return (Criteria) this;
        }

        public Criteria andAftersalesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("aftersales_id not between", value1, value2, "aftersalesId");
            return (Criteria) this;
        }
            public Criteria andRepairTimeIsNull() {
            addCriterion("repair_time is null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeIsNotNull() {
            addCriterion("repair_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTimeEqualTo(Date value) {
            addCriterion("repair_time =", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotEqualTo(Date value) {
            addCriterion("repair_time <>", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThan(Date value) {
            addCriterion("repair_time >", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_time >=", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThan(Date value) {
            addCriterion("repair_time <", value, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeLessThanOrEqualTo(Date value) {
            addCriterion("repair_time <=", value, "repairTime");
            return (Criteria) this;
        }
            public Criteria andRepairTimeIn(List<Date> values) {
            addCriterion("repair_time in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andrepairTimeNotIn(List<Date> values) {
            addCriterion("repair_time not in", values, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeBetween(Date value1, Date value2) {
            addCriterion("repair_time between", value1, value2, "repairTime");
            return (Criteria) this;
        }

        public Criteria andRepairTimeNotBetween(Date value1, Date value2) {
            addCriterion("repair_time not between", value1, value2, "repairTime");
            return (Criteria) this;
        }
            public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }
            public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }
            public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andinfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
            return (Criteria) this;
        }
    }
}
