package com.platform.entity.example;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 实体
 * 表名 nideshop_ activity_conpon
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-29 13:56:24
 */
public class  ActivityConponExample extends AbstractExample  {
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

                public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }
            public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andactivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }
            public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Integer value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Integer value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Integer value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Integer value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }
            public Criteria andCouponIdIn(List<Integer> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andcouponIdNotIn(List<Integer> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }
    }
}
