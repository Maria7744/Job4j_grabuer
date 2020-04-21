package parserSV;

import java.util.Objects;

public class Vacancy {

    public String text;
    /*   NodeBase(int id,String name, String text, String link) {
                this.id = id;
                this.name = name;
                 this.text = text;
                 this.link = link;
        }
             int id;
            String name;
            String text;
            String link;
        }*/
     public int id;
    public String name;

    public String link;

    public Vacancy(String name, String text,String link) {
        this.name = name;
        this.text = text;
        this.link = link;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vacancy)) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(name, vacancy.name)
                && Objects.equals(text, vacancy.text)
                && Objects.equals(link, vacancy.link);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, text, link);
    }


    @Override
    public String toString() {
        return "Vacancy{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", text='" + text + '\''
                + ", link='" + link

                + '}';
    }
}