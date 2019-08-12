CREATE TABLE sys_user
(
     id BIGINT(20) AUTO_INCREMENT COMMENT '用户ID',
     loginId VARCHAR(30) UNIQUE COMMENT '用户登陆ID',
     password VARCHAR(50),
     salt VARCHAR(20),
     userName VARCHAR(30) COMMENT '用户名称',
     deptId BIGINT(20) default null COMMENT '部门ID',
     email VARCHAR(30),
     phone VARCHAR(30),
     sex CHAR(1) DEFAULT '2',
     delFlag char(1) DEFAULT '0' COMMENT '1无效',
     lock char(1) DEFAULT '0' COMMENT '1锁',
     sortBy BIGINT(20),
     createTime DATETIME,
     updateTime DATETIME,
     PRIMARY KEY(id)
) engine=innodb comment = '用户信息表';

INSERT INTO sys_user(loginId, password, userName, salt) VALUES('admin', 'e663bcbce466b323fe5a3a966dc31638', 'admin','76fb549e2de8ee437b6b7fea0af83802');
INSERT INTO sys_user(loginId, password, userName, salt) VALUES('test', 'e663bcbce466b323fe5a3a966dc31638', 'test','76fb549e2de8ee437b6b7fea0af83802');

CREATE TABLE sys_menu
(
     id BIGINT(20) AUTO_INCREMENT COMMENT '菜单ID',
     menuName VARCHAR(30) COMMENT '菜单名称',
     menuType char(1) DEFAULT '0',
     menuIcon VARCHAR(100),
     menuPerm VARCHAR(255),
     menuUrl VARCHAR(255),
     menuDesc VARCHAR(255),
     parentId BIGINT(20) DEFAULT 0,
     delFlag char(1) DEFAULT '0' COMMENT '1无效',
     sortBy BIGINT(20),
     createTime DATETIME,
     updateTime DATETIME,
     PRIMARY KEY(id)
) engine=innodb comment = '菜单信息表';

INSERT INTO sys_menu(menuName, parentId, menuType) VALUES('系统管理', 0, 1);
INSERT INTO sys_menu(menuName, parentId, menuPerm) VALUES('用户管理', 1, 'system:user:view');
INSERT INTO sys_menu(menuName, parentId, menuPerm) VALUES('菜单管理', 1, 'system:menu:view');
INSERT INTO sys_menu(menuName, parentId, menuPerm) VALUES('角色管理', 1, 'system:role:view');
INSERT INTO sys_menu(menuName, parentId, menuPerm) VALUES('部门管理', 1, 'system:dept:view');

INSERT INTO sys_menu(menuName, parentId, menuType) VALUES('页面管理', 0, 1);
INSERT INTO sys_menu(menuName, parentId, menuPerm) VALUES('轮播管理', 6, 'system:banner:view');

CREATE TABLE sys_role
(
    id BIGINT(20) AUTO_INCREMENT COMMENT '角色ID',
    roleName VARCHAR(30) COMMENT '角色名称',
    delFlag char(1) DEFAULT '0' COMMENT '1无效',
    sortBy BIGINT(20),
    createTime DATETIME,
    updateTime DATETIME,
    PRIMARY KEY(id)
)engine=innodb comment = '角色信息表';

INSERT INTO sys_role(roleName) VALUES('admin');
INSERT INTO sys_role(roleName) VALUES('test');

CREATE TABLE sys_user_role
(
    userId BIGINT(20) not null,
    roleId BIGINT(20) not null,
    primary key(userId, roleId)
)engine=innodb comment = '用户角色关联表';

INSERT INTO sys_user_role(userId, roleId) VALUES(1,1);
INSERT INTO sys_user_role(userId, roleId) VALUES(1,2);
INSERT INTO sys_user_role(userId, roleId) VALUES(2,2);

create table sys_role_menu (
    roleId BIGINT(20) not null comment '角色ID',
    menuId BIGINT(20) not null comment '菜单ID',
    primary key(roleId, menuId)
) engine=innodb comment = '角色和菜单关联表';


INSERT INTO sys_role_menu(roleId, menuId) VALUES(1,2);
INSERT INTO sys_role_menu(roleId, menuId) VALUES(1,3);
INSERT INTO sys_role_menu(roleId, menuId) VALUES(1,4);
INSERT INTO sys_role_menu(roleId, menuId) VALUES(1,5);
INSERT INTO sys_role_menu(roleId, menuId) VALUES(1,7);

CREATE TABLE sys_dept
(
     id BIGINT(20) AUTO_INCREMENT COMMENT '组织ID',
     deptName VARCHAR(30) COMMENT '组织名称',
     parentId BIGINT(20) DEFAULT 0,
     delFlag char(1) DEFAULT '0' COMMENT '1无效',
     sortBy BIGINT(20),
     createTime DATETIME,
     updateTime DATETIME,
     PRIMARY KEY(id)
) engine=innodb comment = '组织信息表';

INSERT INTO sys_dept(deptName, parentId) VALUES('顶级部门', 0);
INSERT INTO sys_dept(deptName, parentId) VALUES('一级部门1', 1);
INSERT INTO sys_dept(deptName, parentId) VALUES('一级部门2', 1);
INSERT INTO sys_dept(deptName, parentId) VALUES('一级部门1子部门1', 2);
INSERT INTO sys_dept(deptName, parentId) VALUES('一级部门1子部门2', 2);
INSERT INTO sys_dept(deptName, parentId) VALUES('一级部门2子部门1', 3);
