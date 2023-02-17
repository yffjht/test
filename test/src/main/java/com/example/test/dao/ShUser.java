package com.example.test.dao;

import java.util.Objects;

public class ShUser {
    private Integer id;
    private  Integer uid;
    private  Integer sid;
    private  String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShUser shUser = (ShUser) o;
        return Objects.equals(id, shUser.id) && Objects.equals(uid, shUser.uid) && Objects.equals(sid, shUser.sid) && Objects.equals(detail, shUser.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, sid, detail);
    }

    @Override
    public String toString() {
        return "ShUser{" +
                "id=" + id +
                ", uid=" + uid +
                ", sid=" + sid +
                ", detail='" + detail + '\'' +
                '}';
    }
}
