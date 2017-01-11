/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise20_7;

/**
 *
 * @author Rin's
 */
public class Students {

    private String id;
    private String course;
    private float mark;
    private String type;

    public Students(String id, String course, float mark, String type) {
        this.id = id;
        this.course = course;
        this.mark = mark;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object[] toObject() {
        return new Object[]{id, course, mark, type};
    }

    @Override
    public boolean equals(Object obj) {
        Students st = (Students)obj;
        return st.id.equalsIgnoreCase(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
