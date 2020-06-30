package edu.agic.itblog.entity;

/**
 * @author lipeng
 * @email imleep@163.com
 * @date 2020/6/26 18:09
 */

/**
 * CREATE TABLE `t_blog_type` (
 * `typeid` char(32) NOT NULL,
 * `parentname` char(32) NOT NULL,
 * `typename` char(32) NOT NULL,
 * PRIMARY KEY (`typeid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class BlogTypeEty {

    String typeid; // PRIMARY KEY (`typeid`)
    String parentname;
    String typename;

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }
}
