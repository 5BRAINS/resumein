package ua.dou.hack.domain;

import javax.persistence.*;

/**
 * mocker on 21.02.15 at 18:14.
 */
@Entity
@Table(name = "Resumes", schema = "", catalog = "resumein")
public class Resume {
    private Integer id;
    private String link;
    private String path;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (id != null ? !id.equals(resume.id) : resume.id != null) return false;
        if (link != null ? !link.equals(resume.link) : resume.link != null) return false;
        if (path != null ? !path.equals(resume.path) : resume.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }
}
