package org.bjc.hi.hdc.data.bean;

/**
 * Created by Kevin on 4/10/2016.
 */
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DOCUMENT_INDEX")
public class DocumentIndex {

    @Id
    @Column(name = "document_id")
    private String documentId;
    private String upi;
    private int usid;
    private Date eventTs;
    private Date reportTs;

    protected DocumentIndex() {}

    public DocumentIndex(String documentId, String upi, int usid, Date eventTs) {
        this.documentId = documentId;
        this.upi = upi;
        this.usid = usid;
        this.eventTs = eventTs;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DocumentIndex{");
        sb.append("documentId='").append(documentId).append('\'');
        sb.append(", upi='").append(upi).append('\'');
        sb.append(", usid=").append(usid);
        sb.append(", eventTs=").append(eventTs);
        sb.append(", reportTs=").append(reportTs);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentIndex that = (DocumentIndex) o;

        return documentId != null ? documentId.equals(that.documentId) : that.documentId == null;

    }

    @Override
    public int hashCode() {
        return documentId != null ? documentId.hashCode() : 0;
    }
}
