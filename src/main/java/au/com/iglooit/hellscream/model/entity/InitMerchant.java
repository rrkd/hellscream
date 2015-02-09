package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.search.Document;

import javax.persistence.Entity;

/**
 * Created by nicholaszhu on 9/02/2015.
 */
@Entity
public class InitMerchant extends BaseEntity {
    @Override
    public Document toFullTextDocument() {
        return null;
    }

    @Override
    public Document toGeoDocument() {
        return null;
    }
}
