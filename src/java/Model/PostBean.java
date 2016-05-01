/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.util.Date;
public class PostBean {
    private Integer post_id;
    private String post_title;
    private String description;
    private String picture;
    private String thumb;
    private String category;
    private Date created;
    private Date updated;

    public PostBean(Integer post_id, String post_title, String description, String picture, String thumb, String category, Date created, Date updated) {
        this.post_id = post_id;
        this.post_title = post_title;
        this.description = description;
        this.picture = picture;
        this.thumb = thumb;
        this.category = category;
        this.created = created;
        this.updated = updated;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getThumb() {
        return thumb;
    }

    public String getCategory() {
        return category;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    
}
