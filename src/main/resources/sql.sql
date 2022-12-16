CREATE TABLE `t_promotion_module_coupon_package`
(
    `id`                   int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `page_id`              int(11) NOT NULL COMMENT '页面id',
    `module_id`            int(11) NOT NULL COMMENT '组件id',
    `limit_time_grab_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '每天限时开抢开关 1启用 0停用',
    `start_time`           varchar(20)           DEFAULT NULL COMMENT '开抢时间',
    `to_use_flag`          tinyint(1) NOT NULL DEFAULT '0' COMMENT '去使用跳转开关 1启用 0停用',
    `to_use_type`          int(11) DEFAULT NULL COMMENT '跳转类型 1跳转用券聚合页',
    `to_use_url`           varchar(255)          DEFAULT NULL COMMENT '跳转链接',
    `background_img_url`   varchar(255)          DEFAULT NULL COMMENT '券背景图',
    `delete_flag`          tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(0:否 1:是)',
    `create_time`          datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`          datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `create_author`        varchar(100) NOT NULL DEFAULT '' COMMENT '创建人',
    `update_author`        varchar(100) NOT NULL DEFAULT '' COMMENT '最后修改人',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_module_id` (`module_id`,`delete_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COMMENT='组件优惠券包关联主表';

CREATE TABLE `t_promotion_module_coupon_package_item`
(
    `id`               int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `module_id`        int(11) NOT NULL COMMENT '组件id',
    `coupon_type_code` varchar(255) NOT NULL COMMENT '优惠券类型编码',
    `coupon_name`      varchar(100)          DEFAULT NULL COMMENT '优惠券名称',
    `coupon_type`      int(11) DEFAULT NULL COMMENT '优惠券类型 1：现金券 2：免息券，4.还款券，5.租机满减券，6.PLUS会员费用减免券',
    `create_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `delete_flag`      tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除(0:否 1:是)',
    PRIMARY KEY (`id`),
    KEY                `module_coupon_type_code_idx` (`module_id`,`coupon_type_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=264 DEFAULT CHARSET=utf8mb4 COMMENT='优惠券包子表';


CREATE TABLE `t_promotion_module_coupon_package_user_record`
(
    `id`               int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `page_id`          int(11) NOT NULL COMMENT '页面id',
    `activity_id`      int(11) NOT NULL COMMENT '活动id',
    `module_id`        int(11) NOT NULL COMMENT '组件id',
    `user_id`          int(11) NOT NULL COMMENT '用户id',
    `coupon_type_code` varchar(255) NOT NULL COMMENT '优惠券类型编码',
    `coupon_code`      varchar(255) DEFAULT NULL COMMENT '返回的优惠券code',
    `result_status`    tinyint(2) NOT NULL DEFAULT '0' COMMENT '领取状态:1成功；0失败',
    `result_msg`       varchar(255) DEFAULT '' COMMENT '返回信息',
    `receive_time`     datetime     DEFAULT NULL COMMENT '领券时间',
    `create_time`      datetime     NOT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    KEY                `idx_module_id_user_id` (`module_id`,`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COMMENT='用户领取优惠券包记录表';