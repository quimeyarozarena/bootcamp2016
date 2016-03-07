package finalProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@ApiModel(value = "purchase entity", description = "Complete info of a entity purchase")
@Entity
@Table(name = "Purchases")
public class Purchase {

    @ApiModelProperty(value = "The id of the purchase", required = true)
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue
    private int id;

    @ApiModelProperty(value = "The date of the purchase", required = true)
    @Column(name = "datepurchase", nullable = false)
    private Date datepurchase;

    @ApiModelProperty(value = "The user of the purchase", required = true)
    @ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinColumn(name = "iduser", nullable = false) // FK
    // @JsonManagedReference(value = "user-purchase")
    // @JsonIgnore
    private User user;

    @ApiModelProperty(value = "The total of the purchase", required = true)
    @Column(name = "total", nullable = false)
    private double total;

    @ApiModelProperty(value = "The details belong to a purchase", required = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchase", cascade = { CascadeType.ALL })
    @JsonBackReference(value = "purchase-detailPurchase")
    public List<DetailPurchase> detailpurchases;

    public Purchase() {
        // TODO Auto-generated constructor stub
    }

    public Purchase(Date datepurchase, User user, double total) {
        this.datepurchase = datepurchase;
        this.user = user;
        this.total = total;
    }

    public Purchase(Date datepurchase, double total) {
        this.datepurchase = datepurchase;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatepurchase() {
        return datepurchase;
    }

    public void setDatepurchase(Date datepurchase) {
        this.datepurchase = datepurchase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetailPurchase> getDetailpurchases() {
        return detailpurchases;
    }

    public void setDetailpurchases(List<DetailPurchase> detailpurchases) {
        this.detailpurchases = detailpurchases;
    }

}
