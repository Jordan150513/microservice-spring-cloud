package com.qiaodan.model;

import java.util.ArrayList;
import java.util.List;

public class GoodDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodDetailExample() {
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

        public Criteria andGoodnameIsNull() {
            addCriterion("goodName is null");
            return (Criteria) this;
        }

        public Criteria andGoodnameIsNotNull() {
            addCriterion("goodName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodnameEqualTo(String value) {
            addCriterion("goodName =", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameNotEqualTo(String value) {
            addCriterion("goodName <>", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameGreaterThan(String value) {
            addCriterion("goodName >", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameGreaterThanOrEqualTo(String value) {
            addCriterion("goodName >=", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameLessThan(String value) {
            addCriterion("goodName <", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameLessThanOrEqualTo(String value) {
            addCriterion("goodName <=", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameLike(String value) {
            addCriterion("goodName like", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameNotLike(String value) {
            addCriterion("goodName not like", value, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameIn(List<String> values) {
            addCriterion("goodName in", values, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameNotIn(List<String> values) {
            addCriterion("goodName not in", values, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameBetween(String value1, String value2) {
            addCriterion("goodName between", value1, value2, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodnameNotBetween(String value1, String value2) {
            addCriterion("goodName not between", value1, value2, "goodname");
            return (Criteria) this;
        }

        public Criteria andGoodcolorIsNull() {
            addCriterion("goodColor is null");
            return (Criteria) this;
        }

        public Criteria andGoodcolorIsNotNull() {
            addCriterion("goodColor is not null");
            return (Criteria) this;
        }

        public Criteria andGoodcolorEqualTo(String value) {
            addCriterion("goodColor =", value, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorNotEqualTo(String value) {
            addCriterion("goodColor <>", value, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorGreaterThan(String value) {
            addCriterion("goodColor >", value, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorGreaterThanOrEqualTo(String value) {
            addCriterion("goodColor >=", value, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorLessThan(String value) {
            addCriterion("goodColor <", value, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorLessThanOrEqualTo(String value) {
            addCriterion("goodColor <=", value, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorLike(String value) {
            addCriterion("goodColor like", value, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorNotLike(String value) {
            addCriterion("goodColor not like", value, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorIn(List<String> values) {
            addCriterion("goodColor in", values, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorNotIn(List<String> values) {
            addCriterion("goodColor not in", values, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorBetween(String value1, String value2) {
            addCriterion("goodColor between", value1, value2, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodcolorNotBetween(String value1, String value2) {
            addCriterion("goodColor not between", value1, value2, "goodcolor");
            return (Criteria) this;
        }

        public Criteria andGoodsizeIsNull() {
            addCriterion("goodSize is null");
            return (Criteria) this;
        }

        public Criteria andGoodsizeIsNotNull() {
            addCriterion("goodSize is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsizeEqualTo(String value) {
            addCriterion("goodSize =", value, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeNotEqualTo(String value) {
            addCriterion("goodSize <>", value, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeGreaterThan(String value) {
            addCriterion("goodSize >", value, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeGreaterThanOrEqualTo(String value) {
            addCriterion("goodSize >=", value, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeLessThan(String value) {
            addCriterion("goodSize <", value, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeLessThanOrEqualTo(String value) {
            addCriterion("goodSize <=", value, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeLike(String value) {
            addCriterion("goodSize like", value, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeNotLike(String value) {
            addCriterion("goodSize not like", value, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeIn(List<String> values) {
            addCriterion("goodSize in", values, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeNotIn(List<String> values) {
            addCriterion("goodSize not in", values, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeBetween(String value1, String value2) {
            addCriterion("goodSize between", value1, value2, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodsizeNotBetween(String value1, String value2) {
            addCriterion("goodSize not between", value1, value2, "goodsize");
            return (Criteria) this;
        }

        public Criteria andGoodpriceIsNull() {
            addCriterion("goodPrice is null");
            return (Criteria) this;
        }

        public Criteria andGoodpriceIsNotNull() {
            addCriterion("goodPrice is not null");
            return (Criteria) this;
        }

        public Criteria andGoodpriceEqualTo(Float value) {
            addCriterion("goodPrice =", value, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceNotEqualTo(Float value) {
            addCriterion("goodPrice <>", value, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceGreaterThan(Float value) {
            addCriterion("goodPrice >", value, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("goodPrice >=", value, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceLessThan(Float value) {
            addCriterion("goodPrice <", value, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceLessThanOrEqualTo(Float value) {
            addCriterion("goodPrice <=", value, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceIn(List<Float> values) {
            addCriterion("goodPrice in", values, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceNotIn(List<Float> values) {
            addCriterion("goodPrice not in", values, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceBetween(Float value1, Float value2) {
            addCriterion("goodPrice between", value1, value2, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodpriceNotBetween(Float value1, Float value2) {
            addCriterion("goodPrice not between", value1, value2, "goodprice");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountIsNull() {
            addCriterion("goodRemainCount is null");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountIsNotNull() {
            addCriterion("goodRemainCount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountEqualTo(Integer value) {
            addCriterion("goodRemainCount =", value, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountNotEqualTo(Integer value) {
            addCriterion("goodRemainCount <>", value, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountGreaterThan(Integer value) {
            addCriterion("goodRemainCount >", value, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodRemainCount >=", value, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountLessThan(Integer value) {
            addCriterion("goodRemainCount <", value, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountLessThanOrEqualTo(Integer value) {
            addCriterion("goodRemainCount <=", value, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountIn(List<Integer> values) {
            addCriterion("goodRemainCount in", values, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountNotIn(List<Integer> values) {
            addCriterion("goodRemainCount not in", values, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountBetween(Integer value1, Integer value2) {
            addCriterion("goodRemainCount between", value1, value2, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andGoodremaincountNotBetween(Integer value1, Integer value2) {
            addCriterion("goodRemainCount not between", value1, value2, "goodremaincount");
            return (Criteria) this;
        }

        public Criteria andPicturesIsNull() {
            addCriterion("pictures is null");
            return (Criteria) this;
        }

        public Criteria andPicturesIsNotNull() {
            addCriterion("pictures is not null");
            return (Criteria) this;
        }

        public Criteria andPicturesEqualTo(Integer value) {
            addCriterion("pictures =", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesNotEqualTo(Integer value) {
            addCriterion("pictures <>", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesGreaterThan(Integer value) {
            addCriterion("pictures >", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesGreaterThanOrEqualTo(Integer value) {
            addCriterion("pictures >=", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesLessThan(Integer value) {
            addCriterion("pictures <", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesLessThanOrEqualTo(Integer value) {
            addCriterion("pictures <=", value, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesIn(List<Integer> values) {
            addCriterion("pictures in", values, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesNotIn(List<Integer> values) {
            addCriterion("pictures not in", values, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesBetween(Integer value1, Integer value2) {
            addCriterion("pictures between", value1, value2, "pictures");
            return (Criteria) this;
        }

        public Criteria andPicturesNotBetween(Integer value1, Integer value2) {
            addCriterion("pictures not between", value1, value2, "pictures");
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