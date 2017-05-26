package com.qiaodan.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiverAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReceiverAddressExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNull() {
            addCriterion("receiverName is null");
            return (Criteria) this;
        }

        public Criteria andReceivernameIsNotNull() {
            addCriterion("receiverName is not null");
            return (Criteria) this;
        }

        public Criteria andReceivernameEqualTo(String value) {
            addCriterion("receiverName =", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotEqualTo(String value) {
            addCriterion("receiverName <>", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThan(String value) {
            addCriterion("receiverName >", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameGreaterThanOrEqualTo(String value) {
            addCriterion("receiverName >=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThan(String value) {
            addCriterion("receiverName <", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLessThanOrEqualTo(String value) {
            addCriterion("receiverName <=", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameLike(String value) {
            addCriterion("receiverName like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotLike(String value) {
            addCriterion("receiverName not like", value, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameIn(List<String> values) {
            addCriterion("receiverName in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotIn(List<String> values) {
            addCriterion("receiverName not in", values, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameBetween(String value1, String value2) {
            addCriterion("receiverName between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceivernameNotBetween(String value1, String value2) {
            addCriterion("receiverName not between", value1, value2, "receivername");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIsNull() {
            addCriterion("receiverAddress is null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIsNotNull() {
            addCriterion("receiverAddress is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressEqualTo(String value) {
            addCriterion("receiverAddress =", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotEqualTo(String value) {
            addCriterion("receiverAddress <>", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressGreaterThan(String value) {
            addCriterion("receiverAddress >", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiverAddress >=", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLessThan(String value) {
            addCriterion("receiverAddress <", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLessThanOrEqualTo(String value) {
            addCriterion("receiverAddress <=", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressLike(String value) {
            addCriterion("receiverAddress like", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotLike(String value) {
            addCriterion("receiverAddress not like", value, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressIn(List<String> values) {
            addCriterion("receiverAddress in", values, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotIn(List<String> values) {
            addCriterion("receiverAddress not in", values, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressBetween(String value1, String value2) {
            addCriterion("receiverAddress between", value1, value2, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiveraddressNotBetween(String value1, String value2) {
            addCriterion("receiverAddress not between", value1, value2, "receiveraddress");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNull() {
            addCriterion("receiverPhone is null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIsNotNull() {
            addCriterion("receiverPhone is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneEqualTo(Long value) {
            addCriterion("receiverPhone =", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotEqualTo(Long value) {
            addCriterion("receiverPhone <>", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThan(Long value) {
            addCriterion("receiverPhone >", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneGreaterThanOrEqualTo(Long value) {
            addCriterion("receiverPhone >=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThan(Long value) {
            addCriterion("receiverPhone <", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneLessThanOrEqualTo(Long value) {
            addCriterion("receiverPhone <=", value, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneIn(List<Long> values) {
            addCriterion("receiverPhone in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotIn(List<Long> values) {
            addCriterion("receiverPhone not in", values, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneBetween(Long value1, Long value2) {
            addCriterion("receiverPhone between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andReceiverphoneNotBetween(Long value1, Long value2) {
            addCriterion("receiverPhone not between", value1, value2, "receiverphone");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIsNull() {
            addCriterion("isDefault is null");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIsNotNull() {
            addCriterion("isDefault is not null");
            return (Criteria) this;
        }

        public Criteria andIsdefaultEqualTo(Boolean value) {
            addCriterion("isDefault =", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotEqualTo(Boolean value) {
            addCriterion("isDefault <>", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultGreaterThan(Boolean value) {
            addCriterion("isDefault >", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isDefault >=", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultLessThan(Boolean value) {
            addCriterion("isDefault <", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("isDefault <=", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIn(List<Boolean> values) {
            addCriterion("isDefault in", values, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotIn(List<Boolean> values) {
            addCriterion("isDefault not in", values, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("isDefault between", value1, value2, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isDefault not between", value1, value2, "isdefault");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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