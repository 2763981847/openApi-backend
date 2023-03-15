-- 接口信息表
use openApi;
create table if not exists openApi.interface_info
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '用户名',
    `description` varchar(256) null comment '描述',
    `url` varchar(512) not null comment '接口地址',
    `request_header` text null comment '请求头',
    `response_header` text null comment '响应头',
    `user_id` bigint not null comment '创建人',
    `status` int default 0 not null comment '接口状态（0 - 关闭， 1 - 开启））',
    `method` varchar(256) not null comment '请求类型',
    `create_time` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_delete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
    ) comment '接口信息表';

insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('北科技大学', '练习', 'www.alysha-thiel.org', 'ix', 'LxyfV', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西北体育大学', '鸡', 'www.jimmy-harris.io', 'tc', 'E27w', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('东北体育大学', '练习', 'www.royal-okuneva.name', 'RowRU', 'Ag', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('北大学', '太', 'www.latia-upton.org', 'ZvuK', '65AP', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('北农业大学', '两年半', 'www.morris-krajcik.co', 'buBK', 'pF', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('南经贸大学', 'rap', 'www.addie-nikolaus.net', 'F0', 'DMM', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西南大学', '美', 'www.hiram-spinka.io', 'lmLIN', 'ul4U', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('东北技术大学', '练习', 'www.alana-little.io', 'vI4', 'GnkT', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('中国艺术大学', '跳', 'www.hester-ratke.co', '8eIcb', '2A', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西南经贸大学', '你', 'www.luke-weimann.co', '054xu', 'yK8pB', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西南艺术大学', '太', 'www.brenton-von.name', 'LOvy', 'Ijl', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('中国艺术大学', '个人练习生', 'www.helene-dare.net', '1IY', 'y5v', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西南技术大学', '蔡徐坤', 'www.charlena-bode.info', 'rX1iT', '81zFS', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('东南农业大学', 'music', 'www.manuel-hermiston.io', 'fti', 'oGivv', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('中国大学', '个人练习生', 'www.shad-crist.io', '6or3', 'qKLXd', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('东北技术大学', '蔡徐坤', 'www.dusty-gulgowski.io', 'kd', 'rH', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('东北技术大学', 'music', 'www.alonzo-leannon.io', 'J8', 'bCw', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('南经贸大学', '两年半', 'www.johnson-crona.com', 'xn3vN', 'FB', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('东南大学', '跳', 'www.pat-hill.info', '6o', 'pF', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('东理工大学', '美', 'www.bert-heathcote.co', 'Jt5W', '9h43', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('北经贸大学', '两年半', 'www.sherry-bartell.io', '9pnD', 'tu', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西北体育大学', '美', 'www.dian-carter.biz', '7xUD', '9743P', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('南技术大学', 'music', 'www.napoleon-cartwright.info', 'dijU', 'qf', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西南理工大学', '你', 'www.josefine-weber.io', 'kgc6q', 'err', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西艺术大学', '个人练习生', 'www.clarence-donnelly.com', 'iAV', 'eCh0W', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西北理工大学', '你', 'www.sadie-friesen.name', 'TCra', 'I4J5V', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('南科技大学', '你', 'www.quentin-deckow.info', 'aeU6V', 'YuKs', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('东经贸大学', '练习', 'www.larry-hermiston.com', 'SI', 'QLV', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('西体育大学', '太', 'www.malik-kuhlman.biz', 'Lddh', 'ct', 1, 0, 'get', 0);
insert into openApi.`interface_info` (`name`, `description`, `url`, `request_header`, `response_header`, `user_id`, `status`, `method`, `is_delete`) values ('北农业大学', '美', 'www.rocky-vonrueden.name', 'Ripar', 'hbgX', 1, 0, 'get', 0);