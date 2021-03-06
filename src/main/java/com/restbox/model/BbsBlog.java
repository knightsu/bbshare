package com.restbox.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.*;
import java.sql.Date;

@Entity
@Table(name = "blogs")
public class BbsBlog {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "blog_id", nullable = false, unique = true) @NotNull private Long id;

    private String username;
    private String category;

    @Size(max=100) private String title;
    @Column(name = "service_type") private String serviceType;
    @Column(name = "item_type") private String itemType;
    @Size(max=250) private String description;
    @Column(name = "doc_type") private String docType;
    @Column(name = "status_curr") private String status;
    private int charge;
    @Column(name = "create_date") private java.sql.Date createDate;
    @Column(name = "start_date") private java.sql.Timestamp startDate;
    @Column(name = "end_date") private java.sql.Timestamp endDate;
    private String zipcode;



    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bbsBlog")
    private Collection<Comment> comments = new LinkedHashSet<Comment>();

    public BbsBlog() {}


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
}
