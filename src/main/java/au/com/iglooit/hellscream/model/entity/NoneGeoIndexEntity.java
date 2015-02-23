package au.com.iglooit.hellscream.model.entity;

import com.google.appengine.api.search.Document;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Created by nicholaszhu on 21/02/2015.
 */
@Entity
@MappedSuperclass
public abstract class NoneGeoIndexEntity extends NoneGeoEntity {
    @Override
    public Document toFullTextDocument() {
        return null;
    }
}
