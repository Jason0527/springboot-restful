-- Create table
create table HERO
(
  id       VARCHAR2(64) not null,
  name     VARCHAR2(100),
  type     VARCHAR2(64),
  sign     VARCHAR2(500),
  variable VARCHAR2(64),
  price    NUMBER(4)
);
-- Add comments to the columns 
comment on column HERO.id
  is '主键id';
comment on column HERO.name
  is '英雄名';
comment on column HERO.type
  is '定位';
comment on column HERO.sign
  is '标签/台词';
comment on column HERO.variable
  is '变量';
comment on column HERO.price
  is '售价';
-- Create/Recreate primary, unique and foreign key constraints 
alter table HERO
  add primary key (ID);
  
-- Create table
create table RECORD
(
  id          VARCHAR2(64) not null,
  type        VARCHAR2(1),
  hero_name   VARCHAR2(64),
  skin_grade  VARCHAR2(1),
  money       NUMBER(4),
  total_money NUMBER(6),
  user_no     VARCHAR2(64),
  create_date DATE
);
-- Add comments to the columns 
comment on column RECORD.id
  is '主键id';
comment on column RECORD.type
  is '消费类型  1-购买英雄  2-购买皮肤';
comment on column RECORD.hero_name
  is '英雄名称';
comment on column RECORD.skin_grade
  is '皮肤等级';
comment on column RECORD.money
  is '本次消费金额';
comment on column RECORD.total_money
  is '游戏公司总收入';
comment on column RECORD.user_no
  is '消费账户';
comment on column RECORD.create_date
  is '记录创建时间（交易时间）';
-- Create/Recreate primary, unique and foreign key constraints 
alter table RECORD
  add primary key (ID);
  
-- Create table
create table SKIN
(
  id          VARCHAR2(64) not null,
  hero_name   VARCHAR2(64) not null,
  grade       VARCHAR2(1),
  description VARCHAR2(64),
  price       NUMBER(4)
);
-- Add comments to the columns 
comment on column SKIN.id
  is '主键id';
comment on column SKIN.hero_name
  is '所属英雄名';
comment on column SKIN.grade
  is '皮肤等级1-传说  2-史诗  3-王者';
comment on column SKIN.description
  is '等级描述 传说/史诗/王者';
comment on column SKIN.price
  is '出售价格';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SKIN
  add primary key (ID);
  
-- Create table
create table USER_ASSET
(
  id         VARCHAR2(64) not null,
  user_no    VARCHAR2(64),
  type       VARCHAR2(64),
  hero_name  VARCHAR2(64),
  skin_grade VARCHAR2(64)
);
-- Add comments to the columns 
comment on column USER_ASSET.id
  is '主键id';
comment on column USER_ASSET.user_no
  is '用户账号';
comment on column USER_ASSET.type
  is '资产类型  1-英雄  2-皮肤';
comment on column USER_ASSET.hero_name
  is '英雄名';
comment on column USER_ASSET.skin_grade
  is '皮肤等级';
-- Create/Recreate primary, unique and foreign key constraints 
alter table USER_ASSET
  add primary key (ID);
  
-- Create table
create table USER_SEN
(
  id       VARCHAR2(64) not null,
  name     VARCHAR2(64),
  age      VARCHAR2(3),
  user_no  VARCHAR2(64),
  password VARCHAR2(64),
  account  NUMBER(6)
);
-- Add comments to the columns 
comment on column USER_SEN.id
  is '主键id';
comment on column USER_SEN.name
  is '姓名';
comment on column USER_SEN.age
  is '年龄';
comment on column USER_SEN.user_no
  is '用户号';
comment on column USER_SEN.password
  is '密码';
comment on column USER_SEN.account
  is '账户余额';
-- Create/Recreate primary, unique and foreign key constraints 
alter table USER_SEN
  add primary key (ID);




  
  
