use qdDemo;
select * from goodsBrief;
select * from goodsDetail;

-- 商品的详细记录信息
select 
goodsBrief.id,
goodsBrief.goodName,
goodsBrief.shopid,
goodsBrief.pictures,

goodsDetail.goodColor,
goodsdetail.goodSize,
goodsDetail.goodPrice,
goodsDetail.goodRemainCount,
goodsDetail.pictures as goodsDetailPictures
from goodsBrief
Inner JOIN goodsDetail
on goodsBrief.id=goodsDetail.goodBriefId;