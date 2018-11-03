/*
Navicat MySQL Data Transfer

Source Server         : 47.104.134.122
Source Server Version : 50722
Source Host           : 47.104.134.122:3306
Source Database       : yp_cms

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-11-03 15:15:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');
INSERT INTO `hibernate_sequence` VALUES ('185');

-- ----------------------------
-- Table structure for tp_company
-- ----------------------------
DROP TABLE IF EXISTS `tp_company`;
CREATE TABLE `tp_company` (
  `id` varchar(50) NOT NULL,
  `company_title` varchar(255) DEFAULT NULL,
  `company_weight` int(11) DEFAULT NULL,
  `company_video` varchar(255) DEFAULT NULL,
  `company_description` longtext,
  `company_picture` varchar(255) DEFAULT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `is_show` int(11) DEFAULT NULL,
  `states` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_company
-- ----------------------------
INSERT INTO `tp_company` VALUES ('150', '111', null, null, '', 'http://pbdwj52zy.bkt.clouddn.com/enterprisef30dde73460b43d49eb402268de9550c', '1', '2018-10-17 10:49:20', '1', '1', '2018-10-17 10:56:06', '1', '0');
INSERT INTO `tp_company` VALUES ('151', '公司活动', null, null, '', 'http://pbdwj52zy.bkt.clouddn.com/enterprise0872498e219e4832ac2151687488e2c6', '1', '2018-10-17 11:00:19', '0', '1', '2018-10-17 11:00:19', '1', '0');

-- ----------------------------
-- Table structure for tp_customer
-- ----------------------------
DROP TABLE IF EXISTS `tp_customer`;
CREATE TABLE `tp_customer` (
  `id` int(11) NOT NULL,
  `customer_name` varchar(50) DEFAULT NULL,
  `customer_wechat` varchar(50) DEFAULT NULL,
  `customer_phone` varchar(50) DEFAULT NULL,
  `customer_mail` varchar(50) DEFAULT NULL,
  `customer_message` longtext,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `is_show` int(11) DEFAULT NULL,
  `states` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_customer
-- ----------------------------
INSERT INTO `tp_customer` VALUES ('179', '哈哈', '18255555555', '18255555555', '2917886665@qq.com', '333333', '1', '2018-10-17 11:39:10', '0', '1', '2018-10-17 11:39:10', '1', '0');
INSERT INTO `tp_customer` VALUES ('180', '哈哈', '18255555555', '18255555555', '2917886665@qq.com', '333333', '1', '2018-10-17 11:42:19', '0', '1', '2018-10-17 11:42:19', '1', '0');

-- ----------------------------
-- Table structure for tp_job
-- ----------------------------
DROP TABLE IF EXISTS `tp_job`;
CREATE TABLE `tp_job` (
  `id` int(11) NOT NULL,
  `job_name` varchar(255) DEFAULT NULL,
  `job_dept` varchar(50) DEFAULT NULL,
  `job_location` varchar(50) DEFAULT NULL,
  `job_year` varchar(50) DEFAULT NULL,
  `job_dictate` longtext,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `is_show` int(11) DEFAULT NULL,
  `job_eduction` varchar(255) DEFAULT NULL,
  `states` int(11) DEFAULT NULL,
  `job_num` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_job
-- ----------------------------
INSERT INTO `tp_job` VALUES ('177', '运维工程师', '工程部', '合肥', '3年', '<p>1.负责公司全栈运维体系中的监控工作；</p><p>2.负责处理用户服务请求事件；</p><p>3.负责协助完善监控体系&nbsp;；</p><p>4.负责监控报警事件的处理。</p><p>任职要求：</p><p>1、本科或本科以上学历，计算机相关专业；</p><p>2、2年以上&nbsp;IT&nbsp;行业工作经验；&nbsp;1年以上系统运维监控经验；</p><p>3、熟悉windows/linux操作系统；</p><p>4、熟悉中间件工作原理，对JBOSS/JETTY/Redis/nginx/kafka有一定了解，具备一定的操作能力；</p><p>5、熟悉SQL语法，了解mysql和oracle数据库；</p><p>6、至少熟悉&nbsp;java/php/python/bash/shell&nbsp;一种或多种语言，可独立编写维护及监控脚本；</p><p>7、熟悉APM监控理念；</p><p>8、至少熟悉zabbix/pinpoint/一种监控体系，具备独立部署能力，有部署经验；</p><p>9、有强烈的求知欲和钻研技巧，具有良好的独立分析问题与迅速解决问题的能力；</p><p>10、有良好的职业责任心和团队协作意识；</p><p>11、能适应7*24小时三班倒工作时间。</p>', '1', '2018-10-17 11:36:17', '0', '1', '2018-10-17 11:36:17', '1', '本科', '0', '2');
INSERT INTO `tp_job` VALUES ('178', 'java工程师', '工程部', '合肥', '3年', '<p>1、负责金融业务系统的设计及开发工作</p><p>2、负责业务需求的沟通，负责所属功能模块详细设计，代码开发，业务功能实现与单元测试，系统维护；</p><p>3、参与业务相关模块的的功能规划、需求分析设计、技术实现、灰度发布；</p><p>4、协助并完成其他各类技术开发任务。</p><p>任职要求：</p><p>1、熟练运用spring boot、spring MVC、spring cloud、spring theme、mybatis等进行开发，能够运用javascript/css/html5进行前端开发 ，会使用vue/react等前端框架；具备RAbbitMQ、redis、数据库 sql运用基础</p><p>2、 3-5年左右Java web开发经验，有支付或是金融行业开发有限考虑</p><p>3、 计算机等相关专业本科</p><p>4、 互金产品研发中心研发总监</p><p>5、 业务理解能力强，思维清晰，抗压能力强</p>', '1', '2018-10-17 11:37:25', '0', '184', '2018-10-25 16:54:58', '1', '大专', '0', null);

-- ----------------------------
-- Table structure for tp_news_dynamic
-- ----------------------------
DROP TABLE IF EXISTS `tp_news_dynamic`;
CREATE TABLE `tp_news_dynamic` (
  `id` bigint(20) NOT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_l09br4w3bp3tvsbhmwlxwfrwc` (`content`),
  UNIQUE KEY `UK_5wqth64duu5xi97y2ht3w2lgs` (`title`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_news_dynamic
-- ----------------------------

-- ----------------------------
-- Table structure for tp_news_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `tp_news_enterprise`;
CREATE TABLE `tp_news_enterprise` (
  `id` bigint(20) NOT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `content` longtext NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `states` int(11) DEFAULT NULL,
  `is_show` int(11) DEFAULT NULL,
  `indextype` varchar(255) DEFAULT '1',
  `type` varchar(255) DEFAULT '1',
  `picturenewslocation` varchar(255) DEFAULT '1',
  `picturenewstag` varchar(255) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_news_enterprise
-- ----------------------------
INSERT INTO `tp_news_enterprise` VALUES ('152', '1', '2018-10-17 11:06:49', '0', '1', '2018-10-20 15:29:03', '<p style=\"text-align: justify;\"><span>现在市场竞争十分激烈，如何正确理解和运用供应商采购管理系统相当关键！安徽尤品信息有限公司的小编来给大家说说。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><b><span>一、在线供应商管理系统是什么</span></b></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">1</span><span>、供应商是指那些向买方提供产品或服务并相应收取货币作为报酬的实体，是可以为企业生产提供原材料、设备、工具及其他资源的企业。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">2</span><span>、供应商管理系统搭建在企业生产过程中起着举足轻重的作用，是企业保持稳健发展的力量之源，供应商管理系统中只有拥有一个能够稳定的提供企业生产所需的原材料的供应商，才能保证企业在市场竞争中占据有利的地位，这就是企业迫切需要管理好与供应商之间关系的原因。</span><span lang=\"EN-US\"><o:p></o:p></span></p><h2 style=\"text-align: justify;\"><span>二、供应商<span lang=\"EN-US\">B2B</span>管理系统的重要性</span><span lang=\"EN-US\"><o:p></o:p></span></h2><p style=\"text-align: justify;\"><br></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">1</span><span>、<span lang=\"EN-US\">B2B</span>供应商管理系统开发是指通过对信息流、物流、资金流的控制，将采购企业、供应商、供应商的供应商连成一个有机整体的管理模式。供应商<span lang=\"EN-US\">B2B</span>管理系统选择是物流管理的重要环节，有效的<span lang=\"EN-US\">B2B</span>供应商管理系统，无论对整个物流来说，还是从单个的企业来看，都至关重要。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span>供应商管理系统已成为一种战略筹码，供应商<span lang=\"EN-US\">B2B</span>管理系统也成为造就企业竞争力的有效手段，谁拥有具有独特优势的供应商，谁就能赢得竞争优势。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">2</span><span>、加强对供应商团队的管理可以缩短交货期，提高产品质量，降低成本，提升企业在市场竞争中的应变能力。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">3</span><span>、搞好<span lang=\"EN-US\">B2B</span>供应商管理系统，建立科学合理的供应商选择及管理体系，不断优化企业的供应网络，对于提高供应商管理系统的效益，提高企业核心竞争力，有着重大的意义。</span><span lang=\"EN-US\"><o:p></o:p></span></p><h2 style=\"text-align: justify;\"><span>三、供应商管理系统和采购管理系统融合协调</span><span lang=\"EN-US\"><o:p></o:p></span></h2><p style=\"text-align: justify;\"><span>供应商管理系统一直是采购中的重要问题，标准的供应商采购管理系统流程可以划分为战略采购和订单协调两个环节：</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span>（<span lang=\"EN-US\">1</span>）战略采购包括供应商管理系统与开发；</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span>（<span lang=\"EN-US\">2</span>）订单协调则主要负责材料采购计划，重复订单以及交货付款方面的事务；供应商的管理系统是整个采购体系的核心，其表现也关系到整个采购部门的业绩。<span lang=\"EN-US\"><o:p></o:p></span></span></p><p style=\"text-align: justify;\"><br></p><h2 style=\"text-align: justify;\"><span>四、供应商采购管理系统与网络化管理</span><span lang=\"EN-US\"><o:p></o:p></span></h2><p style=\"text-align: justify;\"><span lang=\"EN-US\">1</span><span>、网络化管理主要是指在管理组织架构配合方面，将不同的信息点连接成网的管理方法。多事业部环境下的采购平台，需要满足不同事业部的采购需求，需求的差异性必须统一在一个更高适应性的统一体系内。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">2</span><span>、网络化的管理也体现在业务的客观性和流程的执行监督方面，监督机制体现在工作的各个环节，应尽量减少人为因素，加强操作和决策过程的透明化和制度化。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">3</span><span>、专业的电子商务商城网站开发公司尤品信息科技有限公司，专注为企业定制在线</span><span lang=\"EN-US\"><a href=\"http://www.shushangyun.com/b2b/\" target=\"http://www.sunnsoft.com/_blank\"><span lang=\"EN-US\"><span lang=\"EN-US\">供应商采购管理系统</span></span></a></span><span>，支持各类移动端的操作，所有的单据和资料都支持导入导出，后期丰富的报表节省大量时间成本。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span>尤品搭建<span lang=\"EN-US\">B2B</span>供应商采购管理系统致力于解决中小企业的库存管理问题，帮助企业实现零库存，让资金的周转再也不会出现问题。</span><span lang=\"EN-US\"><o:p></o:p></span></p><h2 style=\"text-align: justify;\"><span>五、开发一个供应商采购<span lang=\"EN-US\">B2B</span>系统对企业的意义</span><span lang=\"EN-US\"><o:p></o:p></span></h2><p style=\"text-align: justify;\"><span lang=\"EN-US\">1</span><span>、制作供应商采购管理系统保证企业产品质量，降低成本，提高企业盈利能力。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">2</span><span>、供应商采购系统开发优化采购流程，提高采购运作效率提高企业快速响应能力。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">3</span><span>、供应商采购<span lang=\"EN-US\">B2B</span>管理系统以供应商为中心，通过对供应商的全过程评估管理，为企业建立合格供应商库，并且自动关联合作单位基本信息、历史合作情况、履约情况、评估等信息，通过不断的积累和更新，实现企业与供应商之间的合作关系，从单次合作关系升级到战略合作联盟关系，降低企业项目运作风险。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">4</span><span>、供应商采购系统达到供应商的可控、可管、可查的目的。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">5</span><span>、采购供应管理系统提高采购流程的项目运转能力，促使供应商不再“优柔寡断”转变为“干净利落”。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">6</span><span>、搭建供应商协同平台，为供应商质量问题改进交互及跟踪提供平台支撑。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p style=\"text-align: justify;\"><span lang=\"EN-US\">7</span><span>、实现元器件进货检验标准、供应商评价模型、评价方法、准入流程等业务标准化<span lang=\"EN-US\">IT</span>固化。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p>\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n</p><p style=\"text-align: justify;\"><span>管理供应商关系不是一蹴而就的，需要长期摸索，不断创新。如今供应链发展越来越迅速，我们要努力与供应商建立起坚固的关系，这样我们方能在市场竞争中不败之地。</span><span lang=\"EN-US\"><o:p></o:p></span></p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprise50cfb55f0499489aa16ffc16b261598f', '5个知识点理解在线B2B供应商采购管理系统是什么', '1', '1', '3', '1', '1', '0');
INSERT INTO `tp_news_enterprise` VALUES ('153', '1', '2018-10-17 11:07:07', '1', '1', '2018-10-17 11:07:22', '2222333', 'http://pbdwj52zy.bkt.clouddn.com/enterprisef80508ea8c914df2868553260a9b8375', '2222', '0', '1', '1', '1', '1', '0');
INSERT INTO `tp_news_enterprise` VALUES ('155', '1', '2018-10-17 11:09:12', '0', '1', '2018-10-17 11:09:12', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率。</p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprise3c90d3b166cb430b9366f812c8f1eedf', '小程序未来发展趋势', '0', '1', '2', '2', '1', '0');
INSERT INTO `tp_news_enterprise` VALUES ('156', '1', '2018-10-17 11:10:33', '0', '1', '2018-10-17 11:10:33', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterpriseb2b93a7d0bb3420aa9a37e691a44d45d', '小程序未来发展趋势', '0', '1', '3', '1', '1', '0');
INSERT INTO `tp_news_enterprise` VALUES ('157', '1', '2018-10-17 11:11:01', '0', '184', '2018-10-25 16:50:03', '<p><img src=\"http://pbdwj52zy.bkt.clouddn.com/enterpriseb5019db907e24ad6992ccae2368cff4c\" alt=\"22.png\">自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprisec73e5b25665c461c829b25ad2521e873', '小程序未来发展趋势', '0', '1', '3', '1', '1', '0');
INSERT INTO `tp_news_enterprise` VALUES ('158', '1', '2018-10-17 11:12:24', '1', '1', '2018-10-20 14:12:04', '<p style=\"text-align: left;\"><img src=\"http://pbdwj52zy.bkt.clouddn.com/enterprisef33b7489c2f54d13b877c3487182c050\" alt=\"33.png\"></p><p style=\"text-align: left;\"><br></p><p style=\"text-align: left;\"><img src=\"http://localhost/layui/layui/images/face/2.gif\" alt=\"[哈哈]\">自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprisec4b016141a6e4c13af25bc38c8324375', '小程序未来发展趋', '1', '0', '2', '2', '1', '0');
INSERT INTO `tp_news_enterprise` VALUES ('159', '1', '2018-10-17 11:12:51', '1', '1', '2018-10-20 11:51:21', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprise3e4e01ac7cb64fde85e4ec1f12480018', '未来发展', '0', '1', '1', '2', '1', '0');
INSERT INTO `tp_news_enterprise` VALUES ('160', '1', '2018-10-17 11:17:16', '0', '1', '2018-10-17 11:17:16', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprise34fee01011664cb4b424c280164edc3e', '小程序发展', '0', '1', '2', '1', '1', '1');
INSERT INTO `tp_news_enterprise` VALUES ('161', '1', '2018-10-17 11:17:50', '0', '1', '2018-10-17 11:17:50', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprisec226d513da454a5eb772a388523c8e3d', '小程序', '0', '1', '3', '1', '2', '1');
INSERT INTO `tp_news_enterprise` VALUES ('162', '1', '2018-10-17 11:18:23', '0', '1', '2018-10-17 11:18:23', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprised890910c7e8f4e76b7da05465ff9a75a', '小程序', '0', '1', '3', '1', '3', '1');
INSERT INTO `tp_news_enterprise` VALUES ('163', '1', '2018-10-17 11:19:20', '0', '1', '2018-10-17 11:19:20', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprise609d591f04a64e98bce84bbcf86aa08e', '小程序', '0', '1', '2', '2', '1', '1');
INSERT INTO `tp_news_enterprise` VALUES ('164', '1', '2018-10-17 11:19:51', '0', '1', '2018-10-17 11:19:51', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprised9c967d795f1439ab4dbb588515a4a43', '小程序', '0', '1', '2', '2', '3', '1');
INSERT INTO `tp_news_enterprise` VALUES ('165', '1', '2018-10-17 11:20:55', '0', '1', '2018-10-17 11:20:55', '<p>自从小程序上线后，我们就一直在强调小程序名字的重要性。一方面，小程序的名称具有唯一性，另一方面，一个好的名字直接决定了小程序被用户搜索到的概率&nbsp;</p><p><br></p><p>小程序目前的用户情况，基本符合技术采用周期模型中早期采用者的情况。小程序的用户群体，还在从爱尝鲜、喜欢冒险的早期采用者，向早期大众渗透的过程中。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprise7986aa42122442d2863099f50fa3da5c', '小程序', '0', '1', '2', '2', '2', '1');

-- ----------------------------
-- Table structure for tp_permission
-- ----------------------------
DROP TABLE IF EXISTS `tp_permission`;
CREATE TABLE `tp_permission` (
  `id` bigint(20) NOT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` enum('menu','button') DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_permission
-- ----------------------------
INSERT INTO `tp_permission` VALUES ('403', '1', '2018-10-12 14:16:47', '0', '1', '2018-10-15 11:06:58', '', '权限分类添加', null, null, null, null, '/manager/permission/type/add');
INSERT INTO `tp_permission` VALUES ('404', '1', '2018-10-12 14:17:56', '0', '1', '2018-10-15 11:06:58', '', '权限分类删除', null, null, null, null, '/manager/permission/type/delete');
INSERT INTO `tp_permission` VALUES ('410', '1', '2018-10-12 15:06:00', '0', '1', '2018-10-15 11:06:58', '', '权限分类', null, null, null, null, '/manager/permission/type/list');
INSERT INTO `tp_permission` VALUES ('419', '1', '2018-10-12 15:40:14', '0', '1', '2018-10-15 11:06:58', '', '角色添加', null, null, null, null, '/manager/role/add');
INSERT INTO `tp_permission` VALUES ('420', '1', '2018-10-12 15:46:27', '0', '1', '2018-10-15 11:06:58', '', '角色删除', null, null, '/manager/role/del', null, '/manager/role/del');
INSERT INTO `tp_permission` VALUES ('421', '1', '2018-10-12 15:49:39', '0', '1', '2018-10-15 11:06:58', '', '角色列表', null, null, '/manager/role/list', null, '/manager/role/list');
INSERT INTO `tp_permission` VALUES ('422', '1', '2018-10-12 15:50:16', '0', '1', '2018-10-15 11:06:58', '', '权限管理列表', null, null, '/manager/permission/list', null, '/manager/permission/list');
INSERT INTO `tp_permission` VALUES ('423', '1', '2018-10-12 15:50:26', '0', '1', '2018-10-15 11:06:58', '', '权限管理添加', null, null, '/manager/permission/add', null, '/manager/permission/add');
INSERT INTO `tp_permission` VALUES ('424', '1', '2018-10-12 15:51:02', '0', '1', '2018-10-15 11:06:58', '', '管理员列表', null, null, '/manager/list', null, '/manager/list');
INSERT INTO `tp_permission` VALUES ('425', '1', '2018-10-12 15:56:54', '0', '1', '2018-10-15 11:06:58', '', '管理员添加', null, null, '/manager/add', null, '/manager/add');
INSERT INTO `tp_permission` VALUES ('426', '1', '2018-10-12 16:20:27', '0', '1', '2018-10-12 16:20:27', '', '调到编辑页面', null, null, '/manager/permission/type/edit', null, '/manager/permission/type/edit');
INSERT INTO `tp_permission` VALUES ('427', '1', '2018-10-12 16:20:58', '0', '1', '2018-10-12 16:20:58', '', '提交编辑', null, null, '/manager/permission/type/type/edit', null, '/manager/permission/type/type/edit');
INSERT INTO `tp_permission` VALUES ('428', '1', '2018-10-12 16:23:04', '0', '1', '2018-10-12 16:23:04', '', '批量删除', null, null, '/manager/permission/type/del/add', null, '/manager/permission/type/del/add');
INSERT INTO `tp_permission` VALUES ('430', '1', '2018-10-12 16:27:33', '0', '1', '2018-10-12 16:27:33', '', '提交角色按钮', null, null, '/manager/user/add', null, '/manager/user/add');
INSERT INTO `tp_permission` VALUES ('45', '1', '2018-10-15 09:09:08', '0', '1', '2018-10-15 09:09:08', '', '调到编辑页面', null, null, '/manager/permission/type/edit', null, '/manager/permission/type/edit');
INSERT INTO `tp_permission` VALUES ('154', '1', '2018-10-17 11:08:27', '0', '1', '2018-10-17 11:08:27', '', '权限', null, null, null, null, '/company/del');

-- ----------------------------
-- Table structure for tp_permission_type
-- ----------------------------
DROP TABLE IF EXISTS `tp_permission_type`;
CREATE TABLE `tp_permission_type` (
  `permission_id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  KEY `FKbdevqb8yt6yc9k3cc8rnrr0jr` (`type_id`),
  KEY `FKkrx99hl1v4yo2lav4rb3abemi` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_permission_type
-- ----------------------------
INSERT INTO `tp_permission_type` VALUES ('403', '141');
INSERT INTO `tp_permission_type` VALUES ('404', '141');
INSERT INTO `tp_permission_type` VALUES ('410', '141');
INSERT INTO `tp_permission_type` VALUES ('419', '417');
INSERT INTO `tp_permission_type` VALUES ('420', '417');
INSERT INTO `tp_permission_type` VALUES ('421', '417');
INSERT INTO `tp_permission_type` VALUES ('422', '418');
INSERT INTO `tp_permission_type` VALUES ('423', '418');
INSERT INTO `tp_permission_type` VALUES ('424', '416');
INSERT INTO `tp_permission_type` VALUES ('425', '416');
INSERT INTO `tp_permission_type` VALUES ('426', '141');
INSERT INTO `tp_permission_type` VALUES ('427', '141');
INSERT INTO `tp_permission_type` VALUES ('428', '418');
INSERT INTO `tp_permission_type` VALUES ('430', '416');
INSERT INTO `tp_permission_type` VALUES ('45', '418');
INSERT INTO `tp_permission_type` VALUES ('154', '141');

-- ----------------------------
-- Table structure for tp_products
-- ----------------------------
DROP TABLE IF EXISTS `tp_products`;
CREATE TABLE `tp_products` (
  `id` bigint(20) NOT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `describes` text,
  `pictures` text,
  `product_name` varchar(255) DEFAULT NULL,
  `product_typeid` varchar(255) DEFAULT NULL,
  `product_type_names` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4jt89mt85epx0cee7t4qyvgf4` (`product_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_products
-- ----------------------------
INSERT INTO `tp_products` VALUES ('169', '1', '2018-10-17 11:28:57', '0', '1', '2018-10-17 11:33:38', '<p>微信</p><p>小程序</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprisebace876bb2e34cdaa55354f41d0bac2b', '小程序', '144', 'B2B2电商平台');
INSERT INTO `tp_products` VALUES ('171', '1', '2018-10-17 11:29:31', '0', '1', '2018-10-17 11:29:31', '<p>微信小程序基于物联网智能技术，顾客可以很方便的下单。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterpriseeab516d01d4b4bdb98b87d36e103053a', '尤品商城', '144', 'B2B2电商平台');
INSERT INTO `tp_products` VALUES ('172', '1', '2018-10-17 11:30:22', '0', '1', '2018-10-17 11:30:22', '<p>微信小程序基于物联网智能技术，顾客可以很方便的下单。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprisef4c7d128895b4931a18141d105d737a2', '产品2', '143', '微信/APP定制开发');
INSERT INTO `tp_products` VALUES ('173', '1', '2018-10-17 11:30:37', '0', '1', '2018-10-17 11:30:37', '<p>微信小程序基于物联网智能技术，顾客可以很方便的下单。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterprise69dfadafe50c47b0bba6b9431e40d905', '产品3', '143', '微信/APP定制开发');
INSERT INTO `tp_products` VALUES ('175', '1', '2018-10-17 11:30:57', '0', '1', '2018-10-17 11:30:57', '<p>微信小程序基于物联网智能技术，顾客可以很方便的下单。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterpriseb168e18261ca4ed0baa1973844c42e11', '产品4', '143', '微信/APP定制开发');
INSERT INTO `tp_products` VALUES ('176', '1', '2018-10-17 11:31:18', '0', '1', '2018-10-17 11:31:18', '<p>微信小程序基于物联网智能技术，顾客可以很方便的下单。</p>', 'http://pbdwj52zy.bkt.clouddn.com/enterpriseaf7ed9e6a3864f08925bf9aacc6d2beb', '产品5', '145', '企业综合管理系统');

-- ----------------------------
-- Table structure for tp_product_type
-- ----------------------------
DROP TABLE IF EXISTS `tp_product_type`;
CREATE TABLE `tp_product_type` (
  `id` bigint(20) NOT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `type_weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9q70psikwsf3x2ddweh5pdahh` (`type_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_product_type
-- ----------------------------
INSERT INTO `tp_product_type` VALUES ('144', '1', '2018-10-16 15:33:41', '0', '1', '2018-10-16 15:33:41', 'B2B2电商平台', '2');
INSERT INTO `tp_product_type` VALUES ('143', '1', '2018-10-16 15:33:24', '0', '1', '2018-10-16 15:33:24', '微信/APP定制开发', '1');
INSERT INTO `tp_product_type` VALUES ('145', '1', '2018-10-16 15:33:56', '0', '1', '2018-10-16 15:33:56', '企业综合管理系统', '3');

-- ----------------------------
-- Table structure for tp_role
-- ----------------------------
DROP TABLE IF EXISTS `tp_role`;
CREATE TABLE `tp_role` (
  `id` bigint(20) NOT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_role
-- ----------------------------
INSERT INTO `tp_role` VALUES ('1', '1', '2018-10-12 14:12:31', '0', null, '2018-10-12 14:13:14', '', '管理员', '管理员');
INSERT INTO `tp_role` VALUES ('429', '1', '2018-10-12 16:25:59', '0', '1', '2018-10-15 15:54:24', '', '123', '市场部');
INSERT INTO `tp_role` VALUES ('86', '1', '2018-10-15 15:24:06', '0', '1', '2018-10-15 15:24:06', '', '123', 'ces');
INSERT INTO `tp_role` VALUES ('88', '1', '2018-10-15 15:52:42', '0', '1', '2018-10-15 15:54:08', '', '123', '市场部');
INSERT INTO `tp_role` VALUES ('96', '1', '2018-10-15 16:41:19', '0', '1', '2018-10-15 16:41:19', '', '只能看', '测试部');

-- ----------------------------
-- Table structure for tp_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `tp_role_permission`;
CREATE TABLE `tp_role_permission` (
  `permission_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKpwvekpicvv88muv2arusg0yfj` (`role_id`),
  KEY `FKrc29whm2fuao7h2h2ywwlux9b` (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_role_permission
-- ----------------------------
INSERT INTO `tp_role_permission` VALUES ('403', '1');
INSERT INTO `tp_role_permission` VALUES ('404', '1');
INSERT INTO `tp_role_permission` VALUES ('419', '1');
INSERT INTO `tp_role_permission` VALUES ('420', '1');
INSERT INTO `tp_role_permission` VALUES ('421', '1');
INSERT INTO `tp_role_permission` VALUES ('422', '1');
INSERT INTO `tp_role_permission` VALUES ('423', '1');
INSERT INTO `tp_role_permission` VALUES ('424', '1');
INSERT INTO `tp_role_permission` VALUES ('425', '1');
INSERT INTO `tp_role_permission` VALUES ('410', '1');
INSERT INTO `tp_role_permission` VALUES ('420', '429');
INSERT INTO `tp_role_permission` VALUES ('404', '429');
INSERT INTO `tp_role_permission` VALUES ('404', '88');
INSERT INTO `tp_role_permission` VALUES ('430', '1');
INSERT INTO `tp_role_permission` VALUES ('45', '1');
INSERT INTO `tp_role_permission` VALUES ('422', '429');
INSERT INTO `tp_role_permission` VALUES ('423', '429');
INSERT INTO `tp_role_permission` VALUES ('425', '429');
INSERT INTO `tp_role_permission` VALUES ('428', '429');
INSERT INTO `tp_role_permission` VALUES ('45', '429');
INSERT INTO `tp_role_permission` VALUES ('421', '96');
INSERT INTO `tp_role_permission` VALUES ('422', '96');
INSERT INTO `tp_role_permission` VALUES ('424', '96');
INSERT INTO `tp_role_permission` VALUES ('410', '96');

-- ----------------------------
-- Table structure for tp_type
-- ----------------------------
DROP TABLE IF EXISTS `tp_type`;
CREATE TABLE `tp_type` (
  `id` bigint(20) NOT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `del` int(11) NOT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_name` varchar(255) DEFAULT NULL,
  `type_weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pjdwkrw7iw371pdcrbuq0jvcf` (`name`),
  UNIQUE KEY `UK_9fjrvpyd5qt6sex7d7u7n89na` (`type_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_type
-- ----------------------------
INSERT INTO `tp_type` VALUES ('416', '1', '2018-10-12 15:38:24', '0', '1', '2018-10-15 11:09:39', '管理员列表', null, null);
INSERT INTO `tp_type` VALUES ('141', '1', '2018-10-10 11:06:42', '0', '1', '2018-10-15 11:10:06', '权限分类', null, null);
INSERT INTO `tp_type` VALUES ('417', '1', '2018-10-12 15:38:32', '0', '1', '2018-10-15 11:09:39', '角色管理', null, null);
INSERT INTO `tp_type` VALUES ('418', '1', '2018-10-12 15:38:41', '0', '1', '2018-10-15 11:09:39', '权限管理', null, null);
INSERT INTO `tp_type` VALUES ('74', '1', '2018-10-15 14:21:33', '1', '1', '2018-10-15 14:22:50', '222', null, null);

-- ----------------------------
-- Table structure for tp_user
-- ----------------------------
DROP TABLE IF EXISTS `tp_user`;
CREATE TABLE `tp_user` (
  `id` bigint(20) NOT NULL,
  `create_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `del` int(11) DEFAULT NULL,
  `update_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_b247myl9qk95g7ur6kxyshh7k` (`username`),
  KEY `FK8osyteox505ty3wx64nyymkjs` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_user
-- ----------------------------
INSERT INTO `tp_user` VALUES ('1', '1', '2018-10-06 14:23:26', '0', '1', '2018-10-15 16:30:37', '327855019@qq.com', '管理员', 'a6f317f43aa9eb8cc2d8181f98dae379a8e4d2ed0d15faa477ccfa2d', '17775309368', '0', 'admin', null, '1');
INSERT INTO `tp_user` VALUES ('431', '1', '2018-10-12 16:30:40', '0', '1', '2018-10-15 16:32:00', '32122@qq.com', 'ces', 'a6f317f43aa9eb8cc2d8181f98dae379a8e4d2ed0d15faa477ccfa2d', '15855556666', '0', 'test002', null, '86');
INSERT INTO `tp_user` VALUES ('66', '1', '2018-10-15 11:11:49', '0', '1', '2018-10-15 11:11:49', '13174061212@qq.com', '市场部，', 'a6f317f43aa9eb8cc2d8181f98dae379a8e4d2ed0d15faa477ccfa2d', '15026991630', '0', 'luhan', null, '429');
INSERT INTO `tp_user` VALUES ('97', '1', '2018-10-15 16:41:39', '0', '1', '2018-10-15 16:41:39', '654@qq.com', '测试部', '3c0b94cbefd7c98c5907bc7491a305eabbdc430200164eb4126f4af5', '15265421254', '0', 'test001', null, '96');
INSERT INTO `tp_user` VALUES ('149', '1', '2018-10-17 09:50:47', '0', '1', '2018-10-17 09:50:47', '321@qq.com', '管理员', '02794ee757d7fa27b115d11dcab4c4a4cdeccf595efcb286da55d4ad', '15866666666', '0', 'test123', null, '1');
INSERT INTO `tp_user` VALUES ('181', '1', '2018-10-17 11:44:15', '0', '1', '2018-10-17 11:44:15', '2222222222@qq.com', '市场部', '905182239c3ed126b224db879d1da57cf71fafc96531ca32e6af238a', '11111111111', '0', 'yp001', null, '429');
INSERT INTO `tp_user` VALUES ('183', '1', '2018-10-17 11:46:16', '0', '1', '2018-10-17 11:46:16', '7777777777@qq.com', '市场部', '855094640cdfd2baf25ee546654c9cfd612b4cbd42fcbff3de149262', '11111111111', '0', 'yp002', null, '429');
INSERT INTO `tp_user` VALUES ('184', '1', '2018-10-19 09:38:13', '0', '1', '2018-10-19 09:38:13', '1317406121@qq.com', '管理员', '608b1aab0c837cb77d2a2685437685735b67a2600abe8b04ddb0f7e1', '18601774257', '0', 'ypbhsc', null, '1');

-- ----------------------------
-- Table structure for tp_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tp_user_role`;
CREATE TABLE `tp_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKpcvo9mmiv13iepkpkmod666fi` (`role_id`),
  KEY `FK99yh78gyc0ab63i7m2mugq8w` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_user_role
-- ----------------------------
