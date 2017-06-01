-- use qdDemo;
-- select * from userinfo;
-- select * from goodsBrief;
-- select * from goodsDetail;
-- select * from shop;
-- 
-- select * from goodsBrief join goodsDetail on goodsBrief.id=goodsDetail.goodBriefId where goodsBrief.id=1; 

-- 单个商品的关联查询
select goodsBrief.id as goodBriefId,goodName,goodsBrief.pictures as goodBriefPicture,shopid,
-- goodsDetail.goodColor,goodsDetail.goodPrice,goodsDetail.goodSize,goodsDetail.goodRemainCount
-- from goodsBrief join goodsDetail on goodsBrief.id=goodsDetail.goodBriefId where goodsBrief.id=1; 


-- 所有商品的关联查询-- 
select goodsBrief.id as goodBriefId,goodName,goodsBrief.pictures as goodBriefPicture,shopid,
goodsDetail.goodColor,goodsDetail.goodPrice,goodsDetail.goodSize,goodsDetail.goodRemainCount
from goodsBrief join goodsDetail on goodsBrief.id=goodsDetail.goodBriefId; 