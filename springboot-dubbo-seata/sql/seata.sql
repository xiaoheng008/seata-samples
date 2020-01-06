use seata;

create table t_good (
    id          bigint        not null auto_increment comment 'id',
    name        varchar(20)   not null comment '商品名称',
    price       bigint        not null comment '商品价格',
    number      int           not null comment '商品数量',
    create_time int           not null comment '创建时间',
    primary key(id)
) engine=Innodb default charset=utf8mb4 comment='商品库存表';
insert into t_good values(1, '苹果', 10, 10000, unix_timestamp());

create table t_good_log(
    log_id      bigint        not null auto_increment comment '库存日志表',
    good_id     bigint        not null comment '商品id',
    number      bigint        not null comment '操作的数量',
    before_number bigint      not null comment '操作前的数量',
    after_number bigint       not null comment '操作后的数量',
    oper        tinyint       not null comment '操作，1-减，2-加',
    status      tinyint       not null comment '状态：1-try，2-confirm，3-cancel',
    source      tinyint       not null comment '操作来源',
    order_id    bigint        not null comment '订单id',
    create_time int           not null comment '创建时间',
    update_time int           not null comment '更新时间',

    primary key(log_id),
    unique key ukey_source_order_id(source, order_id)
)engine=Innodb default charset=utf8mb4 comment='商品库存日志表';

create table t_wallet(
    uid         bigint        not null comment 'uid',
    balance     bigint        not null comment '余额',
    create_time int           not null comment '创建时间',
    update_time int           not null comment '更新时间',

    primary key(uid)
)engine=Innodb default charset=utf8mb4 comment='钱包表';
insert into t_wallet values(10000, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10001, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10002, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10003, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10004, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10005, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10006, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10007, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10008, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10009, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10010, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10011, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10012, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10013, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10014, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10015, 1000000, unix_timestamp(), unix_timestamp());
insert into t_wallet values(10016, 1000000, unix_timestamp(), unix_timestamp());

create table t_wallet_log(
    log_id      bigint        not null auto_increment comment '钱包日志表',
    uid         bigint        not null comment 'uid',
    amount      bigint        not null comment '操作的额度',
    before_amount bigint      not null comment '操作前的数量',
    after_amount bigint       not null comment '操作后的数量',
    oper        tinyint       not null comment '操作，1-减，2-加',
    status      tinyint       not null comment '状态：1-try，2-confirm，3-cancel',
    source      tinyint       not null comment '操作来源',
    order_id    bigint        not null comment '订单id',
    create_time int           not null comment '创建时间',
    update_time int           not null comment '更新时间',

    primary key(log_id),
    unique key ukey_source_order_id(source, order_id)
)engine=Innodb default charset=utf8mb4 comment='钱包日志表';

CREATE TABLE `t_good_order` (
    order_id      bigint        NOT NULL AUTO_INCREMENT COMMENT '订单id',
    uid           bigint        not null comment 'uid',
    good_id       bigint        not null comment '商品id',
    number        int           not null comment '数量',
    price         bigint        not null comment '单价',
    amount        bigint        not null comment '总金额',
    status        tinyint        not null comment '状态:1-try, 2-confirm, 3-cancel',
    remark        varchar(100)  not null comment '备注',
    create_time   int           not null comment '创建时间',
    update_time   int           not null comment '更新时间',

    PRIMARY KEY (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';



